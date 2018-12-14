package com.helpscout.beacon.sample.core

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.helpscout.beacon.internal.core.model.BeaconArticleSuggestion
import net.helpscout.samples.beacon.core.R

internal class SuggestionsAdapter(
        private var suggestions: List<BeaconArticleSuggestion>,
        private val itemClick: (BeaconArticleSuggestion) -> Unit)
    : BaseAdapter() {

    override fun getCount() = suggestions.size

    override fun getItem(i: Int) = suggestions[i]

    override fun getItemId(i: Int) = i.toLong()

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        val suggestion = getItem(i)
        val rowView = view ?: LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.view_suggestion_item, viewGroup, false)

        renderSuggestion(rowView, suggestion)
        setClickableListener(rowView, suggestion)
        return rowView
    }

    private fun renderSuggestion(view: View, suggestion: BeaconArticleSuggestion) {
        val suggestionLabel = view.findViewById<TextView>(R.id.suggestion_item_label)
        val isLinkImage = view.findViewById<ImageView>(R.id.suggestion_item_is_link)
        if (suggestion.isLink()) {
            suggestionLabel.text = suggestion.suggestion.text
            isLinkImage.visibility = View.VISIBLE
        } else {
            suggestionLabel.text = suggestion.suggestion.name
            isLinkImage.visibility = View.INVISIBLE
        }
    }

    private fun setClickableListener(rowView: View, suggestion: BeaconArticleSuggestion) {
        rowView.setOnClickListener {
            itemClick(suggestion)
        }
    }

    fun updateSuggestions(newSuggestions: List<BeaconArticleSuggestion>) {
        suggestions = newSuggestions
        notifyDataSetChanged()
    }


}
