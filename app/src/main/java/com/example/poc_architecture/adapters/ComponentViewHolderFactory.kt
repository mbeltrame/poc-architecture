package com.example.poc_architecture.adapters

import android.view.ViewGroup
import com.example.poc_architecture.adapters.viewholders.ComponentsViewHolder
import com.example.poc_architecture.adapters.viewholders.ads.AdsViewHolder
import com.example.poc_architecture.adapters.viewholders.ads.state.AdsState
import com.example.poc_architecture.adapters.viewholders.carousel.CarouselViewHolder
import com.example.poc_architecture.adapters.viewholders.carousel.state.CarouselState
import com.example.poc_architecture.adapters.viewholders.itemSearch.ItemSearchViewHolder
import com.example.poc_architecture.adapters.viewholders.itemSearch.state.ItemSearchState
import com.example.poc_architecture.utils.ViewMode
import com.example.poc_architecture.utils.ViewType
import com.example.poc_architecture.utils.ViewType.*

class ComponentViewHolderFactory {

    companion object {
        fun getComponent(parent: ViewGroup, viewType: Int, viewMode: ViewMode)
                : ComponentsViewHolder {

            return when (ViewType.idByNumber(viewType)) {
                ITEM_SEARCH -> {
                    val itemView = ItemSearchState(parent, viewMode).createView()
                    ItemSearchViewHolder(itemView, parent, viewMode)
                }
                ITEM_CAROUSEL -> {
                    val itemView = CarouselState(parent, viewMode).createView()
                    CarouselViewHolder(itemView, parent, viewMode)
                }
                ITEM_ADS -> {
                    val itemView = AdsState(parent, viewMode).createView()
                    AdsViewHolder(itemView, parent, viewMode)
                }
            }
        }
    }
}