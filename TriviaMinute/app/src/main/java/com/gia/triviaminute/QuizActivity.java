package com.gia.triviaminute;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class QuizActivity extends AppCompatActivity {
    public static final String EXTRA_SCORE = "score_results";
    private static final long COUNTDOWN_IN_MILLIS = 60000;
    private static final String SCORE_KEY = "keyScore";
    private static final String QUESTION_COUNT_KEY = "question count";
    private static final String KEY_MILLIS_LEFT = "Milliseconds left";
    private static final String ANSWERED_KEY = "answer";
    private static final String QUESTION_KEY_LIST ="Question list";

    private TextView questionText;
    private TextView scoreText;
    private TextView questCountText;
    private TextView levelText;
    private TextView countDownText;
    private RadioGroup radioGroup;
    private RadioButton radioOne;
    private RadioButton radioTwo;
    private RadioButton radioThree;
    private RadioButton radioFour;
    private RadioButton radioFive;
    private RadioButton radioSix;
    private Button confirmNextButton;
    private ArrayList<QuestionModel> questionModelList;

    // Changes color of radio button to red or green
    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    private int questionCounter;
    private int questionCountTotal; // Total questions in arrayList
    private QuestionModel currentQuestion;

    private int score;
    private boolean answered;

    private long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        scoreText = findViewById(R.id.textview_score);
        questionText = findViewById(R.id.textviewQuestions);
        questCountText = findViewById(R.id.textview_questionCounter);
        levelText = findViewById(R.id.textview_difficulty_level);
        countDownText = findViewById(R.id.textview_countDownTimer);
        radioGroup = findViewById(R.id.radioGroup);
        radioOne = findViewById(R.id.radioButtonOne);
        radioTwo = findViewById(R.id.radioButtonTwo);
        radioThree = findViewById(R.id.radioButtonThree);
        radioFour = findViewById(R.id.radioButtonFour);
        radioFive = findViewById(R.id.radioButtonFive);
        radioSix = findViewById(R.id.radioButtonSix);
        confirmNextButton = findViewById(R.id.confirm_next_button);



        textColorDefaultRb = radioOne.getTextColors();
        textColorDefaultCd = countDownText.getTextColors();

        Intent intent = getIntent();
        String difficulty = intent.getStringExtra(MainActivity.EXTRA_DIFFICULTY);

        levelText.setText(String.format("Difficulty: %s", difficulty));

        if (savedInstanceState == null){
            QuizDBHelper quizDBHelper = new QuizDBHelper(this);
            questionModelList = quizDBHelper.getQuestions(difficulty);
            questionCountTotal = questionModelList.size();
            //Collections.shuffle(questionModelList);
            showNextQuestion();
        }else{
            questionModelList = savedInstanceState.getParcelableArrayList(QUESTION_KEY_LIST);
            questionCountTotal = questionModelList.size();
            questionCounter = savedInstanceState.getInt(QUESTION_COUNT_KEY);
            currentQuestion = questionModelList.get(questionCounter - 1);
            score = savedInstanceState.getInt(SCORE_KEY);
            timeLeftInMillis = savedInstanceState.getLong(KEY_MILLIS_LEFT);
            answered = savedInstanceState.getBoolean(ANSWERED_KEY);

            // Resumes where timer was left off before device rotation
            if (!answered){
                startCountDown();
            } else {
                updateCountDownText();
                showSolution();
            }
        }

        confirmNextButton.setOnClickListener(v -> {
            if(!answered){
                if(radioOne.isChecked() || radioTwo.isChecked() || radioThree.isChecked()
                        || radioFour.isChecked() || radioFive.isChecked() || radioSix.isChecked()){
                    checkAnswer();
                    //saveAnswer();
                } else {
                    Toast.makeText(QuizActivity.this, "Select an answer", Toast.LENGTH_SHORT).show();

                }
            } else {
                showNextQuestion();
            }
        });
    }


    private void showNextQuestion(){
        // resetting the color of the radio button
        radioOne.setTextColor(textColorDefaultRb);
        radioTwo.setTextColor(textColorDefaultRb);
        radioThree.setTextColor(textColorDefaultRb);
        radioFour.setTextColor(textColorDefaultRb);
        radioFive.setTextColor(textColorDefaultRb);
        radioSix.setTextColor(textColorDefaultRb);

        radioGroup.clearCheck(); // When we show a new question we want the previous selection to be cleared

        if (questionCounter < questionCountTotal) {
            currentQuestion = questionModelList.get(questionCounter);

            questionText.setText(currentQuestion.getQuestion());
            radioOne.setText(currentQuestion.getOptionOne());
            radioTwo.setText(currentQuestion.getOptionTwo());
            radioThree.setText(currentQuestion.getOptionThree());
            radioFour.setText(currentQuestion.getOptionFour());
            radioFive.setText(currentQuestion.getOptionFive());
            radioSix.setText(currentQuestion.getOptionSix());

            questionCounter++;
            questCountText.setText(MessageFormat.format("Question: {0} out of {1}", questionCounter, questionCountTotal));
            answered = false;
            confirmNextButton.setText(getString(R.string.confirm));

            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();

        } else {
            finishQuiz();
        }
    }

    private void startCountDown(){
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                // Count down timer usually shows one second when it is done
                // So we set it to 0 so it can be shown when timer is done

                timeLeftInMillis = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText(){
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        countDownText.setText(timeFormatted);

        if (timeLeftInMillis <  10000) {
            countDownText.setTextColor(Color.RED);
        } else {
            countDownText.setTextColor(textColorDefaultCd);
        }
    }

    private void checkAnswer() {
        answered = true;

        countDownTimer.cancel();

        RadioButton radioButtonSelected = findViewById(radioGroup.getCheckedRadioButtonId());

        // + 1 is added because index start at 0 but question 1 start at index 1
        int answerNum = radioGroup.indexOfChild(radioButtonSelected) + 1;

        if(answerNum == currentQuestion.getAnswerNum()){
            score++;
            scoreText.setText(MessageFormat.format("{0}{1}", getString(R.string.score), score));
        }

        showSolution();
    }

    private void showSolution() {
        radioOne.setTextColor(Color.RED);
        radioTwo.setTextColor(Color.RED);
        radioThree.setTextColor(Color.RED);
        radioFour.setTextColor(Color.RED);
        radioFive.setTextColor(Color.RED);
        radioSix.setTextColor(Color.RED);

        switch (currentQuestion.getAnswerNum()){
            case 1:
                radioOne.setTextColor(Color.GREEN);
                questionText.setText(R.string.answer_1);
                break;
            case 2:
                radioTwo.setTextColor(Color.GREEN);
                questionText.setText(R.string.answer_2);
                break;
            case 3:
                radioThree.setTextColor(Color.GREEN);
                questionText.setText(R.string.answer_3);
                break;
            case 4:
                radioFour.setTextColor(Color.GREEN);
                questionText.setText(R.string.answer_4);
                break;
            case 5:
                radioFive.setTextColor(Color.GREEN);
                questionText.setText(R.string.answer_5);
                break;
            case 6:
                radioSix.setTextColor(Color.GREEN);
                questionText.setText(R.string.answer_6);
                break;
        }

        if (questionCounter < questionCountTotal){
            confirmNextButton.setText(R.string.next);

        }else{
            confirmNextButton.setText(R.string.finish);
        }
    }

    private void finishQuiz(){
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE, score);
        setResult(RESULT_OK, resultIntent);
        //This will close the activity
        finish();
    }

    @Override
    public void onBackPressed() {
        // 2000 = 2 seconds
        // If less than 2 seconds have past since
        // the last time the back button has been clicked
        if(backPressedTime + 2000 > System.currentTimeMillis()){
            finishQuiz();
            // The result will be saved
        } else {
            Toast.makeText(this, "Press back again to finish", Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putInt(SCORE_KEY, score);
        outState.putInt(QUESTION_COUNT_KEY, questionCounter);
        outState.putLong(KEY_MILLIS_LEFT, timeLeftInMillis);
        outState.putBoolean(ANSWERED_KEY, answered);
        outState.putParcelableArrayList(QUESTION_KEY_LIST, questionModelList);
    }
}