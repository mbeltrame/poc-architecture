package com.example.poc_architecture.adapters.viewholders.carousel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.poc_architecture.R
import com.example.poc_architecture.dtos.ItemCarouselComponentDTO

class CarouselAdapter : ListAdapter<ItemCarouselComponentDTO, CarouselAdapter.ViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_carousel_component_layout, parent, false)
        return ViewHolder(layout)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        getItem(position)?.let {
            if (it.hasValidState()) {
                viewHolder.bind(it)
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(componentDTO: ItemCarouselComponentDTO) {
            val textView = itemView.findViewById<TextView>(R.id.text_carousel)
            textView.text = componentDTO.text
        }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<ItemCarouselComponentDTO>() {
            override fun areItemsTheSame(oldItem: ItemCarouselComponentDTO, newItem: ItemCarouselComponentDTO): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: ItemCarouselComponentDTO, newItem: ItemCarouselComponentDTO): Boolean =
                oldItem.text == newItem.text
        }
    }
}