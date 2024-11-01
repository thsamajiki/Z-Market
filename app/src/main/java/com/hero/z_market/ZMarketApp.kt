package com.hero.z_market

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ZMarketApp : Application() {

    companion object {
        lateinit var instance : ZMarketApp

        fun getInstance() : Application {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
    }
}
