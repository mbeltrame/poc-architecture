package com.example.poc_architecture.repository

import com.example.poc_architecture.models.*
import com.example.poc_architecture.utils.ViewType.*

class ComponentsRepository {

    companion object {

        private fun createHighlights(): HighlightDeal {
            return HighlightDeal(Label("NUEVO ALSJDLASKJDLA ALKSJD LASKD JALSKD A", "#FFFFFF", "#3483FA"), "ic_test", null)
        }
        fun fetchComponents(): List<ComponentDTO> {
            val components = ArrayList<ComponentDTO>()

            for (i in 1..10) {
                val itemSearchComponentDTO = ItemSearchComponentDTO("ITEM SEACH ALSK D ALSK DLAKS DL AKS AKS DL A KS DALKSD ALKSD LAKSD DKS DLADKALSKD ALSK $i")
                itemSearchComponentDTO.id = ITEM_SEARCH.toString()
                itemSearchComponentDTO.state = "VISIBLE"
                itemSearchComponentDTO.highlightDeal = createHighlights()
                components.add(itemSearchComponentDTO)
            }

            val itemsCarousel = ArrayList<ItemCarouselComponentDTO>()
            for (j in 1..4) {
                val itemCarouselComponentDTO = ItemCarouselComponentDTO("ITEM $j")
                itemCarouselComponentDTO.state = "VISIBLE"
                itemsCarousel.add(itemCarouselComponentDTO)
            }

            val carouselComponentDTO = CarouselComponentDTO("CAROUSEL (1)", itemsCarousel)
            carouselComponentDTO.id = ITEM_CAROUSEL.toString()
            carouselComponentDTO.state = "VISIBLE"
            components.add(carouselComponentDTO)

            for (i in 1..4) {
                val adsComponentDTO = AdsComponentDTO("ITEM ADS $i")
                adsComponentDTO.id = ITEM_ADS.toString()
                adsComponentDTO.state = "VISIBLE"
                components.add(adsComponentDTO)
            }

            val itemsCarousel2 = ArrayList<ItemCarouselComponentDTO>()
            for (j in 1..4) {
                val itemCarouselComponentDTO = ItemCarouselComponentDTO("ITEM (2) $j")
                itemCarouselComponentDTO.state = "VISIBLE"
                itemsCarousel2.add(itemCarouselComponentDTO)
            }

            val carouselComponentDTO2 = CarouselComponentDTO("CAROUSEL (2)", itemsCarousel2)
            carouselComponentDTO2.id = ITEM_CAROUSEL.toString()
            carouselComponentDTO2.state = "VISIBLE"
            components.add(carouselComponentDTO2)
            return components
        }

    }
}