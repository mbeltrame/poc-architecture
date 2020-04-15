package com.example.poc_architecture.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.poc_architecture.R
import com.example.poc_architecture.adapters.ComponentsAdapter
import com.example.poc_architecture.repository.ComponentsRepository
import com.example.poc_architecture.utils.ViewMode
import com.example.poc_architecture.utils.ViewMode.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var viewMode: ViewMode = LIST
    private lateinit var adapter: ComponentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeRecycler()
        adapter.submitList(ComponentsRepository.fetchComponents())

        btn_list.setOnClickListener { listenerBtn(LIST) }
        btn_gallery.setOnClickListener { listenerBtn(GALLERY) }
        btn_grid.setOnClickListener { listenerBtn(GRID) }
    }

    // A esta funcion no le des pelota, es para refrescar la vista
    private fun listenerBtn(mode: ViewMode) {
        viewMode = mode
        initializeRecycler()
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
        adapter.submitList(ComponentsRepository.fetchComponents())
    }
}
