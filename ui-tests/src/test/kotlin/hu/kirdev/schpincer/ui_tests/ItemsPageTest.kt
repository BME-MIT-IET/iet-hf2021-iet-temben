package hu.kirdev.schpincer.ui_tests

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class ItemsPageTest {
    private val itemsPage = ItemsPage()
    private val url = itemsPage.url

    @BeforeEach
    fun setUpAll() {
        Configuration.browserSize = "1280x800"
        SelenideLogger.addListener("allure", AllureSelenide())
    }

    @BeforeEach
    fun setUp() {
        open(url)
    }

    @Test
    fun testItems() {
        itemsPage.itemSet.shouldBe(Condition.visible)

        assert(itemsPage.items.size > 0)

        itemsPage.items.forEach { item ->
            item.shouldBe(Condition.visible)
            item.`$`(".picture").shouldBe(Condition.visible)
            item.`$`("h3").shouldBe(Condition.visible)
            item.`$`("table").shouldBe(Condition.visible)
            val providerLink = item.`$`("a.colored-light")
            providerLink.shouldBe(Condition.visible)
            assert(!providerLink.getAttribute("href").isNullOrBlank())
        }
    }

    @Test
    fun testItemPopup() {
        assert(itemsPage.items.size > 0)
        if (itemsPage.items.size == 0) {
            return
        }

        val item = itemsPage.items[0]
        item.`$`(".picture").click()
        sleep(1000)
        val popup = element("#popup-window")
        popup.shouldBe(Condition.visible)

        popup.`$`("h3").shouldBe(Condition.visible)
        assertEquals(popup.`$`("h3").innerText(), item.`$`("h3").innerText())

        popup.`$`(".info").shouldBe(Condition.visible)
        popup.`$`(".info .image").shouldBe(Condition.visible)
        popup.`$`("#popup-description").shouldBe(Condition.visible)

        val checkBoxes = elements("#popup-window .checkcontainer")
        checkBoxes.forEach { it.click() }

        val countInput = popup.`$`("#popup-count")
        countInput.shouldBe(Condition.visible)
        countInput.sendKeys("99999999999999\n")
        assertEquals(countInput.getAttribute("max"), countInput.getAttribute("value"))
    }

    @Test
    fun testSearchContainer() {
        itemsPage.searchContainer.shouldBe(Condition.visible)

        val searchInput = itemsPage.searchContainer.`$`("#search-input")
        searchInput.shouldBe(Condition.visible)
        searchInput.sendKeys("burger\n")
        assertEquals("burger", searchInput.getAttribute("value"))
        sleep(3000)

        val searchItems = elements("#item-set .item")
        assert(searchItems.size > 0)
    }
}