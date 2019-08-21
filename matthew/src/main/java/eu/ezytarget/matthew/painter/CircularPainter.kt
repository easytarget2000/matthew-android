package eu.ezytarget.matthew.painter

import android.graphics.Canvas

class CircularPainter(paintWrapper: PaintWrapper): Painter(paintWrapper) {

    fun paintFromEdgeWithDiameter(top: Float, left: Float, diameter: Float, canvas: Canvas) {
        val radius = diameter / 2f
        paintFromEdgeWithRadius(top, left, radius, canvas)
    }

    fun paintFromEdgeWithRadius(top: Float, left: Float, radius: Float, canvas: Canvas) {
        val centerX = left + radius
        val centerY = top + radius
        paintWithRadius(centerX, centerY, radius, canvas)
    }

    fun paintWithDiameter(centerX: Float, centerY: Float, diameter: Float, canvas: Canvas) {
        val radius = diameter / 2f
        paintWithRadius(centerX, centerY, radius, canvas)
    }

    fun paintWithRadius(centerX: Float, centerY: Float, radius: Float, canvas: Canvas) {
        setFillStyle()
        canvas.drawCircle(centerX, centerY, radius, paint)
    }
}