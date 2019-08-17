package eu.ezytarget.matthew

import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Paint
import eu.ezytarget.matthew.painter.PaintWrapper
import eu.ezytarget.matthew.painter.PolygonPainter
import kotlin.math.PI
import kotlin.math.min

class Matthew() {

    var colorSource: ColorSource = ColorSource()
    var paintWrapper: PaintWrapper = PaintWrapper()
    var canvasFiller: CanvasFiller = CanvasFiller()
    var polygonPainter: PolygonPainter = PolygonPainter(paintWrapper)

    constructor(resources: Resources): this() {
        populateColorProvider(resources)
    }

    fun drawExample(canvas: Canvas) {
        selectPalettes()
        val backgroundColor = colorSource.palette.first()
        fillCanvas(canvas, backgroundColor)

        paintWrapper.color = colorSource.palette.last()

        val polygonX = canvas.width / 2f
        val polygonY = canvas.height / 2f
        val polygonRadius = min(canvas.width, canvas.height) * 0.33f
        val polygonDegrees = 45f
        val numberOfPolygonEdges = 4
        polygonPainter.paint(
            polygonX,
            polygonY,
            polygonRadius,
            polygonDegrees,
            numberOfPolygonEdges,
            canvas
        )
    }

    fun populateColorProvider(resources: Resources) {
        colorSource.populate(resources)
    }

    fun selectPalettes() {
        val availablePalettes = colorSource.availablePalettes
        val firstPalette = availablePalettes.first()
        val lastPalette = availablePalettes.last()
        colorSource.selectAndCombinePalettes(firstPalette, lastPalette)
    }

    fun configurePaintWrapper(imageSize: Float) {
        paintWrapper.strokeWidth = imageSize * IMAGE_SIZE_TO_STROKE_WIDTH_RATIO
        paintWrapper.paint.strokeCap = Paint.Cap.BUTT
        paintWrapper.paint.isAntiAlias = USE_ANTI_ALIAS
        paintWrapper.enableShadows()

    }

    fun fillCanvas(canvas:Canvas, color: Color) {
        canvasFiller.fillCanvas(canvas, color)
    }

    companion object {
        const val USE_ANTI_ALIAS = true
        const val IMAGE_SIZE_TO_STROKE_WIDTH_RATIO = 1f / 25f
        const val IMAGE_SIZE_TO_SHADOW_RADIUS_RATIO = 1f / 200f
    }
}