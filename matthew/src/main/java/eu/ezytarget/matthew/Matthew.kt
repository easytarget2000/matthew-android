package eu.ezytarget.matthew

import android.graphics.Canvas

class Matthew(private val canvas: Canvas = Canvas()) {

    internal var canvasFiller: CanvasFiller = CanvasFiller()

    internal constructor(
        canvas: Canvas,
        canvasFiller: CanvasFiller
    ) : this(canvas) {
        this.canvasFiller = canvasFiller
    }

    fun fillCanvas(color: Color) {
        canvasFiller.fillCanvas(canvas, color)
    }
}