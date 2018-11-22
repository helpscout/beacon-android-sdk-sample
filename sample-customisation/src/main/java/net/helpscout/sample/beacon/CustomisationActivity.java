package net.helpscout.sample.beacon;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.helpscout.beacon.Beacon;
import com.helpscout.beacon.internal.core.model.PreFilledForm;
import com.helpscout.beacon.ui.BeaconActivity;

import java.util.HashMap;
import java.util.Map;

import net.helpscout.sample.beacon.customisation.R;

public class CustomisationActivity extends AppCompatActivity {

    //for sample this is hardcoded to a single user. But in your code these details would be on per user basis.
    private static final String secureUserEmail = "beacon_secure@scottyab.com";
    private static final String secureUserSignature = "8235545a15c6f41b64e3c47e5c94d3cfb6c6d297e87af88dec953a73042a7b92";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customisation);

        //typically this should be set after successfully logging on to your service
        Beacon.login(secureUserEmail);

        addPreFilledData();

        addUserAttributes();


        findViewById(R.id.action_open_beacon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BeaconActivity.openInSecureMode(getBaseContext(), secureUserSignature);
            }
        });

    }

    /**
     * Illustrates how to use the user attributes
     */
    private void addUserAttributes() {
        Beacon.addAttributeWithKey("App version", getAppVersion());
        Beacon.addAttributeWithKey("OS version", Build.VERSION.RELEASE);
        Beacon.addAttributeWithKey("Device", Build.MANUFACTURER + " " + Build.MODEL);
    }

    /**
     * Pre-fill the Contact us form
     */
    private void addPreFilledData() {
        Map<Integer, String> prePopulatedCustomFields = new HashMap<>();
        prePopulatedCustomFields.put(123, "TEST");

        Beacon.addPreFilledForm(new PreFilledForm(
                "Testy Mc Test Face",
                "Bug report for app",
                "Please include steps to reproduce the issue",
                prePopulatedCustomFields
        ));
    }

    private String getAppVersion() {
        try {
            PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            return pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
}
