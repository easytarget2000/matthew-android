package eu.ezytarget.matthew.ui

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import eu.ezytarget.matthew.Matthew

class MatthView: View {

    private val matthew: Matthew

    @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
    ) : super(context, attrs, defStyleAttr) {
        matthew = Matthew(context.resources)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas == null) {
            return
        }

        matthew.drawSeeded(canvas)
    }
}