package eu.ezytarget.matthew.painter

import android.graphics.Canvas

class RectanglePainter: Painter() {

    fun paint(left: Float, top: Float, width: Float, height: Float, degrees: Float = 0f, canvas: Canvas) {

        canvas.rotate(degrees)
    }
}