package eu.ezytarget.matthew.painter

import android.graphics.Paint
import eu.ezytarget.matthew.Color

abstract class Painter(protected val paint: Paint = Paint()) {

    var color: Color
        get() {
            return paint.color
        }
        set(color) {
            paint.color = color
        }
}