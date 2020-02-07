package com.example.poc_architecture.dtos

abstract class ComponentDTO(var id: String? = null, var state: String? = null) {

    open fun hasValidState(): Boolean = STATE_HIDDEN != state

    companion object {
        const val STATE_HIDDEN = "HIDDEN"
    }
}