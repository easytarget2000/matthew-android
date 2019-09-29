package eu.ezytarget.matthew.pattern

import android.graphics.Canvas
import eu.ezytarget.matthew.Matthew
import eu.ezytarget.matthew.util.RandomNumberGenerator
import kotlin.math.max

class ConvergingCardsMatthewPattern(
    private val randomNumberGenerator: RandomNumberGenerator = RandomNumberGenerator()
) {
    var numberOfCards = 4
    var initialDegrees = -40f
    var deltaDegrees = 0f
    var changeColorProbability = 1f

    fun configureRandomly() {
        numberOfCards = randomNumberGenerator.int(4, 10)
        initialDegrees = -randomNumberGenerator.float(-35f, 35f)
        deltaDegrees = randomNumberGenerator.float(-3f, 3f)
        changeColorProbability = randomNumberGenerator.float(0f, 1f)
    }

    fun paintRandomly(matthew: Matthew, canvas: Canvas) {
        val minCardWidth = canvas.width / numberOfCards.toFloat()
        val maxCardWidth = minCardWidth * 3f

        val cardHeight = canvas.height * 2f
        val rectangleTop = 0f - cardHeight * 0.25f
        var rectangleLeft = canvas.width.toFloat()
        var color = matthew.colorAtModuloIndex(0)

        for (cardCounter in numberOfCards downTo 0) {
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