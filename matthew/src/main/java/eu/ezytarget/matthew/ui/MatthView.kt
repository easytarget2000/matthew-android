package eu.ezytarget.matthew.ui

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.View
import eu.ezytarget.matthew.BuildConfig
import eu.ezytarget.matthew.Matthew

class MatthView: View {

    var matthew: Matthew
    var verbose = BuildConfig.DEBUG

    @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
    ) : super(context, attrs, defStyleAttr) {
        matthew = Matthew(context.resources)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (verbose) {
            Log.d(MatthView.tag, "onDraw(): canvas: $canvas")
        }

        if (canvas == null) {
            return
        }

        matthew.drawSeeded(canvas)
    }

    companion object {
        val tag: String = Matthew::class.java.simpleName
    }
}