package net.helpscout.sample.beacon;

import android.app.Application;

import com.helpscout.beacon.Beacon;

public class CustomisationApplication extends Application {

    private static String secureBeaconId = "YOUR_BEACON_ID";

    @Override
    public void onCreate() {
        super.onCreate();
        initBeacon();
    }

    private void initBeacon() {
        new Beacon.Builder()
                .withBeaconId(secureBeaconId)
                .withLogsEnabled(true)
                .build();
    }

}
