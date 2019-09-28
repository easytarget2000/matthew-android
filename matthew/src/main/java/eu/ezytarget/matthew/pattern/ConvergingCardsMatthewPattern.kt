package eu.ezytarget.matthew.pattern

import android.graphics.Canvas
import eu.ezytarget.matthew.Matthew
import eu.ezytarget.matthew.util.RandomNumberGenerator
import kotlin.math.max

class ConvergingCardsMatthewPattern(
    private val randomNumberGenerator: RandomNumberGenerator = RandomNumberGenerator()
) {
    var numberOfCards = 10
    var initialDegrees = -45f
    var deltaDegrees = -2f
    var changeColorProbability = 0.4f

    fun configureRandomly() {
        numberOfCards = randomNumberGenerator.int(4, 10)
        initialDegrees = -randomNumberGenerator.float(30f, 50f)
        deltaDegrees = randomNumberGenerator.float(-3f, 3f)
        changeColorProbability = randomNumberGenerator.float(0.1f, 0.5f)
    }
ø
    fun paintRandomly(matthew: Matthew, canvas: Canvas) {
        val longestCanvasSideLength = max(canvas.width, canvas.height)
        val minCardWidth = longestCanvasSideLength / numberOfCards.toFloat()
        val maxCardWidth = minCardWidth * 3f

        val cardHeight = longestCanvasSideLength * 3f
        val rectangleTop = 0f - (cardHeight / 2f)
        var rectangleLeft = canvas.width.toFloat() * 2f
        var color = matthew.colorAtModuloIndex(0)

        for(cardCounter in numberOfCards downTo 0) {
            val cardWidth = randomNumberGenerator.float(minCardWidth, maxCardWidth)
            rectangleLeft -= cardWidth
            val rectangleDegrees = initialDegrees + (cardCounter * deltaDegrees)

            matthew.paintRectangle(
                rectangleLeft,
                rectangleTop,
                cardWidth,
                cardHeight,
                rectangleDegrees,
                color,
                canvas
            )

            val changeColor = randomNumberGenerator.boolean(changeColorProbability)
            if (changeColor) {
                color = matthew.colorAtModuloIndex(cardCounter)
            }
        }

    }

}