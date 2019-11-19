package com.sserdiuk.baseadroidframework.screens.foodDetails

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.sserdiuk.baseadroidframework.R
import com.sserdiuk.baseadroidframework.screens.BaseActivity

class FoodActivity : AppCompatActivity(), FoodCallbacks, FoodRouter {
    companion object {
        const val ITEM_NAME = "ITEM_NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_food_details_view)
    }
}