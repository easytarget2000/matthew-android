package eu.ezytarget.matthew.ui

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.View
import eu.ezytarget.matthew.BuildConfig
import eu.ezytarget.matthew.ExemplaryMatthew
import eu.ezytarget.matthew.Matthew

class MatthView: View {

    var exemplaryMatthew: ExemplaryMatthew
    var verbose = BuildConfig.DEBUG

    @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
    ) : super(context, attrs, defStyleAttr) {
        exemplaryMatthew = ExemplaryMatthew(context.resources)
        disableHardwareAcceleration()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (verbose) {
            Log.d(MatthView.tag, "onDraw(): canvas: $canvas")
        }

        if (canvas == null) {
            return
        }

        exemplaryMatthew.paintSampleDiskPattern(canvas)
        exemplaryMatthew.paintSamplePatternTopStripes(canvas)
    }

    fun disableHardwareAcceleration() {
        setLayerType(LAYER_TYPE_SOFTWARE, exemplaryMatthew.paint)
    }

    companion object {
        val tag: String = Matthew::class.java.simpleName
    }
}