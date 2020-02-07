package com.example.poc_architecture.utils

enum class ViewType(private val id: String) {
    ITEM_SEARCH("ITEM_SEARCH"), ITEM_CAROUSEL("ITEM_CAROUSEL"), ITEM_ADS("ITEM_ADS");

    override fun toString(): String {
        return id
    }

    companion object {
        fun numberById(id: String): Int {
            return when (id) {
                ITEM_SEARCH.toString() -> 0
                ITEM_CAROUSEL.toString() -> 1
                ITEM_ADS.toString() -> 2
                else -> 0
            }
        }

        fun idByNumber(number: Int): ViewType {
            return when (number) {
                0 -> ITEM_SEARCH
                1 -> ITEM_CAROUSEL
                2 -> ITEM_ADS
                else -> ITEM_SEARCH
            }
        }
    }
}