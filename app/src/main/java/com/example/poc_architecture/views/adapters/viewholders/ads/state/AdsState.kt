package com.example.poc_architecture.views.adapters.viewholders.ads.state

import android.view.View
import android.view.ViewGroup
import com.example.poc_architecture.utils.ViewMode
import com.example.poc_architecture.utils.ViewMode.*

class AdsState(viewGroup: ViewGroup, val viewMode: ViewMode) {

    private var state: StateAdsViewHolder

    init {
        state = when(viewMode) {
            GRID -> AdsGridState(viewGroup)
            LIST -> AdsListState(viewGroup)
            GALLERY -> AdsGalleryState(viewGroup)
        }
    }

    fun createView(): View {
        return state.createView(this, viewMode)
    }

    fun setSate(stateViewHolder: StateAdsViewHolder) {
        state = stateViewHolder
    }
}