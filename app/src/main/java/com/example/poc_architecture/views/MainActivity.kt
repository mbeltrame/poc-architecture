package com.example.poc_architecture.views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import com.example.poc_architecture.R
import com.example.poc_architecture.adapters.ComponentsAdapter
import com.example.poc_architecture.dtos.ComponentDTO
import com.example.poc_architecture.repository.ComponentsRepository
import com.example.poc_architecture.utils.ViewMode
import com.example.poc_architecture.utils.ViewMode.*
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
        this.components = ComponentsRepository.createComponents()
        adapter.setComponents(components!!)

        btn_list.setOnClickListener {
            listenerBtn(LIST)
        }
        btn_gallery.setOnClickListener {
            listenerBtn(GALLERY)
        }
        btn_grid.setOnClickListener {
            listenerBtn(GRID)
        }
    }

    private fun listenerBtn(mode: ViewMode) {
        viewMode = mode
        adapter.onDetachedFromRecyclerView(recycler_view)
        initializeRecycler()
        this.components = ComponentsRepository.createComponents()
        adapter.setComponents(components!!)
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
}
