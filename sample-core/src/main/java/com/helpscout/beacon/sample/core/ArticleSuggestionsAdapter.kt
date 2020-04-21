package com.helpscout.beacon.sample.core

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.helpscout.beacon.internal.core.model.ArticleApi
import net.helpscout.samples.beacon.core.R

internal class ArticleSuggestionsAdapter(
    private var articles: List<ArticleApi>,
    private val itemClick: (ArticleApi) -> Unit
) : BaseAdapter() {

    override fun getCount() = articles.size

    override fun getItem(i: Int) = articles[i]

    override fun getItemId(i: Int) = i.toLong()

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        val suggestion = getItem(i)
        val rowView = view ?: LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.view_suggestion_item, viewGroup, false)

        renderArticles(rowView, suggestion)
        setClickableListener(rowView, suggestion)
        return rowView
    }

    private fun renderArticles(view: View, article: ArticleApi) {
        val suggestionLabel = view.findViewById<TextView>(R.id.suggestion_item_label)
        val isLinkImage = view.findViewById<ImageView>(R.id.suggestion_item_is_link)
        when (article) {
            is ArticleApi.CustomLink -> {
                suggestionLabel.text = article.title
                isLinkImage.visibility = View.VISIBLE
            }
            is ArticleApi.ArticleDocPreview -> {
                suggestionLabel.text = article.name
                isLinkImage.visibility = View.INVISIBLE
            }
        }
    }

    private fun setClickableListener(rowView: View, suggestion: ArticleApi) {
        rowView.setOnClickListener {
            itemClick(suggestion)
        }
    }

    fun updateSuggestions(newSuggestions: List<ArticleApi>) {
        articles = newSuggestions
        notifyDataSetChanged()
    }
}
