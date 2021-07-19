package com.gia.quizapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button startQuiz;
    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGH_SCORE = "High score";

    private TextView highScoreTV;
    private long highScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        highScoreTV = findViewById(R.id.highScoreTextview);
        loadHighScore();

        startQuiz = findViewById(R.id.startQuizButton);
        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });

    }

    private void startQuiz() {
        Intent startQuizIntent = new Intent(MainActivity.this, QuizActivity.class);
        startActivityForResult(startQuizIntent, REQUEST_CODE_QUIZ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ){
            if (resultCode == RESULT_OK){
                int score = data.getIntExtra(QuizActivity.EXTRA_SCORE, 0);
                if (score > highScore){
                    updateHighScore(score);
                }
            }
        }

    }

    private void  loadHighScore() {
        SharedPreferences preferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highScore = preferences.getInt(KEY_HIGH_SCORE, 0);
        highScoreTV.setText("High score: " + highScore);

    }

    private void updateHighScore(int newScore){
        highScore = newScore;
        highScoreTV.setText("High score: " + highScore);

        SharedPreferences preferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putFloat(KEY_HIGH_SCORE, highScore);
        editor.apply();
    }
}