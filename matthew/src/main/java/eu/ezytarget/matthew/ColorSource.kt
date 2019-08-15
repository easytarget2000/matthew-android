package eu.ezytarget.matthew

import android.content.res.Resources
import androidx.annotation.ArrayRes

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

    companion object {
        @ArrayRes
        private val paletteResourcesID = R.array.material_color_palettes
    }
}