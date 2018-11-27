package net.helpscout.samples.beacon.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import com.helpscout.beacon.Beacon
import com.helpscout.beacon.ui.BeaconActivity


class MainActivity : AppCompatActivity() {

    private val userEmail = "beacon_basic@scottyab.com"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_open_beacon).setOnClickListener {
            BeaconActivity.open(baseContext)
        }

        findViewById<Button>(R.id.button_login_beacon).setOnClickListener {
            Beacon.login(userEmail)
            toast("Log in (Basic mode) as $userEmail")
        }

        findViewById<Button>(R.id.button_logout_beacon).setOnClickListener {
            if (Beacon.isLoggedIn()) {
                val currentUser = Beacon.email()
                Beacon.logout()
                toast("Logged out with $currentUser")
            }
        }

    }

    private fun toast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
