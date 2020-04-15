package com.example.poc_architecture.views.adapters.viewholders.ads.state

import android.view.View
import com.example.poc_architecture.utils.ViewMode

interface StateAdsViewHolder {
    fun createView(adsState: AdsState, viewMode: ViewMode): View
}