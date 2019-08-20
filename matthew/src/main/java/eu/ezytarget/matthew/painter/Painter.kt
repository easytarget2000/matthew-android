package eu.ezytarget.matthew.painter

import android.graphics.Paint

abstract class Painter(protected var paintWrapper: PaintWrapper) {

    val paint: Paint
        get() = paintWrapper.paint

    fun setFillStyle() {
        paint.style = Paint.Style.FILL
    }
}