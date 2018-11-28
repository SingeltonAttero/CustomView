package com.yakov.weber.galleryview.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.yakov.weber.galleryview.R
import kotlinx.android.synthetic.main.item_page_adapter.view.*
import java.util.zip.Inflater

/**
 * Created on 28.11.18
 * @author YWeber
 * project GalleryView */

class PageImageRecyclerAdapter (private val listUrlImage: List<String>,val clickItem:(Int,String) -> Unit) :
    RecyclerView.Adapter<PageImageRecyclerAdapter.PageImageViewHolder>() {

    private val allView:MutableList<View> = arrayListOf()
    private val selectedView:MutableList<View> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_page_adapter,parent,false)
        return PageImageViewHolder(view)
    }

    override fun getItemCount(): Int = listUrlImage.size

    override fun onBindViewHolder(holder: PageImageViewHolder, position: Int) {
        holder.bind(listUrlImage[position])
        allView.add(holder.itemView)
    }

    inner class PageImageViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        fun bind(urlString:String){
            Glide.with(itemView.context)
                .load(listUrlImage[adapterPosition])
                .into(itemView.page_image_view)
            itemView.setOnClickListener {
                selectedView.forEachIndexed { index, _ ->
                    selectedView.removeAt(index).isSelected = false
                }
                selectedView.add(itemView)
                itemView.isSelected = true
                clickItem(adapterPosition,urlString)
            }

        }
    }
}