package net.helpscout.samples.beacon.kotlin

import android.app.Application
import com.helpscout.beacon.Beacon

class MainApplication : Application() {

    //from jamie (secure mode only)
    val beaconId = "d6fdc98c-ac87-4970-b580-7d2ebd38311d"
    //val beaconId = "a63de347-8a4a-4fe7-9d73-6ae41421d140"

    override fun onCreate() {
        super.onCreate()
        initBeacon()
    }

    fun initBeacon() {
        Beacon.Builder()
                .withContext(this)
                .withBeaconId(beaconId)
                .withLogsEnabled(true)
                .build()
    }

}
