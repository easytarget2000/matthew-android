package eu.ezytarget.matthew

import android.content.res.Resources
import android.graphics.Bitmap
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

    fun configuredBitmapBackedCanvasWithColorSource(
        width: Int,
        height: Int,
        bitmapConfig: Bitmap.Config = Bitmap.Config.ARGB_8888,
        random: Random = Random(System.currentTimeMillis()),
        resources: Resources
    ): BitmapBackedCanvas {
        populateColorProvider(resources)
        return configuredBitmapBackedCanvas(width, height, bitmapConfig, random)
    }

    fun configuredBitmapBackedCanvas(
        width: Int,
        height: Int,
        bitmapConfig: Bitmap.Config = Bitmap.Config.ARGB_8888,
        random: Random = Random(System.currentTimeMillis())
    ): BitmapBackedCanvas {
        val bitmapBackedCanvas = bitmapBackedCanvas(width, height, bitmapConfig)
        configurePaintWrapper(bitmapBackedCanvas.canvas)
        selectRandomPalettes(random)
        return bitmapBackedCanvas
    }

    fun bitmapBackedCanvas(
        width: Int,
        height: Int,
        bitmapConfig: Bitmap.Config = Bitmap.Config.ARGB_8888
    ): BitmapBackedCanvas {
        val bitmap = Bitmap.createBitmap(width, height, bitmapConfig)
        return bitmapBackedCanvas(bitmap)
    }

    fun bitmapBackedCanvas(bitmap: Bitmap): BitmapBackedCanvas {
        val canvas = Canvas(bitmap)
        return BitmapBackedCanvas(canvas, bitmap)
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
        val maxPaletteIndex = availablePalettes.size - 1
        val palette1 = availablePalettes[random.nextInt(until = maxPaletteIndex)]
        val palette2 = availablePalettes[random.nextInt(until = maxPaletteIndex)]
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