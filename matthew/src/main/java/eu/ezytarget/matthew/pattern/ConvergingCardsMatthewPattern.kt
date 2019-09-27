package eu.ezytarget.matthew.pattern

import android.graphics.Canvas
import eu.ezytarget.matthew.CanvasSizeQuantifier
import eu.ezytarget.matthew.Matthew
import eu.ezytarget.matthew.util.Calculator
import eu.ezytarget.matthew.util.RandomNumberGenerator

class ConvergingCardsMatthewPattern(
    private val canvasSizeQuantifier: CanvasSizeQuantifier = CanvasSizeQuantifier(),
    private val calculator: Calculator = Calculator(),
    private val randomNumberGenerator: RandomNumberGenerator = RandomNumberGenerator()
) {

    fun paintRandomly(matthew: Matthew, canvas: Canvas) {
        val imageSize = canvasSizeQuantifier.valueForCanvas(canvas)

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
}