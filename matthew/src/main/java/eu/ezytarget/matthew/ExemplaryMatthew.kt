package eu.ezytarget.matthew

import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Paint
import eu.ezytarget.matthew.pattern.ConvergingCardsMatthewPattern
import eu.ezytarget.matthew.pattern.TwirlyDisksMatthewPattern
import kotlin.math.min

class ExemplaryMatthew(
    resources: Resources,
    private val canvasSizeQuantifier: CanvasSizeQuantifier = CanvasSizeQuantifier()
) {

    private val matthew: Matthew = Matthew(resources)
    var convergingCardsMatthewPattern: ConvergingCardsMatthewPattern
            = ConvergingCardsMatthewPattern()
    var twirlyDisksMatthewPattern: TwirlyDisksMatthewPattern = TwirlyDisksMatthewPattern()
    val paint: Paint get() = matthew.paint

    fun setupAndDrawBackground(canvas: Canvas) {
        matthew.configurePaintWrapper(canvas)
        matthew.selectRandomPalettes()
        val backgroundColor = matthew.colorAtModuloIndex(0)
        matthew.fillCanvas(canvas, backgroundColor)
    }

    fun paintConvergingCardsPattern(canvas: Canvas) {
        convergingCardsMatthewPattern.paintRandomly(matthew, canvas)
    }

    fun paintTwirlyDisksPattern(canvas: Canvas) {
        twirlyDisksMatthewPattern.configureRandomly()
        twirlyDisksMatthewPattern.paint(matthew, canvas)
    }

    fun paintSimpleDiskPattern(canvas: Canvas) {
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