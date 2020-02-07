package com.example.poc_architecture.adapters.viewholders.itemSearch.state

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.poc_architecture.R
import com.example.poc_architecture.utils.ViewMode
import com.example.poc_architecture.utils.ViewMode.GRID

class ItemSearchListState(private val parent: ViewGroup) :
    StateItemSearchViewHolder {

    override fun createView(itemSearchState: ItemSearchState, viewMode: ViewMode): View {

        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_search_list_component_layout, parent, false)

        when (viewMode) {
            GRID -> itemSearchState.setSate(ItemSearchGridState(parent))
            else -> itemSearchState.setSate(ItemSearchGalleryState(parent))
        }

        return layout
    }
}