package net.helpscout.sample.beacon;

import android.app.Application;
import com.helpscout.beacon.Beacon;
import com.helpscout.beacon.ui.BeaconEventLifecycleHandler;
import com.helpscout.beacon.ui.BeaconOnClosedListener;
import com.helpscout.beacon.ui.BeaconOnOpenedListener;
import timber.log.Timber;

public class CustomisationApplication extends Application {

    // TODO replace with your Beacon Id from Help Scout
    private static String beaconId = "6563caf4-4fbe-4e27-924e-20e088d2ce81";

    @Override
    public void onCreate() {
        super.onCreate();
        initBeacon();
        initBeaconListeners();
    }

    private void initBeacon() {
        // We recommend initializing Beacon as part of Application.onCreate or through Dependency
        // Injection
        new Beacon.Builder()
                .withBeaconId(beaconId)
                .withLogsEnabled(true)  // Logging should be disabled in production
                .build();
    }

    private void initBeaconListeners() {
        // Use the BeaconEventLifecycleHandler to start listening to close and open events on the
        // Beacon. i.e for Analytics more info https://developer.helpscout.com/beacon-2/android/#open-and-close-events
        BeaconEventLifecycleHandler eventLifecycleHandler = new BeaconEventLifecycleHandler(
                new BeaconOnOpenedListener() {
                    @Override
                    public void onOpened() {
                        Timber.i("Open Beacon event called");
                    }
                },
                new BeaconOnClosedListener() {
                    @Override
                    public void onClosed() {
                        Timber.i("Close Beacon event called");
                    }
                }
        );

        registerActivityLifecycleCallbacks(eventLifecycleHandler);
    }

}
