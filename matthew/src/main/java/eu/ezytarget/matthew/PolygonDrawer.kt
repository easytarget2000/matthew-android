package eu.ezytarget.matthew

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.Log

class PolygonDrawer(private val paint: Paint = Paint()) {

    var color: Color
        get() {
            return paint.color
        }
        set(color) {
            paint.color = color
        }

    fun draw(x: Float, y: Float, numOfVertices: Int, canvas: Canvas) {
        if (numOfVertices < MIN_NUM_OF_VERTICES) {
            Log.e(tag, "Minimum number of vertices: $MIN_NUM_OF_VERTICES, given: $numOfVertices")
            return
        }

        val cappedNumOfVertices = if (numOfVertices > MAX_NUM_OF_VERTICES) {
            Log.w(tag, "Maximum number of vertices: $MAX_NUM_OF_VERTICES, given: $numOfVertices")
            MAX_NUM_OF_VERTICES
        } else {
            numOfVertices
        }

        
    }

    fun draw(path: Path, canvas: Canvas) {
        canvas.drawPath(path, paint)
    }

    companion object {
        const val MIN_NUM_OF_VERTICES = 3
        const val MAX_NUM_OF_VERTICES = 16
        val tag = PolygonDrawer::class.java.simpleName
    }
}