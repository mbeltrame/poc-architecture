package com.example.poc_architecture.views.adapters.viewholders

import android.view.View
import android.view.ViewGroup
import com.example.poc_architecture.models.ComponentDTO
import com.example.poc_architecture.utils.ViewMode
import com.example.poc_architecture.utils.ViewMode.LIST

abstract class ComponentsViewHolder(itemView: View, parent: ViewGroup, viewMode: ViewMode = LIST) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

    abstract fun bind(componentDTO: ComponentDTO)
}