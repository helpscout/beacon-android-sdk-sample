package net.helpscout.samples.beacon.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.helpscout.beacon.model.BeaconScreens
import com.helpscout.beacon.ui.BeaconActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openBeaconButton.setOnClickListener {
            //open the Beacon
            BeaconActivity.open(baseContext)
        }

        openBeaconToContactButton.setOnClickListener {
            //open the Beacon to contact page (note this assumes the Beacon supports contact)
            BeaconActivity.open(baseContext, BeaconScreens.CONTACT_FORM_SCREEN, arrayListOf())
        }
    }
}
