package com.example.poc_architecture.views.adapters.viewholders.itemSearch

import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.poc_architecture.R
import com.example.poc_architecture.models.ComponentDTO
import com.example.poc_architecture.models.ItemSearchComponentDTO
import com.example.poc_architecture.utils.ICallbackShowMore
import com.example.poc_architecture.utils.ViewMode
import com.example.poc_architecture.views.IListenerUpdate
import com.example.poc_architecture.views.adapters.viewholders.ComponentsViewHolder
import com.example.poc_architecture.views.custom.HighlightView
import com.example.poc_architecture.views.custom.ShowMoreTextView

class ItemSearchViewHolder(
    itemView: View,
    parent: ViewGroup,
    viewMode: ViewMode,
    private val listenerUpdate: IListenerUpdate? = null,
    private val iCallbackShowMore: ICallbackShowMore? = null
) : ComponentsViewHolder(itemView, parent, viewMode) {

    private val showMore = itemView.findViewById<ShowMoreTextView>(R.id.text_item_search)
    private val highlightView = itemView.findViewById<HighlightView>(R.id.highlight_view)
    private val btnUpdate = itemView.findViewById<Button>(R.id.btn_update)
//    private val textView = itemView.findViewById<TextView>(R.id.text_view)
//    private val container = itemView.findViewById<LinearLayout>(R.id.container_text_view)

    override fun bind(componentDTO: ComponentDTO, position: Int?) {
        val itemSearchComponentDTO = (componentDTO as ItemSearchComponentDTO)
        showMore.iCallbackShowMore = iCallbackShowMore
        showMore.text = itemSearchComponentDTO.text
        showMore.position = position
        showMore.extraText = "17/07/2020"
        showMore.updateView(componentDTO.expanded)
        highlightView.bindLayout(componentDTO.highlightDeal)
        btnUpdate?.setOnClickListener {
            position?.let { pos ->
                listenerUpdate?.updateView(pos)
            }
        }
//        textView.text = itemSearchComponentDTO.text
//        container.setShadow(R.color.background_image, R.dimen.radius, R.dimen.elevation, Gravity.BOTTOM, R.color.white)
    }
}