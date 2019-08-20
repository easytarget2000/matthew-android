package eu.ezytarget.matthew

import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Paint
import eu.ezytarget.matthew.painter.*
import kotlin.math.min

class Matthew() {

    var colorSource: ColorSource = ColorSource()
    var paintWrapper: PaintWrapper = PaintWrapper()
    var canvasFiller: CanvasFiller = CanvasFiller(paintWrapper)
    var rectanglePainter: RectanglePainter = RectanglePainter(paintWrapper)
    var polygonPainter: PolygonPainter = PolygonPainter(paintWrapper)
    var circlePainter: CirclePainter = CirclePainter(paintWrapper)
    val paint: Paint get() = paintWrapper.paint

    constructor(resources: Resources) : this() {
        populateColorProvider(resources)
    }

    fun populateColorProvider(resources: Resources) {
        colorSource.populate(resources)
    }

    fun configurePaintWrapper(imageSize: Float) {
        paintWrapper.strokeWidth = imageSize * IMAGE_SIZE_TO_STROKE_WIDTH_RATIO
        paintWrapper.paint.strokeCap = Paint.Cap.BUTT
        paintWrapper.paint.isAntiAlias = USE_ANTI_ALIAS
        paintWrapper.shadowRadius = imageSize * IMAGE_SIZE_TO_SHADOW_RADIUS_RATIO
        paintWrapper.enableShadows()
    }

    fun colorAtModuloIndex(moduloIndex: Int): Color {
        return colorSource.colorAtModuloIndex(moduloIndex)
    }

    fun fillCanvas(canvas: Canvas, color: Color) {
        paintWrapper.color = color
        canvasFiller.fillCanvas(canvas)
    }

    fun paintRectangle(
        left: Float,
        top: Float,
        width: Float,
        height: Float,
        degrees: Float = 0f,
        color: Color,
        canvas: Canvas
    ) {
        paintWrapper.color = color
        rectanglePainter.paint(
            left,
            top,
            width,
            height,
            degrees,
            canvas
        )
    }

    companion object {
        const val USE_ANTI_ALIAS = true
        const val IMAGE_SIZE_TO_STROKE_WIDTH_RATIO = 1f / 25f
        const val IMAGE_SIZE_TO_SHADOW_RADIUS_RATIO = 1f / 100f
    }
}