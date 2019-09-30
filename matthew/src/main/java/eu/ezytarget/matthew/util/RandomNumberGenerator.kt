package eu.ezytarget.matthew.util

import kotlin.random.Random

class RandomNumberGenerator(
    seed: Int = System.currentTimeMillis().toInt(),
    val source: Random = Random(seed)
) {
    fun boolean(): Boolean {
        return source.nextBoolean()
    }

    fun boolean(trueProbability: Float): Boolean {
        when {
            trueProbability >= 1f -> return true
            trueProbability <= 0f -> return false
            else -> return float(0f, 1f) <= trueProbability
        }
    }

    fun int(from: Int = Int.MIN_VALUE, until: Int = Int.MAX_VALUE): Int {
        return source.nextInt(from, until)
    }

    fun positiveInt(): Int {
        return int(from = 1, until = Int.MAX_VALUE)
    }

    fun float(from: Float, until: Float): Float {
        return source.nextDouble(from.toDouble(), until.toDouble()).toFloat()
    }
}