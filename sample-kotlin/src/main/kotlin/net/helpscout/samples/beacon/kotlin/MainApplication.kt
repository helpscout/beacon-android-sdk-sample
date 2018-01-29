package net.helpscout.samples.beacon.kotlin

import android.app.Application
import com.facebook.stetho.Stetho
import com.helpscout.beacon.Beacon

class MainApplication : Application() {

    //from jamie dev(secure mode only)
    //val beaconId = "d6fdc98c-ac87-4970-b580-7d2ebd38311d"


    //from MAxi dev/basic (docs enabled)
    //val beaconId = "f5b15224-c17f-4173-85d6-2c14afd474ad"

    //val beaconId = "a63de347-8a4a-4fe7-9d73-6ae41421d140"

    //Scott Beacon Prod
    val beaconId = "598349f2-c5a4-424d-8eb6-8c1d0813a42f"

    override fun onCreate() {
        super.onCreate()
        initBeacon()
        Stetho.initializeWithDefaults(this);
    }

    fun initBeacon() {
        Beacon.Builder()
                .withContext(this)
                .withBeaconId(beaconId)
                .withLogsEnabled(true)
                .build()
    }

}
