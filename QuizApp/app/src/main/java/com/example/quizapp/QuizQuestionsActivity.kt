package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    //Create global variables for the views in the layout
    private var progressBar: ProgressBar?=null
    private var tvProgress: TextView? = null
    private var tvQuestion:TextView? = null
    private var ivImage: ImageView? = null
    private var tvOptionOne:TextView? = null
    private var tvOptionTwo:TextView? = null
    private var tvOptionThree:TextView? = null
    private var tvOptionFour:TextView? = null
    private var buttonSubmit: Button? = null
    private var userName: String? = null
    private var correctAnswers: Int = 0
    /**
     * This function is auto created by Android when the Activity Class is created.
     */


    private var currentPosition: Int = 1 // Default and the first question position
    private var questionsList: ArrayList<Question>? = null
    // END


    private var selectedOptionPosition: Int = 0
    // END


    override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        setContentView(R.layout.activity_quiz_questions)

        userName = intent.getStringExtra(Constants.USER_NAME)

        progressBar=findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.progressTv)
        tvQuestion = findViewById(R.id.questionTextView)
        ivImage = findViewById(R.id.countryImageView)
        tvOptionOne = findViewById(R.id.optionOneTextView)
        tvOptionTwo = findViewById(R.id.optionTwoTextView)
        tvOptionThree = findViewById(R.id.optionThreeTextView)
        tvOptionFour = findViewById(R.id.optionFourTextView)

        buttonSubmit = findViewById(R.id.submitButton)
        questionsList = Constants.getQuestions()
        // END

        setQuestion()

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)

        // TODO(STEP 1: Adding a click event for submit button.)
        buttonSubmit?.setOnClickListener (this)
    }


    private fun setQuestion() {

        val question: Question =
            questionsList!![currentPosition - 1] // Getting the question from the list with the help of current position.
        defaultOptionsView()

        // TODO (STEP 6: Check here if the position of question is last then change the text of the button.)
        // START
        if (currentPosition == questionsList!!.size) {
            buttonSubmit?.text = getString(R.string.finish)
        } else {
            buttonSubmit?.text = getString(R.string.submit)
        }
        // END
        progressBar?.progress =
            currentPosition // Setting the current progress in the progressbar using the position of question
        tvProgress?.text =
            "$currentPosition" + "/" + progressBar?.max // Setting up the progress text

        // Now set the current question and the options in the UI
        tvQuestion?.text = question.question
        ivImage?.setImageResource(question.image)
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour
    }

    override fun onClick(view: View?) {
        when (view?.id) {

            R.id.optionOneTextView -> {
                tvOptionOne?.let {
                    selectedOptionView(it, 1)
                }

            }

            R.id.optionTwoTextView -> {
                tvOptionTwo?.let {
                    selectedOptionView(it, 2)
                }

            }

            R.id.optionThreeTextView -> {
                tvOptionThree?.let {
                    selectedOptionView(it, 3)
                }

            }

            R.id.optionFourTextView -> {
                tvOptionFour?.let {
                    selectedOptionView(it, 4)
                }

            }

            // TODO(STEP 2: Adding a click event for submit button. And change the questions and check the selected answers.)
            // START
            R.id.submitButton->{

                if (selectedOptionPosition == 0) {

                    currentPosition++

                    when {

                        currentPosition <= questionsList!!.size -> {

                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, userName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, questionsList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = questionsList?.get(currentPosition - 1)

                    // This is to check if the answer is wrong
                    if (question!!.correctAnswer != selectedOptionPosition) {
                        answerView(selectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else {
                        correctAnswers++
                    }

                    // This is for correct answer
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (currentPosition == questionsList!!.size) {
                        buttonSubmit?.text = getString(R.string.finish)
                    } else {
                        buttonSubmit?.text = getString(R.string.next_question)
                    }

                    selectedOptionPosition = 0
                }
            }
        }
    }

    // TODO (STEP 3: Create a function for answer view.)
    // START
    /**
     * A function for answer view which is used to highlight the answer is wrong or right.
     */
    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {

            1 -> {
                tvOptionOne?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                tvOptionTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                tvOptionThree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                tvOptionFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()

        selectedOptionPosition = selectedOptionNum

        tv.setTextColor(
            Color.parseColor("#363A43")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }


    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0, it)
        }
        tvOptionTwo?.let {
            options.add(1, it)
        }
        tvOptionThree?.let {
            options.add(2, it)
        }
        tvOptionFour?.let {
            options.add(3,it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_birder_bg
            )
        }
    }
}