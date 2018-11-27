package com.yakov.weber.galleryview.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

/**
 * Created on 28.11.18
 * @author YWeber
 * project GalleryView */

class PageImageRecyclerAdapter (private val listUrlImage: List<String>) :
    RecyclerView.Adapter<PageImageRecyclerAdapter.PageImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageImageViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int = listUrlImage.size

    override fun onBindViewHolder(holder: PageImageViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class PageImageViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

    }
}