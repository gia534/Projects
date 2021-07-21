package com.gia.quizapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.gia.quizapplication.QuiContract.*;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class QuizDBHelper  extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Quiz Application.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTIONS + " TEXT, " +
                QuestionsTable.COLUMN_OPTION_ONE + " TEXT, " +
                QuestionsTable.COLUMN_OPTION_TWO + " TEXT, " +
                QuestionsTable.COLUMN_OPTION_THREE + " TEXT, " +
                QuestionsTable.COLUMN_OPTION_FOUR + " TEXT, " +
                QuestionsTable.COLUMN_OPTION_FIVE + " TEXT, " +
                QuestionsTable.COLUMN_OPTION_SIX + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NUM + " INTEGER," +
                QuestionsTable.COLUMN_SAVE_ANSWER + "TEXT" +
                ")";

        final String storeAnswerTable = "CREATE TABLE " +
                QuestionsTable.TABLE_ANSWER + "( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY, " +
                QuestionsTable.COLUMN_QUESTIONS + " TEXT, " +
                QuestionsTable.COLUMN_SAVE_ANSWER + "TEXT" +
                ")";


        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        db.execSQL(storeAnswerTable);
        fillQuestionsTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_ANSWER);
        onCreate(db);

        //This is used when we want to update our database schema Database version will need to be incremented by 1;
    }

    private void fillQuestionsTable(){
        QuestionModel q1 = new QuestionModel("What is your favorite ice cream?", "Vanilla", "Chocolate", "Strawberry", "Cookies & Cream", "Mint Chocolate",  "Other", 1);
        addQuestion(q1);
        QuestionModel q2 = new QuestionModel("What is your favorite color?", "Purple", "Red", "Green", "Blue", "Black", "Other", 1);
        addQuestion(q2);
        QuestionModel q3 = new QuestionModel("What is your favorite season", "Fall", "Winter", "Spring", "Summer", "All", "None", 1);
        addQuestion(q3);
        QuestionModel q4 = new QuestionModel("What is your favorite book / tv show / movie genre?", "Thriller", "Comedy", "Mystery", "Drama", "Rom-Com","Other", 1);
        addQuestion(q4);
        QuestionModel q5 = new QuestionModel("What is your favorite genre of music?", "Rock", "Hip Hop", "R&B", "Jazz", "Heavy Metal", "Pop", 1);
        addQuestion(q5);
    }

    private void addQuestion(QuestionModel question){
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTIONS, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION_ONE, question.getOptionOne());
        cv.put(QuestionsTable.COLUMN_OPTION_TWO, question.getOptionTwo());
        cv.put(QuestionsTable.COLUMN_OPTION_THREE, question.getOptionThree());
        cv.put(QuestionsTable.COLUMN_OPTION_FOUR, question.getOptionFour());
        cv.put(QuestionsTable.COLUMN_OPTION_FIVE, question.getOptionFive());
        cv.put(QuestionsTable.COLUMN_OPTION_SIX, question.getOptionSix());
        cv.put(QuestionsTable.COLUMN_ANSWER_NUM, question.getAnswerNum());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public ArrayList<QuestionModel> getAllQuestions(){
        ArrayList<QuestionModel> questionModelList = new ArrayList<>();
        db = getReadableDatabase(); // This will call the database onCreate method and create the database;

        Cursor cursor = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);
        if(cursor.moveToFirst()){
            do{
                QuestionModel question = new QuestionModel();

                // We get the question out of getColumnIndex and save it to question
                question.setQuestion(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_QUESTIONS)));
                question.setOptionOne(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION_ONE)));
                question.setOptionTwo(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION_TWO)));
                question.setOptionThree(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION_THREE)));
                question.setOptionFour(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION_FOUR)));
                question.setOptionFive(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION_FIVE)));
                question.setOptionSix(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION_SIX)));
                question.setAnswerNum(cursor.getInt(cursor.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NUM)));

                questionModelList.add(question);
            }while (cursor.moveToNext());
        }

        cursor.close();
        return questionModelList;
    }
}


