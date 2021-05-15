package hu.kirdev.schpincer.ui_tests

import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements
import hu.kirdev.schpincer.ui_tests.config.SeleniumConfig

class SzorPage {
    val url = SeleniumConfig.baseUrl + "szor"
    val imprint = element(".content").`$`(".highlighted")
    val circles = element(".circles")
    val circleArticles = elements(".article")
}