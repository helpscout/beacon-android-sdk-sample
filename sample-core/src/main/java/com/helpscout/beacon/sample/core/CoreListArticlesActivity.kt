package com.helpscout.beacon.sample.core

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.helpscout.beacon.Beacon
import com.helpscout.beacon.internal.core.model.ArticleApi
import kotlinx.android.synthetic.main.activity_suggestions.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.helpscout.samples.beacon.core.R

class CoreListArticlesActivity : AppCompatActivity() {

    private val job = Job()
    private val backgroundScope = CoroutineScope(Dispatchers.IO + job)

    private var listAdapter: ArticleSuggestionsAdapter

    init {
        listAdapter = ArticleSuggestionsAdapter(
            articles = listOf(),
            itemClick = { article -> openArticle(article) }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_suggestions)

        backgroundScope.launch {
            loadSuggestedArticles()
        }
    }

    private suspend fun loadSuggestedArticles() {
        try {
            val repository = Beacon.getRepositoryInstance()
            val suggestions = repository.suggestions

            withContext(Dispatchers.Main) {
                suggestions_list.adapter = listAdapter
                listAdapter.updateSuggestions(suggestions)
                suggestions_loading.visibility = View.GONE
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@CoreListArticlesActivity,
                    "Error while downloading suggestions: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }

    private fun openArticle(article: ArticleApi) {
        startActivity(CoreDetailActivity.open(this, article))
    }
}
