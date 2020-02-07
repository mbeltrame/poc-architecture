package com.example.poc_architecture.adapters.viewholders.ads

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.poc_architecture.R
import com.example.poc_architecture.adapters.viewholders.ComponentsViewHolder
import com.example.poc_architecture.dtos.AdsComponentDTO
import com.example.poc_architecture.dtos.ComponentDTO
import com.example.poc_architecture.utils.ViewMode

class AdsViewHolder(itemView: View, parent: ViewGroup, viewMode: ViewMode) :
    ComponentsViewHolder(itemView, parent, viewMode) {

    override fun bind(componentDTO: ComponentDTO) {
        val carouselComponentDTO = (componentDTO as AdsComponentDTO)

        val textView = itemView.findViewById<TextView>(R.id.text_ads)
        textView.text = carouselComponentDTO.text
        textView.setTextColor(Color.RED)
    }
}