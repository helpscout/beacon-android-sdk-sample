package net.helpscout.samples.beacon.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.helpscout.beacon.Beacon
import com.helpscout.beacon.model.BeaconConfigOverrides
import com.helpscout.beacon.ui.BeaconActivity
import kotlinx.android.synthetic.main.activity_main.openBeaconButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openBeaconButton.setOnClickListener {
            // Disable docs
            Beacon.setConfigOverrides(
                BeaconConfigOverrides(docsEnabled = false),
            )

            // open the Beacon
            BeaconActivity.open(baseContext)
        }
    }
}
