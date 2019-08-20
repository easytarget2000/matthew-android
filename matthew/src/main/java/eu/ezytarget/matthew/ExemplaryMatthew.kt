package eu.ezytarget.matthew

import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Paint
import kotlin.math.min

class ExemplaryMatthew(resources: Resources) {

    private val matthew: Matthew = Matthew(resources)

    val paint: Paint get() = matthew.paint

    fun drawSamplePatternTopStripes(canvas: Canvas) {
        val imageSize = min(canvas.width, canvas.height).toFloat()
        setupMatthew(imageSize)

        val backgroundColor = matthew.colorAtModuloIndex(0)
        matthew.fillCanvas(canvas, backgroundColor)

        val rectangleWidth = imageSize * 2f
        val rectangleHeight = imageSize / 7f
        val rectangleTopOffset = -rectangleHeight * 1.5f
        val rectangleTopIncrement = rectangleHeight * 0.8f
        val rectangleLeft = -rectangleWidth / 4f
        val baseRectangleDegrees = 20f
        val rectangleDegreesIncrement = 2f
        val color = matthew.colorAtModuloIndex(4)

        for (rectangleCounter in 5 downTo 0) {
            val rectangleTop = rectangleTopOffset + (rectangleCounter * rectangleTopIncrement)
            val rectangleDegrees = baseRectangleDegrees + (rectangleCounter * rectangleDegreesIncrement)
            matthew.paintRectangle(
                rectangleLeft,
                rectangleTop,
                rectangleWidth,
                rectangleHeight,
                rectangleDegrees,
                color,
                canvas
            )
        }
    }

    private fun setupMatthew(imageSize: Float) {
        selectPalettes()
        matthew.configurePaintWrapper(imageSize)
    }

    private fun selectPalettes() {
        val availablePalettes = matthew.colorSource.availablePalettes
        val firstPalette = availablePalettes.first()
        val lastPalette = availablePalettes.last()
        matthew.colorSource.selectAndCombinePalettes(firstPalette, lastPalette)
    }
}