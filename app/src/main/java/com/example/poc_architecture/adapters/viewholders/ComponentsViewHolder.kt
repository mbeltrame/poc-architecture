package com.example.poc_architecture.adapters.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.poc_architecture.dtos.ComponentDTO
import com.example.poc_architecture.utils.ViewMode

abstract class ComponentsViewHolder(itemView: View, parent: ViewGroup, viewMode: ViewMode) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(componentDTO: ComponentDTO)
}