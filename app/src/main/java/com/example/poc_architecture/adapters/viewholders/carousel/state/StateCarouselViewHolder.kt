package com.example.poc_architecture.adapters.viewholders.carousel.state

import android.view.View
import com.example.poc_architecture.utils.ViewMode

interface StateCarouselViewHolder {
    fun createView(carouselState: CarouselState, viewMode: ViewMode): View
}