package com.example.poc_architecture.views.adapters.viewholders.itemSearch.state

import android.view.View
import android.view.ViewGroup
import com.example.poc_architecture.utils.ViewMode

interface StateItemSearchViewHolder {
    val parent: ViewGroup
    fun createView(itemSearchState: ItemSearchState, viewMode: ViewMode): View
}