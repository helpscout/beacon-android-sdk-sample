package net.helpscout.sample.beacon;

import android.app.Application;

import com.helpscout.beacon.Beacon;

public class CustomisationApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initBeacon();
    }

    private void initBeacon() {
        new Beacon.Builder()
                .withContext(this)
                .withBeaconId("a63de347-8a4a-4fe7-9d73-6ae41421d140")
                .withLogsEnabled(true)
                .build();
    }

}
