package com.helpscout.beacon.sample.core

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.helpscout.beacon.Beacon
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import net.helpscout.samples.beacon.core.R

class CoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_core)

        launch(UI) {
            val repository = Beacon.getInstance().repositoryInstance
            val suggestionsJob = async { repository.suggestions }
            val searchJob = async { repository.searchArticles("Help") }

            val suggestions = suggestionsJob.await()
            val searchResuts = searchJob.await()

            Log.d("Beacon Core Sample", "Suggestions" + suggestions.size)
            Log.d("Beacon Core Sample", "Search Results" + searchResuts.size)

        }

    }
}
