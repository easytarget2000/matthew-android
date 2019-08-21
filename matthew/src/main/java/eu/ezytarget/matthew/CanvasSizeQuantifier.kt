package eu.ezytarget.matthew

import android.graphics.Canvas
import kotlin.math.min

class CanvasSizeQuantifier {

    fun valueForCanvas(canvas: Canvas): Float {
        return min(canvas.width, canvas.height).toFloat()
    }

}