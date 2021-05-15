package hu.kirdev.schpincer.ui_tests

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MainPageTest {
    private val mainPage = MainPage()

    @BeforeEach
    fun setUpAll() {
        Configuration.browserSize = "1280x800"
        SelenideLogger.addListener("allure", AllureSelenide())
    }

    @BeforeEach
    fun setUp() {
        open("https://schpincer.sch.bme.hu/")
    }

    @Test
    fun testHeader() {
        mainPage.header.shouldBe(visible)
    }
}
