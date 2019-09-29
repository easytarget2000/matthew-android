package eu.ezytarget.matthew_examples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import eu.ezytarget.matthew.Matthew
import eu.ezytarget.matthew.ui.ExemplaryMatthView
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
        val matthView: ExemplaryMatthView= findViewById(R.id.main_exemplary_matth_view)
        matthView.invalidate()
    }
}
