package com.example.poc_architecture.adapters

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ViewGroup
import com.example.poc_architecture.adapters.viewholders.ComponentsViewHolder
import com.example.poc_architecture.dtos.ComponentDTO
import com.example.poc_architecture.utils.ViewMode
import com.example.poc_architecture.utils.ViewType

class ComponentsAdapter(val viewMode: ViewMode) : RecyclerView.Adapter<ComponentsViewHolder>() {

    private var components: List<ComponentDTO>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComponentsViewHolder {
        return ComponentViewHolderFactory.getComponent(parent, viewType, viewMode)
    }

    override fun getItemCount(): Int {
        return components?.size ?: 0
    }

    override fun onBindViewHolder(viewHolder: ComponentsViewHolder, position: Int) {
        components?.get(position)?.let {
            if (it.hasValidState()) {
                viewHolder.bind(it)
            }
        }
    }

    fun setComponents(components: List<ComponentDTO>) {
        this.components = components
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        components?.let {
            it[position].id?.let { id ->
                return ViewType.numberById(id)
            }
        }
        return 0
    }
}