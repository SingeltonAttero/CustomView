package com.yakov.weber.galleryview.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.yakov.weber.galleryview.R
import kotlinx.android.synthetic.main.item_gallery_adapter.view.*
import kotlinx.android.synthetic.main.item_page_adapter.view.*

/**
 * Created on 29.11.18
 * @author YWeber
 * project GalleryView */

class GalleryPagerAdapter(private val listUrl:MutableList<String>) : PagerAdapter() {

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context).inflate(R.layout.item_gallery_adapter,container,false)
        val holder = GalleryViewHolder(view)
        Glide.with(container.context)
            .asBitmap()
            .load(listUrl[position])
            .into(holder.itemView.gallery_image_view)

        container.addView(view)
        return view
    }

    override fun isViewFromObject(view: View, data: Any): Boolean = view == data
    override fun getCount(): Int = listUrl.size

    inner class GalleryViewHolder(val itemView:View)

}