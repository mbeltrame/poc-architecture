package com.example.poc_architecture.adapters.viewholders.carousel

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.poc_architecture.R
import com.example.poc_architecture.adapters.viewholders.ComponentsViewHolder
import com.example.poc_architecture.dtos.CarouselComponentDTO
import com.example.poc_architecture.dtos.ComponentDTO
import com.example.poc_architecture.utils.ViewMode

class CarouselViewHolder(itemView: View, parent: ViewGroup, viewMode: ViewMode) :
    ComponentsViewHolder(itemView, parent, viewMode) {

    override fun bind(componentDTO: ComponentDTO) {
        val carouselComponentDTO = (componentDTO as CarouselComponentDTO)

        val textView = itemView.findViewById<TextView>(R.id.text_carousel)
        textView.text = carouselComponentDTO.text
        textView.setTextColor(Color.GREEN)
    }
}