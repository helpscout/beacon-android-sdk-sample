package net.helpscout.samples.beacon.kotlin

import android.app.Application
import com.helpscout.beacon.Beacon

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initBeacon()
    }

    fun initBeacon() {
        Beacon.Builder()
                .withContext(this)
                .withBeaconId("a63de347-8a4a-4fe7-9d73-6ae41421d140")
                .withLogsEnabled(true)
                .build()
    }

}