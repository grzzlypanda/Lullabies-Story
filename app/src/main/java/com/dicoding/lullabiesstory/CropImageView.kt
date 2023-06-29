package com.dicoding.lullabiesstory

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.imageview.ShapeableImageView

class CropImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ShapeableImageView(context, attrs, defStyleAttr) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val width = measuredWidth
        val height = measuredHeight

        if (width > 0 && height > 0) {
            val aspectRatio = 400f / 300f // Desired aspect ratio

            if (width / aspectRatio > height) {
                val newHeight = (width / aspectRatio).toInt()
                setMeasuredDimension(width, newHeight)
            } else {
                val newWidth = (height * aspectRatio).toInt()
                setMeasuredDimension(newWidth, height)
            }
        }
    }
}
