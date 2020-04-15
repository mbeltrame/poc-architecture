package com.example.poc_architecture.views.adapters.viewholders.itemSearch

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.poc_architecture.R
import com.example.poc_architecture.views.adapters.viewholders.ComponentsViewHolder
import com.example.poc_architecture.models.ComponentDTO
import com.example.poc_architecture.models.ItemSearchComponentDTO
import com.example.poc_architecture.utils.ViewMode

class ItemSearchViewHolder(itemView: View, parent: ViewGroup, viewMode: ViewMode) :
    ComponentsViewHolder(itemView, parent, viewMode) {

    override fun bind(componentDTO: ComponentDTO) {
        val itemSearchComponentDTO = (componentDTO as ItemSearchComponentDTO)

        val textView = itemView.findViewById<TextView>(R.id.text_item_search)
        textView.text = itemSearchComponentDTO.text
    }
}