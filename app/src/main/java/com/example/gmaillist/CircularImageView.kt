package com.example.gmaillist

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.util.AttributeSet
import android.widget.ImageView

class CircularImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : androidx.appcompat.widget.AppCompatImageView(context, attrs, defStyle) {

    private val path = Path()

    override fun onDraw(canvas: Canvas) {
        // Create a circular path
        path.reset()
        path.addCircle(width / 2f, height / 2f, width / 2f, Path.Direction.CCW)
        canvas.clipPath(path)
        super.onDraw(canvas)
    }
}