package net.helpscout.sample.beacon;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.helpscout.beacon.Beacon;

import timber.log.Timber;

public class CustomisationApplication extends Application {

    private static String secureBeaconId = "6563caf4-4fbe-4e27-924e-20e088d2ce81";

    @Override
    public void onCreate() {
        super.onCreate();
        initDebuggingLibs();
        initBeacon();
        Timber.d("App & Beacon Init");
    }

    private void initBeacon() {
        new Beacon.Builder()
                .withContext(this)
                .withBeaconId(secureBeaconId)
                .withLogsEnabled(true)
                .build();
    }

    private void initDebuggingLibs() {
        Stetho.initializeWithDefaults(this);
        Timber.plant(new Timber.DebugTree());
    }
}
