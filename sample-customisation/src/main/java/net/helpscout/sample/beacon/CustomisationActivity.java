package net.helpscout.sample.beacon;

import android.annotation.SuppressLint;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.helpscout.beacon.Beacon;
import com.helpscout.beacon.model.BeaconConfigOverrides;
import com.helpscout.beacon.model.PreFilledForm;
import com.helpscout.beacon.model.SuggestedArticle;
import com.helpscout.beacon.ui.BeaconActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.helpscout.sample.beacon.customisation.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import timber.log.Timber;

public class CustomisationActivity extends AppCompatActivity {

    //for sample this is hardcoded to a single user. But in your code these details would be on per user basis.
    private static final String secureModeUserEmail = "beacon_secure@scottyab.com";
    private static final String secureModeUserSignature = "8235545a15c6f41b64e3c47e5c94d3cfb6c6d297e87af88dec953a73042a7b92";

    // Replace this list with max five article string ids from your docs or a URL
    private static final List<SuggestedArticle> articleSuggestionsOverride = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customisation);

        //typically this should be set after successfully logging on to your service
        Beacon.login(secureModeUserEmail);

        addPreFilledData();

        addUserAttributes();

        addArticlesSuggestionOverride();


        findViewById(R.id.action_open_beacon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setColorOverrides(false);
                openBeaconInSecureMode();
            }
        });

        findViewById(R.id.action_open_beacon_color).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setColorOverrides(true);
                openBeaconInBasicMode();
            }
        });

    }

    private void setColorOverrides(boolean enabled) {
        if (enabled) {
            @SuppressLint("ResourceType") String colorHexString = getResources().getString(R.color.primary);
            Beacon.setConfigOverrides(new BeaconConfigOverrides(null, null, null, null, colorHexString));
        } else {
            Beacon.setConfigOverrides(new BeaconConfigOverrides(null, null, null, null, null));
        }
    }

    private void openBeaconInBasicMode() {
        BeaconActivity.open(this);
    }

    private void openBeaconInSecureMode() {
        BeaconActivity.openInSecureMode(this, secureModeUserSignature);
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
                "My Secure user Scott",
                "Bug report for app",
                "Please include steps to reproduce the issue",
                prePopulatedCustomFields,
                generateLogFileUri(),
                "my@email.com"
        ));
    }

    /**
     * Add suggested articles
     */
    private void addArticlesSuggestionOverride() {
        Beacon.setOverrideSuggestedArticlesOrLinks(articleSuggestionsOverride);
    }

    /**
     * Create a pre-fill log file to be attached in messages
     */
    private List<String> generateLogFileUri() {
        List<String> uris = new ArrayList<>();

        try {
            File logAFile = new File(getFilesDir() + File.separator + "log_a.txt");
            logAFile.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(logAFile);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.append("This is a sample log called log_a.txt");
            outputStreamWriter.close();
            fileOutputStream.close();
            uris.add(Uri.fromFile(logAFile).toString());
        } catch (IOException exception) {
            Timber.e(this.getClass().getName(), exception.getLocalizedMessage());
        }

        return uris;
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
