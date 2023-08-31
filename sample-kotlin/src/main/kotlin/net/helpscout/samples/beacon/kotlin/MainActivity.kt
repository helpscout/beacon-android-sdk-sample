package net.helpscout.samples.beacon.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.helpscout.beacon.model.BeaconScreens
import com.helpscout.beacon.ui.BeaconActivity
import net.helpscout.samples.beacon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding
            .inflate(layoutInflater)
            .also { setContentView(it.root) }

        binding.openBeaconButton.setOnClickListener {
            // open the Beacon
            BeaconActivity.open(baseContext)
        }

        binding.openBeaconToContactButton.setOnClickListener {
            // open the Beacon to contact page (note this assumes the Beacon supports contact)
            // more info https://developer.helpscout.com/beacon-2/android/#navigate-to-a-specific-screen
            BeaconActivity.open(baseContext, BeaconScreens.CONTACT_FORM_SCREEN, arrayListOf())
        }
    }
}
