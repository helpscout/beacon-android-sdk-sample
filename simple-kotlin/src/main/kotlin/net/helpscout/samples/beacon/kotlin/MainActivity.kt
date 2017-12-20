package net.helpscout.samples.beacon.kotlin

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import net.helpscout.android.beacon.ui.BeaconActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        findViewById<FloatingActionButton>(R.id.fab_open_beacon).setOnClickListener {
            BeaconActivity.open(baseContext)
        }

    }
}
