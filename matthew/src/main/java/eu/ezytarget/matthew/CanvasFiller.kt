package eu.ezytarget.matthew

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect

internal class CanvasFiller(private val paint: Paint = Paint()) {

    fun fillCanvas(canvas: Canvas, color: Color) {
        paint.color = color
        paint.style = Paint.Style.FILL
        val canvasRect = Rect(0, 0, canvas.width, canvas.height)
        canvas.drawRect(canvasRect, paint)
    }
}