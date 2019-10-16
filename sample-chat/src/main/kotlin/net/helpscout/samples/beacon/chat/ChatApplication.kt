package net.helpscout.samples.beacon.chat

import android.app.Application
import com.helpscout.beacon.Beacon

class ChatApplication : Application() {

    val beaconId = "YOUR_BEACON_ID"

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
