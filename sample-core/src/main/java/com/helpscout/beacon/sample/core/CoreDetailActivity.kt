package com.helpscout.beacon.sample.core

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import com.helpscout.beacon.Beacon
import com.helpscout.beacon.BuildConfig
import com.helpscout.beacon.internal.core.model.BeaconArticleSuggestion
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import net.helpscout.samples.beacon.core.R

class CoreDetailActivity : AppCompatActivity() {

    private val webView: WebView by lazy { findViewById<WebView>(R.id.suggestion_web_view) }

    companion object {

        private val EXTRA_ARTICLE_ID = BuildConfig.APPLICATION_ID + ".ARTICLE_ID"

        fun open(context: Context, article: BeaconArticleSuggestion): Intent {
            return Intent(context, CoreDetailActivity::class.java).apply {
                putExtra(EXTRA_ARTICLE_ID, article.suggestion.id)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_suggestion_detail)

        val articleId = intent.getStringExtra(EXTRA_ARTICLE_ID)

        launch(UI) {
            val repository = Beacon.getRepositoryInstance()
            val articleJob = async { repository.getArticleById(articleId) }

            val article = articleJob.await()

            title = article.name
            webView.loadDataWithBaseURL("\'file:///android_asset/\'", article.text, "text/html", "utf-8", null)
        }

    }

}
