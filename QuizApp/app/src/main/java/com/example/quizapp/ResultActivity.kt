package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val name: TextView = findViewById(R.id.nameTextView)
        val score: TextView = findViewById(R.id.scoreTextView)
        val finishButton: Button = findViewById(R.id.finishButton)

        name.text = intent.getStringExtra(Constants.USER_NAME)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        score.text = "Your score is $correctAnswer out of $totalQuestions"

        finishButton.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}