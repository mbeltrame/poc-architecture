package com.example.poc_architecture.views.adapters.viewholders.itemSearch.state

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.poc_architecture.R
import com.example.poc_architecture.utils.ViewMode
import com.example.poc_architecture.utils.ViewMode.LIST

class ItemSearchGalleryState(override val parent: ViewGroup) :
    StateItemSearchViewHolder {

    override fun createView(itemSearchState: ItemSearchState, viewMode: ViewMode): View {

        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_search_gallery_component_layout, parent, false)

        when (viewMode) {
            LIST -> itemSearchState.setSate(ItemSearchListState(parent))
            else -> itemSearchState.setSate(ItemSearchGalleryState(parent))
        }

        return layout
    }
}