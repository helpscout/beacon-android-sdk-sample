package net.helpscout.samples.beacon.kotlin

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.helpscout.beacon.Beacon
import com.helpscout.beacon.BeaconActivity

class MainActivity : AppCompatActivity() {

    private val userEmail = "jamie+aaaab@mcdg.com"
    private val signature = "9222339b1df2e54be107d3d5dd6a5124dbcc7310354ff8f003d32cd7373a66e1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        findViewById<FloatingActionButton>(R.id.fab_open_beacon).setOnClickListener {
            BeaconActivity.open(baseContext)
        }

        findViewById<Button>(R.id.button_open_beacon).setOnClickListener {
            BeaconActivity.open(baseContext)
        }

        findViewById<Button>(R.id.button_login_beacon).setOnClickListener {
            Beacon.login(userEmail)
        }

        findViewById<Button>(R.id.button_secure_login_beacon).setOnClickListener {
            Beacon.loginSecureMode(userEmail, signature)
        }

        findViewById<Button>(R.id.button_logout_beacon).setOnClickListener {
            if (Beacon.getInstance().isLoggedIn) {
                Beacon.logout()
            }
        }

    }
}
