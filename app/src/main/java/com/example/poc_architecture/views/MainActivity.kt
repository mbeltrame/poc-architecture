package com.example.poc_architecture.views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import com.example.poc_architecture.R
import com.example.poc_architecture.adapters.ComponentsAdapter
import com.example.poc_architecture.dtos.*
import com.example.poc_architecture.utils.ViewMode
import com.example.poc_architecture.utils.ViewMode.*
import com.example.poc_architecture.utils.ViewType.*
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {

    private var viewMode: ViewMode = LIST
    private lateinit var adapter: ComponentsAdapter
    private var components: List<ComponentDTO>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeRecycler()
        createComponents()

        btn_list.setOnClickListener {
            viewMode = LIST
            adapter.onDetachedFromRecyclerView(recycler_view)
            initializeRecycler()
            createComponents()
        }
        btn_gallery.setOnClickListener {
            viewMode = GALLERY
            adapter.onDetachedFromRecyclerView(recycler_view)
            initializeRecycler()
            createComponents()
        }
        btn_grid.setOnClickListener {
            viewMode = GRID
            adapter.onDetachedFromRecyclerView(recycler_view)
            initializeRecycler()
            createComponents()
        }
    }

    private fun initializeRecycler() {
        viewMode.let {
            when (it) {
                LIST -> {
                    recycler_view?.layoutManager =
                        StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL)
                }
                GRID -> {
                    recycler_view?.layoutManager =
                        StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
                }
                GALLERY -> {
                    recycler_view?.layoutManager =
                        StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL)
                }
            }
        }

        adapter = ComponentsAdapter(viewMode)
        recycler_view?.adapter = adapter
    }

    private fun createComponents() {
        val components = ArrayList<ComponentDTO>()

        for (i in 1..4) {
            val itemSearchComponentDTO = ItemSearchComponentDTO("ITEM SEACH $i")
            itemSearchComponentDTO.id = ITEM_SEARCH.toString()
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
        carouselComponentDTO.id = ITEM_CAROUSEL.toString()
        carouselComponentDTO.state = "VISIBLE"
        components.add(carouselComponentDTO)

        for (i in 1..4) {
            val adsComponentDTO = AdsComponentDTO("ITEM ADS $i")
            adsComponentDTO.id = ITEM_ADS.toString()
            adsComponentDTO.state = "VISIBLE"
            components.add(adsComponentDTO)
        }

        this.components = components
        adapter.setComponents(components)
    }
}
