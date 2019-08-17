package eu.ezytarget.matthew.painter

import android.graphics.Paint
import eu.ezytarget.matthew.Color
import android.graphics.BlurMaskFilter



class PaintWrapper(val paint: Paint = Paint()) {

    var color: Color
        get() = paint.color
        set(value) {
            paint.color = value
        }

    var strokeWidth: Float
        get() = paint.strokeWidth
        set(value) {
            paint.strokeWidth = value
        }

    var shadowRadius: Float = 0.0f
    var shadowColor: Color = DEFAULT_SHADOW_COLOR


    fun enableShadows(
        offsetFactorX: Float = 0f,
        offsetFactorY: Float = 0f
    ) {
        paint.setShadowLayer(
            shadowRadius,
            shadowRadius * offsetFactorX,
            shadowRadius * offsetFactorY,
            shadowColor
        )
    }

    fun disableShadows() {
        paint.clearShadowLayer()
    }

    fun enableBlur(radius: Float) {
        val blurMaskFilter = BlurMaskFilter(radius, BlurMaskFilter.Blur.NORMAL)
        paint.maskFilter = blurMaskFilter
    }

    fun disableBlur() {
        paint.maskFilter = null
    }

    companion object {
        const val DEFAULT_SHADOW_COLOR = 0xFF000000.toInt()
    }
}