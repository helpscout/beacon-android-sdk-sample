package net.helpscout.samples.beacon.kotlin

import android.app.Application
import com.facebook.stetho.Stetho
import com.helpscout.beacon.Beacon
import timber.log.Timber


class MainApplication : Application() {

    //Basic Beacon Prod (Android Test Account)
    val beaconId = "598349f2-c5a4-424d-8eb6-8c1d0813a42f"

    override fun onCreate() {
        super.onCreate()
        initDebuggingLibs()
        initBeacon()
        Timber.d("App & Beacon Init")
    }

    private fun initDebuggingLibs() {
        Stetho.initializeWithDefaults(this)
        Timber.plant(Timber.DebugTree())   
    }

    fun initBeacon() {
        Beacon.Builder()
                .withContext(this)
                .withBeaconId(beaconId)
                .withLogsEnabled(true)
                .build()
    }

}
