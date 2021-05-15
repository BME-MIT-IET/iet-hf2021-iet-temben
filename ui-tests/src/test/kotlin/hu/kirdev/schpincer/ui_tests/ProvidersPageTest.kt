package hu.kirdev.schpincer.ui_tests

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.logevents.SelenideLogger
import hu.kirdev.schpincer.ui_tests.config.SeleniumConfig
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ProvidersPageTest {
    private val url = SeleniumConfig.baseUrl

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
    fun testEachProvider() {
        val providerLinks = elements(".scroll-child > a")
        val providerUrls = mutableListOf<String>()
        for (providerLink in providerLinks) {
            val providerUrl = providerLink.getAttribute("href")
            assert(!providerUrl.isNullOrBlank())
            if (providerUrl.isNullOrBlank())
                continue
            providerUrls.add(providerUrl)
        }

        for (providerUrl in providerUrls) {
            open(providerUrl)
            element(".circle-profile").shouldBe(Condition.visible)
            element(".article-set").shouldBe(Condition.visible)
            element(".item-set").shouldBe(Condition.visible)

            val items = elements(".item-set .item")
            assert(items.size > 0)
            if (items.size == 0)
                continue

            val testItem = items[0]
            testItem.shouldBe(Condition.visible)
            testItem.`$`(".picture").shouldBe(Condition.visible)
            testItem.`$`("h3").shouldBe(Condition.visible)
            testItem.`$`("table").shouldBe(Condition.visible)


            testItem.`$`(".picture").click()
            sleep(1000)

            val popup = element("#popup-window")
            popup.shouldBe(Condition.visible)
            assertEquals(popup.`$`("h3").innerText(), testItem.`$`("h3").innerText())
        }
    }
}