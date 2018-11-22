package net.helpscout.samples.beacon.kotlin

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import com.helpscout.beacon.Beacon
import com.helpscout.beacon.internal.core.model.BeaconScreens
import com.helpscout.beacon.ui.BeaconActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : Activity() {

    private val userEmail = "beacon_basic@scottyab.com"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        button_open_beacon.setOnClickListener {
            BeaconActivity.open(baseContext)
        }

        button_login_beacon.setOnClickListener {
            Beacon.login(userEmail)
            toast("Log in (Basic mode) as $userEmail")
        }

        button_logout_beacon.setOnClickListener {
            if (Beacon.isLoggedIn()) {
                val currentUser = Beacon.email()
                Beacon.logout()
                toast("Logged out with $currentUser")
            }
        }

        button_open_beacon_to_search.setOnClickListener {
            BeaconActivity.open(this, BeaconScreens.SEARCH_SCREEN, arrayListOf("email"))
        }


    }

    private fun toast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
