package com.example.quizapp

object Constants {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.argentinaflag,
            "Argentina",
            "Austrialia",
            "Germany",
            "Haiti",
            1
        )
        questionsList.add(que1)
        val que2 = Question(
            2, "What country does this flag belong to?",
            R.drawable.indiaflag,
            "Haiti",
            "India",
            "Fiji",
            "Brazil",
            2
        )
        questionsList.add(que2)
        val que3 = Question(
            3, "What country does this flag belong to?",
            R.drawable.germanyflag,
            "South Korea",
            "Canada",
            "France",
            "Germany",
            4
        )
        questionsList.add(que3)
        val que4 = Question(
            4, "What country does this flag belong to?",
            R.drawable.haitiflag,
            "France",
            "England",
            "Haiti",
            "China",
            3
        )
        val que5 = Question(
            5, "What country does this flag belong to?",
            R.drawable.australiaflag,
            "Japan",
            "Australia",
            "Cuba",
            "Puerto Rico",
            2
        )
        val que6 = Question(
            6, "What country does this flag belong to?",
            R.drawable.fijiflag,
            "Russia",
            "Fiji",
            "Egypt",
            "Italy",
            3
        )
        val que7 = Question(
            7, "What country does this flag belong to?",
            R.drawable.denmarkflag,
            "Denmark",
            "Kenya",
            "Ghana",
            "England",
            1
        )
        val que8 = Question(
            8, "What country does this flag belong to?",
            R.drawable.kuwaitflag,
            "Kuwait",
            "Australia",
            "Germany",
            "Haiti",
            1
        )
        val que9 = Question(
            1, "What country does this flag belong to?",
            R.drawable.newzealandflag,
            "Poland",
            "Austria",
            "New Zealand",
            "Netherlands",
            3
        )
        val que10 = Question(
            10, "What country does this flag belong to?",
            R.drawable.brazilflag,
            "Spain",
            "India",
            "Mexico",
            "Brazil",
            4
        )
        val que11 = Question(
            11, "What country does this flag belong to?",
            R.drawable.belgiumflag,
            "Bolivia",
            "Belgium",
            "France",
            "Czech Republic",
            3
        )



        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)
        questionsList.add(que8)
        questionsList.add(que9)
        questionsList.add(que10)
        return questionsList
    }
}