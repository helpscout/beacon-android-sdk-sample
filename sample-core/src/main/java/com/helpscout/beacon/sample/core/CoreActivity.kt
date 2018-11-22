package com.helpscout.beacon.sample.core

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.helpscout.beacon.Beacon
import com.helpscout.beacon.internal.core.model.BeaconArticleSuggestion
import kotlinx.android.synthetic.main.activity_suggestions.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import net.helpscout.samples.beacon.core.R

class CoreActivity : AppCompatActivity() {

    private var listAdapter: SuggestionsAdapter

    init {
        listAdapter = SuggestionsAdapter(
                suggestions = emptyList(),
                itemClick = { suggestion -> openSuggestion(suggestion) }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_suggestions)

        GlobalScope.launch(Dispatchers.Main) {
            try {
                val repository = Beacon.getRepositoryInstance()
                val suggestionsJob = async { repository.suggestions }
                val suggestions = suggestionsJob.await()

                suggestions_list.adapter = listAdapter
                listAdapter.updateSuggestions(suggestions)
                suggestions_loading.visibility = View.GONE
            } catch (e: Exception) {
                Toast.makeText(this@CoreActivity, "Error while downloading suggestions: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun openSuggestion(suggestion: BeaconArticleSuggestion) {
        startActivity(CoreDetailActivity.open(this, suggestion))
    }
}
