package com.example.trygit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.tabs.TabLayout
private  const val TAG="MainActivity"
val evenNumber = booleanArrayOf(true,true,true,true,true,true)

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton:Button
    private lateinit var fasleButton:Button
    private lateinit var  nextButton:ImageButton
    private lateinit var  prevButton:ImageButton
    private  lateinit var  questionTextView: TextView

    private val questionBank= listOf(
        Questions(R.string.text1,true),
        Questions(R.string.questions_oceans,true),
        Questions(R.string.question_mideast,false),
        Questions(R.string.question_africa,false),
        Questions(R.string.question_americas,true),
        Questions(R.string.question_asia,true)
    )
    private  var currentIndex=0
    private  var chet: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate(Bundle?) called")
        setContentView(R.layout.activity_main)
        trueButton = findViewById(R.id.tru)
        fasleButton = findViewById(R.id.fals)
        nextButton=findViewById(R.id.next_button)
        prevButton=findViewById(R.id.prev_button)

        questionTextView=findViewById((R.id.question_text_view))
        trueButton.setOnClickListener{ view: View ->
        Toast.makeText(
            this,
            R.string.correct_toast,
            Toast.LENGTH_SHORT).show()
            trueButton.isEnabled=false
            fasleButton.isEnabled=false

        }

        /*trueButton.setOnClickListener {
            questionTextView.text="правильных ответов - ${++chet}"
        }*/



        fasleButton.setOnClickListener { view: View ->
        Toast.makeText(

            this,
            R.string.incorrect_toast,
            Toast.LENGTH_SHORT).show()
            trueButton.isEnabled=false
            fasleButton.isEnabled=false
        }

        val questionTextResId=questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
        nextButton.setOnClickListener {
            currentIndex=(currentIndex + 1)% questionBank.size
            trueButton.isEnabled=true
            fasleButton.isEnabled=true
            updateQuestion()
        }
        prevButton.setOnClickListener {
            currentIndex = if (currentIndex>0){
                (currentIndex - 1)
            } else {
                questionBank.size-1
            }
            trueButton.isEnabled=false
            fasleButton.isEnabled=false
            updateQuestion()
        }

    }
    override fun onStart(){
        super.onStart()
        Log.d(TAG,"onStart() called")
    }
    override fun onResume(){
        super.onResume()
        Log.d(TAG,"onResume() called")
    }
    override fun onStop(){
        super.onStop()
        Log.d(TAG,"onStop() called")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.d(TAG,"onDestroy() called")
    }
    private fun updateQuestion(){
        val questionTextResId=questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }
}