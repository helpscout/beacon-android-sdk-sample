package net.helpscout.samples.beacon.chat

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.helpscout.beacon.ui.BeaconActivity
import kotlinx.android.synthetic.main.activity_main.*


class ChatMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        button_open_beacon.setOnClickListener {
            //open the Beacon to default page
            BeaconActivity.open(baseContext)
        }
    }
}
