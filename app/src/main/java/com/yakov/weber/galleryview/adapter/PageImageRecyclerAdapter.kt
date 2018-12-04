package com.yakov.weber.galleryview.adapter

import android.support.v7.widget.RecyclerView
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.yakov.weber.galleryview.R
import kotlinx.android.synthetic.main.item_page_adapter.view.*

/**
 * Created on 28.11.18
 * @author YWeber
 * project GalleryView */

class PageImageRecyclerAdapter(private val listUrlImage: List<String>,private val clickItem: (Int, String) -> Unit) :
    RecyclerView.Adapter<PageImageRecyclerAdapter.PageImageViewHolder>() {

    private var selectPos:Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_page_adapter, parent, false)
        return PageImageViewHolder(view)
    }

    override fun getItemCount(): Int = listUrlImage.size

    override fun onBindViewHolder(holder: PageImageViewHolder, position: Int) {
        holder.bind(listUrlImage[position])
        holder.itemView.isSelected = selectPos == position
    }

    fun getToPositionPager(position:Int){
        notifyItemChanged(selectPos)
        selectPos = position
        notifyItemChanged(position)
    }

    inner class PageImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(urlString: String) {
            Glide.with(itemView.page_image_view.context)
                .load(urlString)
                .into(itemView.page_image_view)
            itemView.setOnClickListener {
                notifyItemChanged(selectPos)
                selectPos = adapterPosition
                notifyItemChanged(adapterPosition)
                clickItem(position,listUrlImage[position])
            }
        }

    }
}