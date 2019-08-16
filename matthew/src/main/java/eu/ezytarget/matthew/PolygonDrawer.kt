package eu.ezytarget.matthew

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path

internal class PolygonDrawer(private val paint: Paint = Paint()) {

    fun draw(path: Path, canvas: Canvas) {
        canvas.drawPath(path, paint)
    }
}