package hu.kirdev.schpincer.ui_tests

import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements
import hu.kirdev.schpincer.ui_tests.config.SeleniumConfig

class MainPage {
    val url = SeleniumConfig.baseUrl
    val header = element(".header")
    val footer = element(".footer")
    val articlesContainer = element(".article-set")
    val articles = elements(".article-set")
}
