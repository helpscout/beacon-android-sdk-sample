package net.helpscout.sample.beacon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.helpscout.beacon.BeaconActivity;

import net.helpscout.sample.beacon.customisation.R;

public class CustomisationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customisation);

        findViewById(R.id.action_open_beacon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BeaconActivity.open(getBaseContext());
            }
        });

        findViewById(R.id.fab_open_beacon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BeaconActivity.open(getBaseContext());
            }
        });
    }
}
