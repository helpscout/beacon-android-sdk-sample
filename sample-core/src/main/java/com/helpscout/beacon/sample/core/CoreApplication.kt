package com.helpscout.beacon.sample.core

import android.app.Application
import com.helpscout.beacon.Beacon

class CoreApplication : Application() {

    private val secureBeaconId = "a63de347-8a4a-4fe7-9d73-6ae41421d140"

    override fun onCreate() {
        super.onCreate()
        initBeacon()
    }

    private fun initBeacon() {
        Beacon.Builder()
                .withBeaconId(secureBeaconId)
                .withLogsEnabled(true)
                .build()
    }

}
