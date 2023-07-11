package net.helpscout.sample.beacon;

import android.app.Application;

import com.helpscout.beacon.Beacon;
import com.helpscout.beacon.ui.BeaconEventLifecycleHandler;

import timber.log.Timber;

public class CustomisationApplication extends Application {

    // TODO replace with your Beacon Id from Help Scout
    private final static String beaconId = "";

    @Override
    public void onCreate() {
        super.onCreate();
        initBeacon();
        initBeaconListeners();
    }

    private void initBeacon() {
        // We recommend initializing Beacon as part of Application.onCreate
        // or through Dependency Injection
        new Beacon.Builder()
                .withBeaconId(beaconId)
                .withLogsEnabled(true)  // Logging should be disabled in production
                .build();
    }

    private void initBeaconListeners() {
        // Use the BeaconEventLifecycleHandler to start listening to close and open events on the
        // Beacon. i.e for Analytics more info https://developer.helpscout.com/beacon-2/android/#open-and-close-events
        BeaconEventLifecycleHandler eventLifecycleHandler = new BeaconEventLifecycleHandler(
                /* onOpenedListener */ () -> Timber.i("Open Beacon event called"),
                /* onClosedListener */ () -> Timber.i("Close Beacon event called")
        );

        registerActivityLifecycleCallbacks(eventLifecycleHandler);
    }

}
