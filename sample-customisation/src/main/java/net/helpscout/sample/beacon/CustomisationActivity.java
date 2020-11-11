package net.helpscout.sample.beacon;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.widget.CheckBox;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.helpscout.beacon.Beacon;
import com.helpscout.beacon.internal.core.model.ContactFormConfigApi;
import com.helpscout.beacon.model.BeaconConfigOverrides;
import com.helpscout.beacon.model.PreFilledForm;
import com.helpscout.beacon.ui.BeaconActivity;
import net.helpscout.sample.beacon.customisation.R;
import net.helpscout.sample.beacon.util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomisationActivity extends AppCompatActivity {

    private CheckBox overrideContactFormCheck;
    private CheckBox overrideInstantAnswersCheck;
    private CheckBox overrideColorCheck;
    private CheckBox sessionAttributesCheck;
    private CheckBox prefillCheck;
    private CheckBox identifyCheck;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customisation);
        initViews();
    }

    private void openBeacon() {
        configureBeacon();
        configureOverrides();
        BeaconActivity.open(this);
    }

    private void configureBeacon() {
        if (identifyCheck.isChecked()) {
            // Call identify when you have your User's email, in the Help Scout app we do this
            // after login success. There's identify method overrides if you wish to provide just
            // email or email and name.
            // more info https://developer.helpscout.com/beacon-2/android/#authenticating-users
            Beacon.identify("sample@sample.com",
                    "Name",
                    "company",
                    "jobTitle",
                    "https://p-zkf42x.t2.n0.cdn.getcloudapp.com/items/5zuwqrLg/avataaars.png");
        }

        addPreFilledData(prefillCheck.isChecked());
        addSessionAttributes(sessionAttributesCheck.isChecked());
    }

    private void configureOverrides() {
        overrideBeaconConfig(!overrideContactFormCheck.isChecked(), !overrideContactFormCheck.isChecked(), overrideColorCheck.isChecked());
        overrideInstantAnswers(overrideInstantAnswersCheck.isChecked());
    }

    /**
     * Illustrates how to use the session attributes
     * more info https://developer.helpscout.com/beacon-2/android/#session-attributes
     */
    private void addSessionAttributes(boolean enabled) {
        Map<String, String> attributes = new HashMap<>();
        if (enabled) {
            attributes.put("App version", Utils.getAppVersion(this));
            attributes.put("OS version", Build.VERSION.RELEASE);
            attributes.put("Device", Build.MANUFACTURER + " " + Build.MODEL);
        }
        Beacon.setSessionAttributes(attributes);
    }

    /**
     * Pre-fill the Contact us form
     * More info https://developer.helpscout.com/beacon-2/android/#prefilling-the-contact-form
     */
    private void addPreFilledData(boolean enabled) {
        Beacon.contactFormReset();
        if (enabled) {
            Map<Integer, String> prePopulatedCustomFields = new HashMap<>();
            prePopulatedCustomFields.put(123, "TEST");

            List<String> attachments = new ArrayList<>(Utils.generateSampleLogFileUri(this));

            Beacon.addPreFilledForm(new PreFilledForm(
                    "Prefill Name",
                    "Prefill Subject",
                    "Please include steps to reproduce the issue",
                    prePopulatedCustomFields,
                    attachments,
                    "prefill@email.com" // email (this can be edited by the user)
            ));
        }
    }

    /**
     * More info on settings overrides https://developer.helpscout.com/beacon-2/android/#settings-customization
     */
    private void overrideBeaconConfig(boolean shouldDisableName, boolean shouldDisableSubject, boolean colorOverrideEnabled) {

        //Demonstrates how to use Android Color Resource Hex to override the Beacon color
        @SuppressLint("ResourceType") String colorOverride = colorOverrideEnabled ? getResources().getString(R.color.custom_beacon_color) : null;

        // [docs|messaging|chat]Enabled - is primarily designed for runtime disabling of features
        // When set to false this will locally override and disable a feature
        // When set to true the remote config will be used and does not enable a feature if
        // it isn't enabled on the Beacon on Help Scout
        Beacon.setConfigOverrides(new BeaconConfigOverrides(
                true, // docsEnabled
                true, // messagingEnabled
                true, // chatEnabled
                new ContactFormConfigApi(  // ContactForm overrides
                        shouldDisableName, // showName
                        shouldDisableSubject, // showSubject
                        true,  // allowAttachments
                        false, // customFieldsEnabled
                        true), // showGetInTouch
                colorOverride  // override color in #000000 format
        ));
    }

    /**
     * Replace the Instant Answers (suggestions) with this list. Note: max 5
     * More info: https://developer.helpscout.com/beacon-2/android/#custom-suggestions
     */
    private void overrideInstantAnswers(boolean enabled) {
        if (enabled) {
            List<String> overrides = new ArrayList<>();
            // TODO replace the article IDs with Articles from your Docs Collection.
            // https://secure.helpscout.net/docs/[COLLECTION ID]/article/[ARTICLE ID]/
            overrides.add("11122bbb0428631d7a89ff4a");
            overrides.add("11122ffd2c7d3a0fa9a29d22");
            Beacon.setOverrideSuggestedArticles(overrides);
        } else {
            Beacon.resetSuggestedArticlesOverrides();
        }
    }

    private void initViews() {
        overrideContactFormCheck = findViewById(R.id.overrideContactFormCheck);
        overrideInstantAnswersCheck = findViewById(R.id.overrideInstantAnswersCheck);
        overrideColorCheck = findViewById(R.id.overrideColorCheck);
        sessionAttributesCheck = findViewById(R.id.sessionAttributesCheck);
        prefillCheck = findViewById(R.id.prefillCheck);
        identifyCheck = findViewById(R.id.identifyCheck);

        findViewById(R.id.openBeaconButton).setOnClickListener(view -> openBeacon());
        findViewById(R.id.buttonLogout).setOnClickListener(view -> Beacon.logout());
    }
}
