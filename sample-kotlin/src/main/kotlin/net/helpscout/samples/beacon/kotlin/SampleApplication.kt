package net.helpscout.samples.beacon.kotlin

import android.app.Application
import com.helpscout.beacon.Beacon
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class SampleApplication : Application() {

    // TODO replace with your Beacon Id from Help Scout
    private val beaconId = ""

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@SampleApplication)
            modules(appModule)
        }

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

val appModule = module {
    single { Greeting() }
}
    

class Greeting {
    val hello = "Hello!"
}
