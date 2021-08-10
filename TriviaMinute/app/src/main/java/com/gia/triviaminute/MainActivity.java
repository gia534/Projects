package com.gia.triviaminute;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.MessageFormat;


public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String EXTRA_DIFFICULTY = "difficulty";
    public static final String SHARED_PREFS = "preferences";
    public static final String KEY_HIGH_SCORE = "high score";

    private TextView highScoreTV;
    private int highScore;
    private Spinner difficultyLevelSpinner;
    private AutoCompleteTextView difficultyLevelATV;
    public String difficultyString;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        highScoreTV = findViewById(R.id.highScoreTextview);
        Button startQuiz = findViewById(R.id.startQuizButton);
        difficultyLevelSpinner = findViewById(R.id.spinner);

        String[] levels = QuestionModel.getAllDifficultyLevels();
        ArrayAdapter<String> adapterLevel = new ArrayAdapter<>(this,
                R.layout.level_list_outline, levels);
        adapterLevel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultyLevelSpinner.setAdapter(adapterLevel);

        loadHighScore();

        startQuiz.setOnClickListener(v -> {
            startQuiz();
            Log.d("HELLO", "Start Quiz Button clicked");
        });

    }

    private void startQuiz() {
        difficultyString = difficultyLevelSpinner.getSelectedItem().toString();
        Intent startQuizIntent = new Intent(MainActivity.this, QuizActivity.class);
        startQuizIntent.putExtra(EXTRA_DIFFICULTY, difficultyString);
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
        highScoreTV.setText(MessageFormat.format("High score: {0}", highScore));

    }

    private void updateHighScore(int newScore){
        highScore = newScore;
        highScoreTV.setText(MessageFormat.format("High score: {0}", highScore));

        SharedPreferences preferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(KEY_HIGH_SCORE, highScore);
        editor.apply();
    }

}