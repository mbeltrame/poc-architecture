package com.example.poc_architecture.adapters.viewholders.carousel

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.poc_architecture.R
import com.example.poc_architecture.adapters.viewholders.ComponentsViewHolder
import com.example.poc_architecture.adapters.viewholders.carousel.adapter.CarouselAdapter
import com.example.poc_architecture.dtos.CarouselComponentDTO
import com.example.poc_architecture.dtos.ComponentDTO
import com.example.poc_architecture.utils.ViewMode

class CarouselViewHolder(itemView: View, parent: ViewGroup, viewMode: ViewMode) :
    ComponentsViewHolder(itemView, parent, viewMode) {

    private val adapter = CarouselAdapter()

    init {
        (itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams).isFullSpan = true
        val recyclerView = itemView.findViewById<RecyclerView>(R.id.carousel_recycler_view)
        recyclerView.layoutManager =
            LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)

        recyclerView.adapter = adapter
    }

    override fun bind(componentDTO: ComponentDTO) {
        val carouselComponentDTO = (componentDTO as CarouselComponentDTO)
        adapter.submitList(carouselComponentDTO.itemsCarousel)
    }
}