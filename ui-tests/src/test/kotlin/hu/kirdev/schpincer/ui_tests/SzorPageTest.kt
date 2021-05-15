package hu.kirdev.schpincer.ui_tests

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SzorPageTest {
    private val szorPage = SzorPage()
    private val url = szorPage.url

    @BeforeEach
    fun setUpAll() {
        Configuration.browserSize = "1280x800"
        SelenideLogger.addListener("allure", AllureSelenide())
    }

    @BeforeEach
    fun setUp() {
        Selenide.open(url)
    }

    @Test
    fun testImprint() {
        val imprint = szorPage.imprint

        imprint.shouldBe(Condition.visible)
        assert(imprint.innerText().contains("Szolgáltató Reszort"))

        imprint.`$`("p").shouldBe(Condition.visible)
        val imprintText = imprint.`$`("p").innerText()
        assert(imprintText.isNotEmpty() && imprintText.isNotBlank())
    }

    @Test
    fun testCircles() {
        szorPage.circles.shouldBe(Condition.visible)

        szorPage.circleArticles.forEach { article ->
            article.shouldBe(Condition.visible)
            article.`$`(".image").shouldHave(Condition.image)
            article.`$`(".message h3").shouldBe(Condition.visible)
            article.`$`(".message p").shouldBe(Condition.visible)
        }
    }
}