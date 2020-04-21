package com.helpscout.beacon.sample.core

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.helpscout.beacon.Beacon
import com.helpscout.beacon.internal.core.model.ArticleApi
import com.helpscout.beacon.internal.core.model.ArticleApi.ArticleDocPreview
import com.helpscout.beacon.internal.core.model.ArticleApi.CustomLink
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.helpscout.samples.beacon.core.BuildConfig
import net.helpscout.samples.beacon.core.R

class CoreDetailActivity : AppCompatActivity() {
    private val job = Job()
    private val backgroundScope = CoroutineScope(Dispatchers.IO + job)

    private val progressBar: ProgressBar by lazy { findViewById<ProgressBar>(R.id.suggestion_loading) }
    private val webView: WebView by lazy { findViewById<WebView>(R.id.suggestion_web_view) }

    companion object {

        private const val EXTRA_ARTICLE_ID = BuildConfig.APPLICATION_ID + ".ARTICLE_ID"
        private const val EXTRA_ARTICLE_URL = BuildConfig.APPLICATION_ID + ".ARTICLE_URL"

        fun open(context: Context, article: ArticleApi): Intent {
            return Intent(context, CoreDetailActivity::class.java).apply {
                when (article) {
                    is CustomLink -> putExtra(EXTRA_ARTICLE_URL, article.url)
                    is ArticleDocPreview -> putExtra(EXTRA_ARTICLE_ID, article.id)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_suggestion_detail)

        val articleId = intent.getStringExtra(EXTRA_ARTICLE_ID)
        val articleUrl = intent.getStringExtra(EXTRA_ARTICLE_URL)

        if (articleId.isNullOrEmpty()) {
            openArticleUrl(articleUrl)
        } else {
            backgroundScope.launch {
                openArticleWithId(articleId)
            }
        }
    }

    private suspend fun openArticleWithId(articleId: String) {
        val repository = Beacon.getRepositoryInstance()
        val article = repository.getArticleById(articleId)

        withContext(Dispatchers.Main) {
            title = article.name
            webView.loadDataWithBaseURL(
                "\'file:///android_asset/\'",
                article.text,
                "text/html",
                "utf-8",
                null
            )
            progressBar.visibility = View.GONE
        }
    }

    private fun openArticleUrl(articleUrl: String) {
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(articleUrl)
        startActivity(i)
        finish()
    }

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }
}
