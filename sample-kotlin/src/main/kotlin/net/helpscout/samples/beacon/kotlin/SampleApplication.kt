package net.helpscout.samples.beacon.kotlin

import android.app.Application
import com.helpscout.beacon.Beacon

class SampleApplication : Application() {

    // TODO replace with your Beacon Id from Help Scout
    private val beaconId = "55fa783f-a0bb-402e-b2b0-dbd4b3d03146"

    override fun onCreate() {
        super.onCreate()
        initBeacon()
    }

    private fun initBeacon() {
        // We recommend initialing Beacon as part of Application.onCreate or via your Dependency
        // Injection
        Beacon.Builder()
            .withBeaconId(beaconId)
            .withLogsEnabled(true)  // Logging should be disabled in production
            .build()
    }
}
