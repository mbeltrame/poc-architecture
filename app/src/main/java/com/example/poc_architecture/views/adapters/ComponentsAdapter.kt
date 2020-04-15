package com.example.poc_architecture.views.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.poc_architecture.views.adapters.viewholders.ComponentsViewHolder
import com.example.poc_architecture.dtos.ComponentDTO
import com.example.poc_architecture.utils.ViewMode
import com.example.poc_architecture.utils.ViewType

class ComponentsAdapter(val viewMode: ViewMode) : ListAdapter<ComponentDTO, ComponentsViewHolder>(REPO_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComponentsViewHolder {
        return ComponentViewHolderFactory.getComponent(parent, viewType, viewMode)
    }

    override fun onBindViewHolder(viewHolder: ComponentsViewHolder, position: Int) {
        getItem(position)?.let {
            if (it.hasValidState()) {
                viewHolder.bind(it)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        getItem(position)?.id?.let { id ->
            return ViewType.numberById(id)
        }
        return 0
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<ComponentDTO>() {
            override fun areItemsTheSame(oldItem: ComponentDTO, newItem: ComponentDTO): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: ComponentDTO, newItem: ComponentDTO): Boolean =
                oldItem.state == newItem.state
        }
    }
}