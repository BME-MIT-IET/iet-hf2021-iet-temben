package hu.kirdev.schpincer.ui_tests

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selectors.byXpath
import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MainPageTest {
    private val mainPage = MainPage()
    private val url = mainPage.url

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
    fun testHeader() {
        mainPage.header.shouldBe(visible)

        val headerLinks = mainPage.header.findElements(byXpath("//a[@class='long']")).map { it.getAttribute("href") }
        assertEquals(true, headerLinks.contains(url))
        assertEquals(true, headerLinks.contains(url + "szor"))
        assertEquals(true, headerLinks.contains(url + "items"))
        assertEquals(true, headerLinks.contains(url + "login"))
    }

    @Test
    fun testFooter() {
        mainPage.footer.shouldBe(visible)
        assertEquals(true, mainPage.footer.innerText().contains("Copyright ©"))
    }

    @Test
    fun testArticles() {
        mainPage.articlesContainer.shouldBe(visible)
        assertEquals(true, mainPage.articles.size > 0)
        mainPage.articles.forEach { article ->
            article.shouldBe(visible)
        }
    }
}
