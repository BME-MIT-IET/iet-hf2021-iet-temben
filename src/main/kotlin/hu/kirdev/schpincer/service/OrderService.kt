package hu.kirdev.schpincer.service

import hu.kirdev.schpincer.dao.ItemRepository
import hu.kirdev.schpincer.dao.OpeningRepository
import hu.kirdev.schpincer.dao.OrderRepository
import hu.kirdev.schpincer.dao.TimeWindowRepository
import hu.kirdev.schpincer.model.*
import hu.kirdev.schpincer.web.getUserId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*
import javax.servlet.http.HttpServletRequest

private val List<OrderEntity>.highestPriority: Int
    get() = this.maxBy { it.priority }?.priority ?: 1

enum class OrderStrategy(val representation: String) {
    ORDER_ABSOLUTE("absolute"),
    ORDER_GROUPED("grouped"),
    ORDER_ROOMS("rooms");
}

const val RESPONSE_NO_ROOM_SET = "NO_ROOM_SET"
const val RESPONSE_INTERNAL_ERROR = "INTERNAL_ERROR"
const val RESPONSE_NO_ORDERING = "NO_ORDERING"
const val RESPONSE_OVERALL_MAX_REACHED = "OVERALL_MAX_REACHED"
const val RESPONSE_MAX_REACHED = "MAX_REACHED"
const val RESPONSE_MAX_REACHED_EXTRA = "MAX_REACHED_EXTRA"
const val RESPONSE_CATEGORY_FULL = "CATEGORY_FULL"
const val RESPONSE_ACK = "ACK"
const val RESPONSE_BAD_REQUEST = "BAD_REQUEST"
const val RESPONSE_INVALID_STATUS = "INVALID_STATUS"
const val RESPONSE_ORDER_PERIOD_ENDED = "ORDER_PERIOD_ENDED"

@Service
open class OrderService {

    @Autowired
    internal lateinit var repo: OrderRepository

    @Autowired
    internal lateinit var openingRepo: OpeningRepository

    @Autowired
    internal lateinit var openings: OpeningService

    @Autowired
    internal lateinit var timewindowRepo: TimeWindowRepository

    @Autowired
    internal lateinit var itemsRepo: ItemRepository

    @Transactional
    open fun save(order: OrderEntity) {
        repo.save(order)
    }

    @Transactional(readOnly = true)
    open fun findAll(uid: String): List<OrderEntity> {
        return repo.findAllByUserIdOrderByDateDesc(uid)
    }

    @Transactional(readOnly = true)
    open fun getOne(id: Long): OrderEntity? {
        return repo.getOne(id)
    }

    @Transactional(readOnly = true)
    open fun findAllByOpening(openingId: Long): List<OrderEntity> {
        return repo.findAllByOpeningId(openingId)
    }

    @Transactional
    open fun updateOrder(id: Long, os: OrderStatus) {
        val order: Optional<OrderEntity> = repo.findById(id)
        if (order.isPresent()) {
            val orderEntity: OrderEntity = order.get()
            orderEntity.status = os
            repo.save(orderEntity)
        }
    }

    @Transactional(readOnly = true)
    open fun getCircleIdByOrderId(id: Long): Long? {
        val order: Optional<OrderEntity> = repo.findById(id)
        return order.map { orderEntity: OrderEntity -> openingRepo.getOne(orderEntity.openingId!!).circle?.id!! }.orElse(null)
    }

    @Transactional(readOnly = false)
    open fun reviewOrder(id: Long, reviewId: Long) {
        val order = getOne(id)!!
        order.reviewId = reviewId
        save(order)
    }

    @Transactional(readOnly = false)
    open fun makeOrder(user: UserEntity, id: Long, itemCount: Int, time: Long, comment: String, detailsJson: String): ResponseEntity<String> {
        val procedure = MakeOrderProcedure(user, id, itemCount, time, comment, detailsJson,
                itemsRepo = itemsRepo,
                openings = openings,
                timeWindowRepo = timewindowRepo)
        procedure.makeOrder()

        timewindowRepo.save(procedure.timeWindow)
        openings.save(procedure.current)
        this.save(procedure.order)
        return responseOf(RESPONSE_ACK)
    }

    @Transactional(readOnly = false)
    open fun cancelOrder(request: HttpServletRequest, id: Long): ResponseEntity<String> {
        return try {
            val order = getOne(id)
            if (order!!.userId != request.getUserId())
                return responseOf(RESPONSE_BAD_REQUEST, HttpStatus.BAD_REQUEST)

            if (order.status !== OrderStatus.ACCEPTED)
                return responseOf(RESPONSE_INVALID_STATUS)

            val opening = openings.getOne(order.openingId!!)
            if (opening.orderEnd <= System.currentTimeMillis())
                return responseOf(RESPONSE_ORDER_PERIOD_ENDED)

            order.status = OrderStatus.CANCELLED
            val count = order.count
            val timeWindow = timewindowRepo.getOne(order.intervalId)
            timeWindow.normalItemCount = timeWindow.normalItemCount + count

            if (order.extraTag)
                timeWindow.extraItemCount = timeWindow.extraItemCount + count
            opening.orderCount -= count

            when (ItemCategory.of(order.category)) {
                ItemCategory.ALPHA -> opening.usedAlpha -= count
                ItemCategory.BETA -> opening.usedBeta -= count
                ItemCategory.GAMMA -> opening.usedGamma -= count
                ItemCategory.DELTA -> opening.usedDelta -= count
                ItemCategory.LAMBDA -> opening.usedLambda -= count
                ItemCategory.DEFAULT -> {
                }
            }

            timewindowRepo.save(timeWindow)
            openings.save(opening)
            save(order)
            responseOf(RESPONSE_ACK)
        } catch (e: Exception) {
            responseOf(RESPONSE_BAD_REQUEST, HttpStatus.BAD_REQUEST)
        }
    }

    open fun findToExport(openingId: Long, orderBy: String): List<OrderEntity> {
        return when (orderBy) {
            OrderStrategy.ORDER_ABSOLUTE.representation -> appendArtificialId(repo.findAllByOpeningIdAndStatusNotOrderByPriorityDescDateAsc(openingId, OrderStatus.CANCELLED))

            OrderStrategy.ORDER_GROUPED.representation -> appendArtificialId(repo.findAllByOpeningIdAndStatusNotOrderByIntervalIdAscPriorityDescDateAsc(openingId, OrderStatus.CANCELLED))

            OrderStrategy.ORDER_ROOMS.representation -> appendArtificialId(repo.findAllByOpeningIdAndStatusNot(openingId, OrderStatus.CANCELLED)
                    .groupBy { it.intervalId }
                    .entries
                    .map { intervals -> Pair(intervals.key, intervals.value.groupBy { it.room }) }
                    .toList()
                    .sortedBy { it.first }
                    .map { intervals ->
                        intervals.first to intervals.second
                                .toList()
                                .sortedBy { it.second.highestPriority }
                                .flatMap { it.second }
                    }
                    .flatMap { it.second }
            )

            else -> appendArtificialId(repo.findAllByOpeningIdAndStatusNotOrderByPriorityDescDateAsc(openingId, OrderStatus.CANCELLED))
        }
    }

    private fun appendArtificialId(source: List<OrderEntity>): List<OrderEntity> {
        var id = 1
        for (order in source)
            order.artificialTransientId = id++
        return source
    }

}

fun responseOf(body: String, status: HttpStatus = HttpStatus.OK) = ResponseEntity(body, status)
