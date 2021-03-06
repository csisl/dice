package com.example.dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import android.widget.TextView


/**
 * Instead of calling a main() function, the Android system calls the
 * onCreate() method of your MainActivity when your app is opened for
 * the first time.
 *
 * Style guide: https://developer.android.com/kotlin/style-guide?authuser=2
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // android automatically assigns ID numbers to resources of the app
        val rollButton: ImageButton = findViewById(R.id.diceButton)

        /**
         * Associate code with the Button, so that the
         * code can be executed when the Button is tapped. A click listener
         * is some code for what to do when a tap or click happens. You can
         * think of it as code that is just sitting, "listening" for the user
         * to click, in this case, on the Button.
         */
        rollButton.setOnClickListener {
            /** Below is code that made text appear in a pop-up, post textView
             * val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
             * toast.show()
             * But a cleaner way to do this:
             * Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
             */
            diceRoll()

        }
    }

    private fun diceRoll() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultView: TextView = findViewById(R.id.rollResult)
        // assign the text to the result view
        resultView.text = diceRoll.toString()
    }
}

class Dice constructor(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random() // can call random method from IntRange
    }

}