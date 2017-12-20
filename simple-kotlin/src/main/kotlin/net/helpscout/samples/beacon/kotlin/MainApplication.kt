package net.helpscout.samples.beacon.kotlin

import android.app.Application

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initBeacon()
    }

    fun initBeacon() {
//        Beacon.Builder()
//                .withContext(this)
//                .withBeaconId("0c09af96-546a-4e40-a797-e747d74d5437")
//                .withLogsEnabled(true)
//                .build()
    }

}