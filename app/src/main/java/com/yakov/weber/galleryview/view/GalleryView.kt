package com.yakov.weber.galleryview.view

import android.content.Context
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.yakov.weber.galleryview.R
import com.yakov.weber.galleryview.adapter.GalleryPagerAdapter
import com.yakov.weber.galleryview.adapter.PageImageRecyclerAdapter
import kotlinx.android.synthetic.main.view_layout_container.view.*

/**
 * Created on 04.12.18
 * @author YWeber
 * project GalleryView */

class GalleryView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr),ViewPager.OnPageChangeListener {
    init {
        View.inflate(context, R.layout.view_layout_container,this)
    }


    fun setImageList(listUrl: MutableList<String>){
        if (listUrl.isNotEmpty()){
            gallery_pager.adapter = GalleryPagerAdapter(listUrl)
            gallery_pager.addOnPageChangeListener(this)
            page_recycler_view.adapter = PageImageRecyclerAdapter(listUrl)
            { position, url ->  clickItemRecycler(url,position)}
            page_recycler_view.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        }
    }

    private fun clickItemRecycler(url:String, position: Int){
            gallery_pager.currentItem = position
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        (page_recycler_view.adapter as PageImageRecyclerAdapter).getToPositionPager(position)
        page_recycler_view.scrollToPosition(position)
    }
    override fun onPageScrollStateChanged(state: Int) {}
    override fun onPageSelected(position: Int) {}

}