package eu.ezytarget.matthew

import android.content.res.Resources
import android.graphics.Canvas
import eu.ezytarget.matthew.painter.PolygonPainter
import kotlin.math.PI
import kotlin.math.min

class Matthew() {

    var colorSource: ColorSource = ColorSource()
    var canvasFiller: CanvasFiller = CanvasFiller()
    var polygonPainter: PolygonPainter = PolygonPainter()

    constructor(resources: Resources): this() {
        populateColorProvider(resources)
    }

    fun drawSeeded(canvas: Canvas, seed: Int = 0) {
        selectPalettes()
        val backgroundColor = colorSource.palette.first()
        fillCanvas(canvas, backgroundColor)

        polygonPainter.color = colorSource.palette.last()
        val polygonX = canvas.width / 2f
        val polygonY = canvas.height / 2f
        val polygonRadius = min(canvas.width, canvas.height) * 0.33f
        val polygonAngle = PI.toFloat() / 4f
        val numberOfPolygonEdges = 4
        polygonPainter.paint(
            polygonX,
            polygonY,
            polygonRadius,
            polygonAngle,
            numberOfPolygonEdges,
            canvas
        )
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