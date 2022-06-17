package com.example.trygit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var trueButton:Button
    private lateinit var fasleButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        trueButton = findViewById(R.id.tru)
        fasleButton = findViewById(R.id.fals)
        trueButton.setOnClickListener{ view: View ->
        Toast.makeText(
            this,
            R.string.correct_toast,
            Toast.LENGTH_SHORT).show()


        }
        fasleButton.setOnClickListener { view: View ->
        Toast.makeText(

            this,
            R.string.incorrect_toast,
            Toast.LENGTH_SHORT).show()



        }
    }
}