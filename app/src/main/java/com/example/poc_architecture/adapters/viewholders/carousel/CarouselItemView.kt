package com.example.poc_architecture.adapters.viewholders.carousel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.poc_architecture.R

class CarouselItemView(private val parent: ViewGroup) {

    fun createView(): View {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.carousel_list_component_layout, parent, false)
    }
}