package com.sserdiuk.baseadroidframework.screens.foodDetails

import android.os.Bundle
import com.sserdiuk.baseadroidframework.R
import com.sserdiuk.baseadroidframework.screens.BaseActivity

class FoodActivity : BaseActivity(), FoodCallbacks, FoodRouter {
    companion object {
        const val ITEM_NAME = "ITEM_NAME"
    }

    private val presenter = FoodPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details_view)

        presenter.run {
            takeView(this@FoodActivity)
            takeRouter(this@FoodActivity)
            if (intent.hasExtra(ITEM_NAME)) onTakePath(intent?.extras?.getString(ITEM_NAME))
        }
    }

    override fun showItemName(text: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showNutrition(text: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showTableCalories(text: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showImage(pathToImage: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProductCompose(text: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showVendor(text: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showBarcode(text: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProductCountry(text: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun closeActivity() {
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.run {
            dropView()
            dropRouter()
        }
    }
}