package net.helpscout.samples.beacon.kotlin

import android.app.Application
import com.helpscout.beacon.Beacon

class MainApplication : Application() {

    //Basic Beacon Prod (Android Test Account)
    val beaconId = "a63de347-8a4a-4fe7-9d73-6ae41421d140"

    override fun onCreate() {
        super.onCreate()
        initBeacon()
    }

    fun initBeacon() {
        Beacon.Builder()
                .withBeaconId(beaconId)
                .withLogsEnabled(true)
                .build()
    }

}
