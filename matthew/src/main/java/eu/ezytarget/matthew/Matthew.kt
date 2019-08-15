package eu.ezytarget.matthew

import android.content.res.Resources
import android.graphics.Canvas

class Matthew(private val canvas: Canvas = Canvas()) {

    var colorSource: ColorSource = ColorSource()
    internal var canvasFiller: CanvasFiller = CanvasFiller()

    internal constructor(
        canvas: Canvas,
        canvasFiller: CanvasFiller
    ) : this(canvas) {
        this.canvasFiller = canvasFiller
    }

    fun drawSeeded(resources: Resources, width: Int, height: Int, seed:Int) {
        populateColorProvider(resources)
        selectPalettes()
        val backgroundColor = colorSource.palette.first()
        fillCanvas(backgroundColor)
    }

    fun populateColorProvider(resources: Resources) {
        colorSource.populate(resources)
    }

    fun selectPalettes() {
        val availablePalettes = colorSource.availablePalettes
        val firstPalette = availablePalettes.first()
        val lastPalette = availablePalettes.last()
        colorSource.selectAndCombinePalettes(firstPalette, lastPalette)
    }

    fun fillCanvas(color: Color) {
        canvasFiller.fillCanvas(canvas, color)
    }
}