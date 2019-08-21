package eu.ezytarget.matthew

import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Paint
import eu.ezytarget.matthew.painter.*
import kotlin.random.Random

class Matthew() {

    var colorSource: ColorSource = ColorSource()
    var paintWrapper: PaintWrapper = PaintWrapper()
    var canvasFiller: CanvasFiller = CanvasFiller(paintWrapper)
    var rectangularPainter: RectangularPainter = RectangularPainter(paintWrapper)
    var polygonalPainter: PolygonalPainter = PolygonalPainter(paintWrapper)
    var circularPainter: CircularPainter = CircularPainter(paintWrapper)
    var canvasSizeQuantifier: CanvasSizeQuantifier = CanvasSizeQuantifier()
    val paint: Paint get() = paintWrapper.paint

    constructor(resources: Resources) : this() {
        populateColorProvider(resources)
    }

    fun populateColorProvider(resources: Resources) {
        colorSource.populate(resources)
    }

    fun configurePaintWrapper(canvas: Canvas) {
        val quantifiedImageSize = canvasSizeQuantifier.valueForCanvas(canvas)
        configurePaintWrapper(quantifiedImageSize)
    }

    fun configurePaintWrapper(quantifiedImageSize: Float) {
        paintWrapper.strokeWidth = quantifiedImageSize * IMAGE_SIZE_TO_STROKE_WIDTH_RATIO
        paintWrapper.paint.strokeCap = Paint.Cap.BUTT
        paintWrapper.paint.isAntiAlias = USE_ANTI_ALIAS
        paintWrapper.shadowRadius = quantifiedImageSize * IMAGE_SIZE_TO_SHADOW_RADIUS_RATIO
        paintWrapper.enableShadows()
    }

    fun selectRandomPalettes(random: Random = Random(System.currentTimeMillis())) {
        val availablePalettes = colorSource.availablePalettes
        val palette1 = availablePalettes[random.nextInt() % availablePalettes.size]
        val palette2 = availablePalettes[random.nextInt() % availablePalettes.size]
        colorSource.selectAndCombinePalettes(palette1, palette2)
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
        rectangularPainter.paint(
            left,
            top,
            width,
            height,
            degrees,
            canvas
        )
    }

    fun paintCircularShapeFromEdgeWithDiameter(
        top: Float,
        left: Float,
        diameter: Float,
        color: Color,
        canvas: Canvas
    ) {
        paintWrapper.color = color
        circularPainter.paintFromEdgeWithDiameter(top, left, diameter, canvas)
    }

    fun paintCircularShapeFromEdgeWithRadius(
        top: Float,
        left: Float,
        radius: Float,
        color: Color,
        canvas: Canvas
    ) {
        paintWrapper.color = color
        circularPainter.paintFromEdgeWithRadius(top, left, radius, canvas)
    }

    fun paintCircularShapeWithDiameter(
        centerX: Float,
        centerY: Float,
        diameter: Float,
        color: Color,
        canvas: Canvas
    ) {
        paintWrapper.color = color
        circularPainter.paintWithDiameter(centerX, centerY, diameter, canvas)
    }

    fun paintCircularShapeWithRadius(
        centerX: Float,
        centerY: Float,
        radius: Float,
        color: Color,
        canvas: Canvas
    ) {
        paintWrapper.color = color
        circularPainter.paintWithRadius(centerX, centerY, radius, canvas)
    }

    companion object {
        const val USE_ANTI_ALIAS = true
        const val IMAGE_SIZE_TO_STROKE_WIDTH_RATIO = 1f / 25f
        const val IMAGE_SIZE_TO_SHADOW_RADIUS_RATIO = 1f / 100f
    }
}