package com.helpscout.beacon.sample.core

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ListView
import android.widget.ProgressBar
import com.helpscout.beacon.Beacon
import com.helpscout.beacon.internal.core.model.BeaconArticleSuggestion
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import net.helpscout.samples.beacon.core.R

class CoreActivity : AppCompatActivity() {

    private var listAdapter: SuggestionsAdapter
    private val progressBar: ProgressBar by lazy { findViewById<ProgressBar>(R.id.suggestions_loading) }
    private val suggestionsList: ListView by lazy { findViewById<ListView>(R.id.suggestions_list) }

    init {
        listAdapter = SuggestionsAdapter(
                suggestions = emptyList(),
                itemClick = { suggestion -> openSuggestion(suggestion) }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_core)

        launch(UI) {
            val repository = Beacon.getInstance().repositoryInstance
            val suggestionsJob = async { repository.suggestions }

            val suggestions = suggestionsJob.await()

            suggestionsList.adapter = listAdapter
            listAdapter.updateSuggestions(suggestions)
            progressBar.visibility = View.GONE
        }
    }

    private fun openSuggestion(suggestion: BeaconArticleSuggestion) {


    }
}
