package eu.ezytarget.matthew

import android.content.res.Resources
import android.graphics.Canvas

class Matthew() {

    var colorSource: ColorSource = ColorSource()
    internal var canvasFiller: CanvasFiller = CanvasFiller()

    constructor(resources: Resources): this() {
        populateColorProvider(resources)
    }

    fun drawSeeded(canvas: Canvas, seed: Int = 0) {
        selectPalettes()
        val backgroundColor = colorSource.palette.first()
        fillCanvas(canvas, backgroundColor)
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

    fun fillCanvas(canvas:Canvas, color: Color) {
        canvasFiller.fillCanvas(canvas, color)
    }
}