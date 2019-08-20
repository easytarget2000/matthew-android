package eu.ezytarget.matthew.painter

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import eu.ezytarget.matthew.Color

class CanvasFiller(paintWrapper: PaintWrapper): Painter(paintWrapper) {

    fun fillCanvas(canvas: Canvas) {
        setFillStyle()
        val canvasRect = Rect(0, 0, canvas.width, canvas.height)
        canvas.drawRect(canvasRect, paint)
    }
}