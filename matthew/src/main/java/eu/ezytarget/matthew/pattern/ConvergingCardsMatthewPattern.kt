package eu.ezytarget.matthew.pattern

import android.graphics.Canvas
import eu.ezytarget.matthew.Matthew
import eu.ezytarget.matthew.util.RandomNumberGenerator

class ConvergingCardsMatthewPattern(
    private val randomNumberGenerator: RandomNumberGenerator = RandomNumberGenerator()
) {
    var numberOfCards = 10
    var initialDegrees = -40f
    var deltaDegrees = -1f

    fun configureRandomly() {
        numberOfCards = randomNumberGenerator.int(8, 12)
//        initialDegrees = randomNumberGenerator.float(-30f, -60f)
        deltaDegrees = 5f//randomNumberGenerator.float(-1f, 1f)
    }

    fun paintRandomly(matthew: Matthew, canvas: Canvas) {
        val minCardWidth = canvas.width / numberOfCards.toFloat()
        val maxCardWidth = canvas.width / 4f

        val cardHeight = canvas.height * 2f
        val rectangleTop = 0f - (cardHeight / 4f)
        var rectangleLeft = canvas.width.toFloat()
        var color = matthew.colorAtModuloIndex(0)

        for(cardCounter in numberOfCards downTo 0) {
            val cardWidth = randomNumberGenerator.float(minCardWidth, maxCardWidth)
            rectangleLeft -= cardWidth
            val rectangleDegrees = initialDegrees + (cardCounter * deltaDegrees)
            val changeColor = randomNumberGenerator.boolean(trueProbability = 0.7f)
            if (changeColor) {
                color = matthew.colorAtModuloIndex(cardCounter)
            }

            matthew.paintRectangle(
                rectangleLeft,
                rectangleTop,
                cardWidth,
                cardHeight,
                rectangleDegrees,
                color,
                canvas
            )
        }

    }

}