package com.example.poc_architecture.models

abstract class ComponentDTO(var id: String? = null, var state: String? = null, var highlightDeal: HighlightDeal? = null, var expanded: Boolean = false) {

    open fun hasValidState(): Boolean = STATE_HIDDEN != state

    companion object {
        const val STATE_HIDDEN = "HIDDEN"
    }
}