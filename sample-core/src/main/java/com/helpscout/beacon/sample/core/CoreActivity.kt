package com.helpscout.beacon.sample.core

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.helpscout.beacon.Beacon
import net.helpscout.samples.beacon.core.R

class CoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_core)

        val repository = Beacon.getInstance().repositoryInstance

    }
}
