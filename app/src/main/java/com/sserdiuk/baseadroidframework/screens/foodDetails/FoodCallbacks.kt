package com.sserdiuk.baseadroidframework.screens.foodDetails

import com.sserdiuk.baseadroidframework.ViewCallback

interface FoodCallbacks : ViewCallback {
    fun showItemName(text: String)
    fun showNutrition(text: String)
    fun showTableCalories(text: String)
    fun showImage(pathToImage: String)
    fun showProductCompose(text: String)
    fun showVendor(text: String)
    fun showBarcode(text: String)
    fun showProductCountry(text: String)
}