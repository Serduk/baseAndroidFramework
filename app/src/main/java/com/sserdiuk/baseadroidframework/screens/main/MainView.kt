package com.sserdiuk.baseadroidframework.screens.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sserdiuk.baseadroidframework.R

class MainView : AppCompatActivity(), MainRouter, MainCallbacks {
    override fun buttonClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun button1Clicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun navigateToScreenShouldBe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
