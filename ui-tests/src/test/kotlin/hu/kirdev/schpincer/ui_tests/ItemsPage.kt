package hu.kirdev.schpincer.ui_tests

import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements
import hu.kirdev.schpincer.ui_tests.config.SeleniumConfig

class ItemsPage {
    val url = SeleniumConfig.baseUrl + "items"
    val searchContainer = element(".search-container")
    val itemSet = element("#item-set")
    val items = elements("#item-set .item")
}