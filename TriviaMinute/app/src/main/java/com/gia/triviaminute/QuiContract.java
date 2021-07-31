package com.gia.triviaminute;

import android.provider.BaseColumns;

/*
Container for different constants that will be
needed for SQL operations
 */
public final class QuiContract {

    private QuiContract(){

    }

    public static class QuestionsTable implements BaseColumns {
        //Static allows you to access the variable
        //Without needing to get an instance of QuestionTable
        public static final String TABLE_NAME = "quiz_questions";
        public static final String TABLE_ANSWER = "Answers";
        public static final String COLUMN_QUESTIONS = "question";
        public static final String COLUMN_OPTION_ONE = "optionOne";
        public static final String COLUMN_OPTION_TWO = "optionTwo";
        public static final String COLUMN_OPTION_THREE = "optionThree";
        public static final String COLUMN_OPTION_FOUR = "optionFour";
        public static final String COLUMN_OPTION_FIVE = "optionFive";
        public static final String COLUMN_OPTION_SIX = "optionSix";
        public static final String COLUMN_ANSWER_NUM = "answer_number";
        public static final String COLUMN_DIFFICULTY ="difficulty";
    }
}
