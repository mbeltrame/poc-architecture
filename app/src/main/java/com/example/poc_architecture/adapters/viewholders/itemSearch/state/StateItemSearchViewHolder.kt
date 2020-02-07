package com.example.poc_architecture.adapters.viewholders.itemSearch.state

import android.view.View
import com.example.poc_architecture.utils.ViewMode

interface StateItemSearchViewHolder {
    fun createView(itemSearchState: ItemSearchState, viewMode: ViewMode): View
}