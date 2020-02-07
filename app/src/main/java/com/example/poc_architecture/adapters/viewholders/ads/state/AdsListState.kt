package com.example.poc_architecture.adapters.viewholders.ads.state

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.poc_architecture.R
import com.example.poc_architecture.utils.ViewMode
import com.example.poc_architecture.utils.ViewMode.GRID

class AdsListState(private val parent: ViewGroup) :
    StateAdsViewHolder {

    override fun createView(adsState: AdsState, viewMode: ViewMode): View {

        val layout = LayoutInflater.from(parent.context).inflate(R.layout.ads_list_component_layout, parent, false)

        when (viewMode) {
            GRID -> adsState.setSate(AdsGridState(parent))
            else -> adsState.setSate(AdsGalleryState(parent))
        }

        val text = layout.findViewById<TextView>(R.id.text_ads)
        text.setTextColor(Color.YELLOW)
        return layout
    }
}