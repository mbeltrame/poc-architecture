package com.example.poc_architecture.adapters.viewholders.itemSearch.state

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.poc_architecture.R
import com.example.poc_architecture.utils.ViewMode
import com.example.poc_architecture.utils.ViewMode.LIST

class ItemSearchGridState(private val parent: ViewGroup) :
    StateItemSearchViewHolder {

    override fun createView(itemSearchState: ItemSearchState, viewMode: ViewMode): View {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_search_grid_component_layout, parent, false)

        when (viewMode) {
            LIST -> itemSearchState.setSate(ItemSearchListState(parent))
            else -> itemSearchState.setSate(ItemSearchGalleryState(parent))
        }

        return itemView
    }
}