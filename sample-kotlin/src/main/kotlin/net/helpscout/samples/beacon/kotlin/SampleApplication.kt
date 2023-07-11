package net.helpscout.samples.beacon.kotlin

import android.app.Application
import com.helpscout.beacon.Beacon

class SampleApplication : Application() {

        private val beaconId: String = TODO("Replace with your Beacon Id from Help Scout")

    override fun onCreate() {
        super.onCreate()
        initBeacon()
    }

    private fun initBeacon() {
        // We recommend initialing Beacon as part of Application.onCreate
        // or through Dependency Injection
        Beacon.Builder()
            .withBeaconId(beaconId)
            .withLogsEnabled(true)  // Logging should be disabled in production
            .build()
    }
}
