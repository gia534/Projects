package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEditText : EditText = findViewById(R.id.nameEditText)
        val startButton : Button = findViewById(R.id.startButton)
        startButton.setOnClickListener {
            if (nameEditText.text.isNotEmpty()){
                val intent = Intent(this, QuizQuestionsActivity ::class.java)
                intent.putExtra(Constants.USER_NAME, nameEditText.text.toString())
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this,
                    "Name is required to move on",
                    Toast.LENGTH_LONG).show()
            }
        }

    }
}