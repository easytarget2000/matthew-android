package eu.ezytarget.matthew

import android.content.res.Resources
import androidx.annotation.ArrayRes
import kotlin.math.abs

class ColorSource {

    lateinit var availablePalettes: Array<ColorPalette>
    lateinit var palette: ColorPalette

    internal fun populate(resources: Resources, resourcesReader: ResourcesReader = ResourcesReader()) {
        availablePalettes = resourcesReader.getArrayOfIntArrays(resources, paletteResourcesID)
        selectFirstAvailablePalette()
    }

    private fun selectFirstAvailablePalette() {
        selectAndCombinePalettes(availablePalettes.first())
    }

    fun selectAndCombinePalettes(vararg palettes: ColorPalette) {
        val colorList = ArrayList<Color>()
        for (palette in palettes) {
            colorList.addAll(palette)
        }
        palette = colorList.toTypedArray()
    }

    fun colorAtModuloIndex(moduloIndex: Int): Color {
        val wrappedIndex = abs(moduloIndex) % palette.size
        return palette[wrappedIndex]
    }

    companion object {
        @ArrayRes
        private val paletteResourcesID = R.array.material_color_palettes
    }
}