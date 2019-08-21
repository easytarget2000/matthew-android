package eu.ezytarget.matthew.painter

import android.graphics.Canvas

class RectangularPainter(paintWrapper: PaintWrapper): Painter(paintWrapper) {

    fun paint(left: Float, top: Float, width: Float, height: Float, degrees: Float = 0f, canvas: Canvas) {
        canvas.save()
        val rectCenterX = left + (width / 2f)
        val rectCenterY = top + (height / 2f)
        canvas.rotate(degrees, rectCenterX, rectCenterY)

        setFillStyle()
        canvas.drawRect(left, top, left + width, top + height, paintWrapper.paint)

        canvas.restore()
    }
}