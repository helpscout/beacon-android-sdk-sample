package net.helpscout.samples.beacon.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.helpscout.beacon.Beacon
import com.helpscout.beacon.internal.core.model.BeaconScreens
import com.helpscout.beacon.ui.BeaconActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val userEmail = "your_user_email@domain.com"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        button_open_beacon.setOnClickListener {
            //open the Beacon to default page
            BeaconActivity.open(baseContext)
        }

        button_open_beacon_to_contact.setOnClickListener {
            //open the Beacon to contact page
            BeaconActivity.open(baseContext, BeaconScreens.CONTACT_FORM_SCREEN, arrayListOf())
        }


        button_login_beacon.setOnClickListener {
            Beacon.login(userEmail)
            toast("Log in (Basic mode) as $userEmail")
        }

        button_logout_beacon.setOnClickListener {
            if (Beacon.isLoggedIn()) {
                val currentUser = Beacon.email()
                Beacon.logout()
                toast("Logged out user: $currentUser")
            } else {
                toast("Beacon isn't Logged in")
            }
        }

    }

    private fun toast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
