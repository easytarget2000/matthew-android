package eu.ezytarget.matthew

import android.content.res.Resources
import android.graphics.Canvas

class Matthew(private val canvas: Canvas = Canvas()) {

    var colorProvider: ColorProvider = ColorProvider()
    internal var canvasFiller: CanvasFiller = CanvasFiller()

    internal constructor(
        canvas: Canvas,
        canvasFiller: CanvasFiller
    ) : this(canvas) {
        this.canvasFiller = canvasFiller
    }

    fun populateColorProvider(resources: Resources) {
        colorProvider.populate(resources)
    }

    fun fillCanvas(color: Color) {
        canvasFiller.fillCanvas(canvas, color)
    }
}