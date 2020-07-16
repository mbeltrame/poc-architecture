package com.example.poc_architecture.views.adapters.viewholders.ads

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.poc_architecture.R
import com.example.poc_architecture.views.adapters.viewholders.ComponentsViewHolder
import com.example.poc_architecture.models.AdsComponentDTO
import com.example.poc_architecture.models.ComponentDTO
import com.example.poc_architecture.utils.ViewMode

class AdsViewHolder(itemView: View, parent: ViewGroup, viewMode: ViewMode) :
    ComponentsViewHolder(itemView, parent, viewMode) {

    override fun bind(componentDTO: ComponentDTO, position: Int?) {
        val carouselComponentDTO = (componentDTO as AdsComponentDTO)

        val textView = itemView.findViewById<TextView>(R.id.text_ads)
        textView.text = carouselComponentDTO.text
    }
}