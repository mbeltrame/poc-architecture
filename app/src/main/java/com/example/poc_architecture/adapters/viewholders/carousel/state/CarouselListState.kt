package com.example.poc_architecture.adapters.viewholders.carousel.state

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.poc_architecture.R
import com.example.poc_architecture.utils.ViewMode
import com.example.poc_architecture.utils.ViewMode.GRID

class CarouselListState(private val parent: ViewGroup) :
    StateCarouselViewHolder {

    override fun createView(carouselState: CarouselState, viewMode: ViewMode): View {

        val layout = LayoutInflater.from(parent.context).inflate(R.layout.carousel_list_component_layout, parent, false)

        when (viewMode) {
            GRID -> carouselState.setSate(CarouselGridState(parent))
            else -> carouselState.setSate(CarouselGalleryState(parent))
        }

        val text = layout.findViewById<TextView>(R.id.text_carousel)
        text.setTextColor(Color.YELLOW)
        return layout
    }
}