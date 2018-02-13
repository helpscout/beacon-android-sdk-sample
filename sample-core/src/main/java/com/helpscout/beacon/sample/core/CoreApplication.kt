package com.helpscout.beacon.sample.core

import android.app.Application
import com.helpscout.beacon.Beacon

class CoreApplication : Application() {

    private val secureBeaconId = "6563caf4-4fbe-4e27-924e-20e088d2ce81"

    override fun onCreate() {
        super.onCreate()
        initBeacon()
    }

    private fun initBeacon() {
        Beacon.Builder()
                .withContext(this)
                .withBeaconId(secureBeaconId)
                .withLogsEnabled(true)
                .build()
    }

}