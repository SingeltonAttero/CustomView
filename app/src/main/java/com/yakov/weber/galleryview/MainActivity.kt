package com.yakov.weber.galleryview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yakov.weber.galleryview.mock.DataSourceUrl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gallery_view.setImageList(DataSourceUrl.getListUrl())
    }
}
