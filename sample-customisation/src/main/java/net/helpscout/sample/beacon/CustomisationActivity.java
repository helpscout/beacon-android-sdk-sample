package net.helpscout.sample.beacon;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.helpscout.beacon.Beacon;
import com.helpscout.beacon.internal.core.model.PreFilledForm;
import com.helpscout.beacon.ui.BeaconActivity;

import java.util.Collections;

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

        Beacon.addPreFilledForm(new PreFilledForm(
                "Testy Mc Test Face",
                "Feedback from app v." + getAppVersion(),
                "Please include steps to reproduce the issue",
                Collections.<Integer, String>emptyMap()));


        findViewById(R.id.action_open_beacon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BeaconActivity.openInSecureMode(getBaseContext(), secureUserSignature);
            }
        });

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
