package com.example.poc_architecture.adapters.viewholders.carousel.state

import android.view.View
import android.view.ViewGroup
import com.example.poc_architecture.utils.ViewMode
import com.example.poc_architecture.utils.ViewMode.*

class CarouselState(viewGroup: ViewGroup, val viewMode: ViewMode) {

    private var state: StateCarouselViewHolder

    init {
        state = when(viewMode) {
            GRID -> CarouselGridState(viewGroup)
            LIST -> CarouselListState(viewGroup)
            GALLERY -> CarouselGalleryState(viewGroup)
        }
    }

    fun createView(): View {
        return state.createView(this, viewMode)
    }

    fun setSate(stateViewHolder: StateCarouselViewHolder) {
        state = stateViewHolder
    }
}