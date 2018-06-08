package com.helpscout.beacon.sample.core

import android.app.Application
import com.helpscout.beacon.Beacon

class CoreApplication : Application() {

    private val secureBeaconId = "YOUR_BEACON_ID"

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
