package com.yakov.weber.galleryview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.yakov.weber.galleryview.adapter.PageImageRecyclerAdapter
import com.yakov.weber.galleryview.mock.DataSourceUrl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        page_recycler_view.adapter = PageImageRecyclerAdapter(DataSourceUrl.getListUrl())
        { position, url -> click(url, position) }
        page_recycler_view.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
    }

    private fun click(url: String, position: Int) {
        Toast.makeText(this, url, Toast.LENGTH_SHORT).show()
    }
}
