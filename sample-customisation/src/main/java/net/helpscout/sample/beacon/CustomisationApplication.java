package net.helpscout.sample.beacon;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.helpscout.beacon.Beacon;

public class CustomisationApplication extends Application {

    private static String secureBeaconId = "6563caf4-4fbe-4e27-924e-20e088d2ce81";

    @Override
    public void onCreate() {
        super.onCreate();
        initBeacon();
        Stetho.initializeWithDefaults(this);
    }

    private void initBeacon() {
        new Beacon.Builder()
                .withContext(this)
                .withBeaconId(secureBeaconId)
                .withLogsEnabled(true)
                .build();
    }

}
