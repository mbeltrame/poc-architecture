package com.example.poc_architecture.views.adapters.viewholders.ads.state

import android.view.View
import android.view.ViewGroup
import com.example.poc_architecture.utils.ViewMode

interface StateAdsViewHolder {
    val parent: ViewGroup
    fun createView(adsState: AdsState, viewMode: ViewMode): View
}