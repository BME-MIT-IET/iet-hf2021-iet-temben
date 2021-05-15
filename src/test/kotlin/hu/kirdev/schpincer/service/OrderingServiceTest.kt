package hu.kirdev.schpincer.service

import hu.kirdev.schpincer.dao.ItemRepository
import hu.kirdev.schpincer.dao.TimeWindowRepository
import hu.kirdev.schpincer.model.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.*

@ExtendWith(MockitoExtension::class)
class OrderingServiceTest {

    @Mock
    lateinit var itemsRepo: ItemRepository

    @Mock
    lateinit var openings: OpeningService

    @Mock
    lateinit var timewindowRepo: TimeWindowRepository

    @Mock
    lateinit var user: UserEntity

    @Test
    fun makeValidOrder() {
        val service = spy(OrderService())

        val opening = OpeningEntity(30, maxOrder = 5, dateStart = 0, dateEnd = 0, orderStart = 0,
                orderEnd = System.currentTimeMillis() * 2, maxBeta = 10)
        whenever(openings.findNextOf(10)).thenReturn(opening)
        val timeWindow = TimeWindowEntity(opening = opening, name = "6:00-8:00", date = 12, normalItemCount = 5, extraItemCount = 4)
        whenever(timewindowRepo.getOne(40)).thenReturn(timeWindow)
        val item = ItemEntity(name = "name", category = 2, orderable = true, personallyOrderable = false,
                alias = "", circle = CircleEntity(10), price = 1200)
        whenever(itemsRepo.getOne(12)).thenReturn(item)

        doNothing().whenever(service).save(anyOrNull())

        whenever(user.uid).thenReturn("unique")
        whenever(user.room).thenReturn("SCH-1620")
        whenever(user.name).thenReturn("Test User")
        whenever(user.cardType).thenReturn(CardType.KB)
        whenever(user.orderingPriority).thenReturn(5)

        service.itemsRepo = itemsRepo
        service.timewindowRepo = timewindowRepo
        service.openings = openings

        service.makeOrder(user, 12, 2, 40, "comment", "{\"answers\": []}")

        verify(service, times(1)).save(anyOrNull())
        verify(timewindowRepo, times(1)).save(anyOrNull())
        verify(openings, times(1)).save(anyOrNull())
    }
}