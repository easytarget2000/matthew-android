package eu.ezytarget.matthew.painter

import android.graphics.Canvas
import android.graphics.Path
import android.util.Log
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin


class PolygonalPainter(paintWrapper: PaintWrapper): Painter(paintWrapper) {

    fun paint(
        centerX: Float,
        centerY: Float,
        radius: Float,
        degrees: Float = 0f,
        numberOfEdges: Int,
        canvas: Canvas
    ) {
        if (numberOfEdges < MIN_NUM_OF_VERTICES) {
            Log.e(tag, "Minimum number of vertices: $MIN_NUM_OF_VERTICES, given: $numberOfEdges")
            return
        }

        val cappedNumberOfEdges = if (numberOfEdges > MAX_NUM_OF_VERTICES) {
            Log.w(tag, "Maximum number of vertices: $MAX_NUM_OF_VERTICES, given: $numberOfEdges")
            MAX_NUM_OF_VERTICES
        } else {
            numberOfEdges
        }


        canvas.save()
        canvas.rotate(degrees, centerX, centerY)

        val polygonPath = Path()

        for (edge in 1..cappedNumberOfEdges) {
            val angle = TWO_PI * edge / cappedNumberOfEdges
            val pointX = (centerX + radius * cos(angle))
            val pointY = (centerY + radius * sin(angle))

            if (edge == 1) {
                polygonPath.moveTo(pointX, pointY)
            } else {
                polygonPath.lineTo(pointX, pointY)
            }
        }

        polygonPath.close()
        paint(polygonPath, canvas)
        canvas.restore()
    }

    fun paint(path: Path, canvas: Canvas) {
        setFillStyle()
        canvas.drawPath(path, paintWrapper.paint)
    }

    companion object {
        const val MIN_NUM_OF_VERTICES = 3
        const val MAX_NUM_OF_VERTICES = 16
        private const val TWO_PI = 2f * PI.toFloat()
        val tag = PolygonalPainter::class.java.simpleName
    }
}