package com.example.poc_architecture.views.adapters.viewholders.itemSearch.state

import android.view.View
import android.view.ViewGroup
import com.example.poc_architecture.utils.ViewMode
import com.example.poc_architecture.utils.ViewMode.*

class ItemSearchState(viewGroup: ViewGroup, val viewMode: ViewMode) {

    private var state: StateItemSearchViewHolder

    init {
        state = when(viewMode) {
            GRID -> ItemSearchGridState(viewGroup)
            LIST -> ItemSearchListState(viewGroup)
            GALLERY -> ItemSearchGalleryState(viewGroup)
        }
    }

    fun createView(): View {
        return state.createView(this, viewMode)
    }

    fun setSate(stateViewHolder: StateItemSearchViewHolder) {
        state = stateViewHolder
    }
}