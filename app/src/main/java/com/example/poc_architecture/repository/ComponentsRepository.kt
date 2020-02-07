package com.example.poc_architecture.repository

import com.example.poc_architecture.dtos.*
import com.example.poc_architecture.utils.ViewType

class ComponentsRepository {

    companion object {
        fun createComponents(): List<ComponentDTO> {
            val components = ArrayList<ComponentDTO>()

            for (i in 1..4) {
                val itemSearchComponentDTO = ItemSearchComponentDTO("ITEM SEACH $i")
                itemSearchComponentDTO.id = ViewType.ITEM_SEARCH.toString()
                itemSearchComponentDTO.state = "VISIBLE"
                components.add(itemSearchComponentDTO)
            }


            val itemsCarousel = ArrayList<ItemCarouselComponentDTO>()
            for (j in 1..4) {
                val itemCarouselComponentDTO = ItemCarouselComponentDTO("ITEM $j")
                itemCarouselComponentDTO.state = "VISIBLE"
                itemsCarousel.add(itemCarouselComponentDTO)
            }

            val carouselComponentDTO = CarouselComponentDTO("CAROUSEL", itemsCarousel)
            carouselComponentDTO.id = ViewType.ITEM_CAROUSEL.toString()
            carouselComponentDTO.state = "VISIBLE"
            components.add(carouselComponentDTO)

            for (i in 1..4) {
                val adsComponentDTO = AdsComponentDTO("ITEM ADS $i")
                adsComponentDTO.id = ViewType.ITEM_ADS.toString()
                adsComponentDTO.state = "VISIBLE"
                components.add(adsComponentDTO)
            }
            return components
        }
    }
}