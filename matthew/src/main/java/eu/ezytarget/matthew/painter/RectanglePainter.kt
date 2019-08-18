package eu.ezytarget.matthew.painter

import android.graphics.Canvas

class RectanglePainter(private var paintWrapper: PaintWrapper) {

    fun paint(left: Float, top: Float, width: Float, height: Float, degrees: Float = 0f, canvas: Canvas) {
        canvas.save()
        canvas.rotate(degrees)

        canvas.drawRect(left, top, left + width, top + height, paintWrapper.paint)

        canvas.restore()
    }
}