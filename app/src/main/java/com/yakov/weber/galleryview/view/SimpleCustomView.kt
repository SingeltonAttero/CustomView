package com.yakov.weber.galleryview.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.yakov.weber.galleryview.R

/**
 * Created on 05.12.18
 * @author YWeber
 * project GalleryView */

class SimpleCustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    companion object {
        const val CIRCLE = 0
        const val SQUARE = 1
    }

    private val dim:Float
    private val shape:Int

    private val paint:Paint
        init {
            val attrArray = getContext().obtainStyledAttributes(attrs, R.styleable.SimpleCustomView, 0, 0)
            dim = attrArray.getDimension(R.styleable.SimpleCustomView_dim,20F)
            shape = attrArray.getInt(R.styleable.SimpleCustomView_shape,0)
            attrArray.recycle()
            paint = Paint()
            paint.color = 0xfffed325.toInt()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        when(shape){
            CIRCLE ->{canvas.drawCircle(dim,dim,dim / 2,paint)}
            SQUARE ->{canvas.drawRect(0F,0F,dim,dim,paint)}
        }
    }



}