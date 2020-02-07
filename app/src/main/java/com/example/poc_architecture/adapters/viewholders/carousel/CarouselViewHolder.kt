package com.example.poc_architecture.adapters.viewholders.carousel

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.poc_architecture.R
import com.example.poc_architecture.adapters.viewholders.ComponentsViewHolder
import com.example.poc_architecture.adapters.viewholders.carousel.adapter.CarouselAdapter
import com.example.poc_architecture.dtos.CarouselComponentDTO
import com.example.poc_architecture.dtos.ComponentDTO
import com.example.poc_architecture.utils.ViewMode

class CarouselViewHolder(itemView: View, parent: ViewGroup, viewMode: ViewMode) :
    ComponentsViewHolder(itemView, parent, viewMode) {

    private val adapter = CarouselAdapter()

    override fun bind(componentDTO: ComponentDTO) {
        val carouselComponentDTO = (componentDTO as CarouselComponentDTO)

        val recyclerView = itemView.findViewById<RecyclerView>(R.id.carousel_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(itemView.context, LinearLayout.HORIZONTAL, false)

        recyclerView.adapter = adapter
        adapter.setComponents(carouselComponentDTO.itemsCarousel)
    }
}