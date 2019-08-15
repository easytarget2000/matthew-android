package eu.ezytarget.matthew

import android.content.res.Resources
import androidx.annotation.ArrayRes

internal class ColorProvider(resources: Resources, resourcesReader: ResourcesReader = ResourcesReader()) {

    val availablePalettes: Array<ColorPalette>
    var selectedPalettes: Array<ColorPalette>? = null

    init {
        availablePalettes = resourcesReader.getArrayOfIntArrays(resources, paletteResourcesID)
    }

    companion object {
        @ArrayRes
        private val paletteResourcesID = R.array.material_color_palettes
    }
}