package com.example.poc_architecture.adapters.viewholders.carousel.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.poc_architecture.R
import com.example.poc_architecture.dtos.ItemCarouselComponentDTO

class CarouselAdapter : RecyclerView.Adapter<CarouselAdapter.ViewHolder>() {

    private var components: List<ItemCarouselComponentDTO>? = null

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_carousel_component_layout, parent, false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return components?.size ?: 0
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        components?.get(position)?.let {
            if (it.hasValidState()) {
                viewHolder.bind(it)
            }
        }
    }

    fun setComponents(components: List<ItemCarouselComponentDTO>) {
        this.components = components
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(componentDTO: ItemCarouselComponentDTO) {

            val textView = itemView.findViewById<TextView>(R.id.text_carousel)
            textView.text = componentDTO.text
        }
    }
}