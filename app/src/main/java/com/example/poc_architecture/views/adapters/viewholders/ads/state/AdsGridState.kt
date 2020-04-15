package com.example.poc_architecture.views.adapters.viewholders.ads.state

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.poc_architecture.R
import com.example.poc_architecture.utils.ViewMode
import com.example.poc_architecture.utils.ViewMode.LIST

class AdsGridState(override val parent: ViewGroup) :
    StateAdsViewHolder {

    override fun createView(adsState: AdsState, viewMode: ViewMode): View {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.ads_grid_component_layout, parent, false)

        when (viewMode) {
            LIST -> adsState.setSate(AdsListState(parent))
            else -> adsState.setSate(AdsGalleryState(parent))
        }

        return itemView
    }
}