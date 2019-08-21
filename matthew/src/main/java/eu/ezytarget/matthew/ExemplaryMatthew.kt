package eu.ezytarget.matthew

import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Paint
import kotlin.math.min

class ExemplaryMatthew(
    resources: Resources,
    private val canvasSizeQuantifier: CanvasSizeQuantifier = CanvasSizeQuantifier()
) {

    private val matthew: Matthew = Matthew(resources)
    val paint: Paint get() = matthew.paint

    fun setupAndDrawBackground(canvas: Canvas) {
        matthew.configurePaintWrapper(canvas)
        matthew.selectRandomPalettes()
        val backgroundColor = matthew.colorAtModuloIndex(0)
        matthew.fillCanvas(canvas, backgroundColor)
    }

    fun paintSamplePatternTopStripes(canvas: Canvas) {
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

    fun paintSampleDiskPattern(canvas: Canvas) {
        val imageSize = canvasSizeQuantifier.valueForCanvas(canvas)

        val firstStackMinRadius = imageSize / 7f
        val firstStackCenterX = imageSize / 3f
        val firstStackCenterY = imageSize * 0.67f

        val color = matthew.colorAtModuloIndex(3)
        for (diskCounter in 5 downTo 0) {
            val radius = firstStackMinRadius * diskCounter.toFloat()
            matthew.paintCircularShapeWithRadius(
                firstStackCenterX,
                firstStackCenterY,
                radius,
                color,
                canvas
            )
        }
    }

}