package eu.ezytarget.matthew_examples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import eu.ezytarget.matthew.Matthew
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var matthew: Matthew = Matthew()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            generateExample()
        }
    }

    private fun generateExample() {
        val color = 0xFFFF00FF.toInt()
        matthew.fillCanvas(color)
    }
}
