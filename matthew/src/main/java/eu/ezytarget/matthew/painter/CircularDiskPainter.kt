package eu.ezytarget.matthew.painter

import android.graphics.Canvas

class CircularDiskPainter(paintWrapper: PaintWrapper): Painter(paintWrapper) {

    fun paintDiskFromEdgeWithDiameter(top: Float, left: Float, diameter: Float, canvas: Canvas) {
        val radius = diameter / 2f
        paintDiskFromEdgeWithRadius(top, left, radius, canvas)
    }

    fun paintDiskFromEdgeWithRadius(top: Float, left: Float, radius: Float, canvas: Canvas) {
        val centerX = left + radius
        val centerY = top + radius
        paintDiskWithRadius(centerX, centerY, radius, canvas)
    }

    fun paintDiskWithDiameter(centerX: Float, centerY: Float, diameter: Float, canvas: Canvas) {
        val radius = diameter / 2f
        paintDiskWithRadius(centerX, centerY, radius, canvas)
    }

    fun paintDiskWithRadius(centerX: Float, centerY: Float, radius: Float, canvas: Canvas) {
        setFillStyle()
        canvas.drawCircle(centerX, centerY, radius, paint)
    }
}