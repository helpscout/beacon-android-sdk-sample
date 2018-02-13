package com.helpscout.beacon.sample.core

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
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
        val rowName = view.findViewById<TextView>(R.id.suggestion_item_label)
        if (suggestion.type.equals("link")){
            rowName.text = suggestion.suggestion.text
        } else {
            rowName.text = suggestion.suggestion.name
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
