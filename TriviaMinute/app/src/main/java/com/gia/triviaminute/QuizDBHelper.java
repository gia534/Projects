package com.gia.triviaminute;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.gia.triviaminute.QuiContract.*;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class QuizDBHelper  extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Quiz Application.db";
    private static final int DATABASE_VERSION = 2;

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
                QuestionsTable.COLUMN_ANSWER_NUM + " INTEGER, " +
                QuestionsTable.COLUMN_DIFFICULTY + " TEXT" +
                ")";

        final String storeAnswerTable = "CREATE TABLE " +
                QuestionsTable.TABLE_ANSWER + "( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY, " +
                QuestionsTable.COLUMN_QUESTIONS + " TEXT" +
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
        QuestionModel q1 = new QuestionModel("Easy: Which city is the United States capitol?", "Washington DC", "New York City",
                "Los Angeles", "San Fransisco", "Trenton", "Toronto", 1, QuestionModel.EASY_LEVEL);
        addQuestion(q1);
        QuestionModel q2 = new QuestionModel("How many continents are there in the world?", "5", "4", "1",
                "20", "7", "6", 5, QuestionModel.EASY_LEVEL);
        addQuestion(q2);
        QuestionModel q3 = new QuestionModel("Which city hosted the 2012 Summer Olympics?", "Rio de Janeiro, Brazil",
                "Chicago, Illinois", "Malibu, California", "London, England", "Tokyo, Japan",
                "Paris, France", 4, QuestionModel.EASY_LEVEL );
        addQuestion(q3);
        QuestionModel q4 = new QuestionModel("What does the 'F' stand for in FBI?", "Fungus", "Federal",
                "Finance", "Failure", "Faithful", "Fake", 2, QuestionModel.EASY_LEVEL);
        addQuestion(q4);
        QuestionModel q5 = new QuestionModel("Which state is called the Golden State?", "Hawaii", "California",
                "Florida", "Maine", "Texas", "Alaska", 2, QuestionModel.EASY_LEVEL);
        addQuestion(q5);
        QuestionModel q6 = new QuestionModel("The Statue of Liberty was a gift to the United States from which country?", "Italy",
                "Germany", "France", "China", "South Korea", "Egypt", 3, QuestionModel.EASY_LEVEL);
        addQuestion(q6);
        QuestionModel q7 = new QuestionModel("What sport does Cristiano Ronaldo play?", "Football", "Swimming",
                "Baseball", "Rugby", "Ice Hockey", "Basketball", 1, QuestionModel.EASY_LEVEL);
        addQuestion(q7);
        QuestionModel q8 = new QuestionModel("What does 'O' stand for in the periodic table?", "Hydrogen", "Peroxide",
                "Sodium", "Oxygen", "Nitrogen", "Osmium", 4, QuestionModel.EASY_LEVEL);
        addQuestion(q8);
        QuestionModel q9 = new QuestionModel("Who played Jack in Titanic", "Chris Hemsworth", "Jake Gyllenhaal",
                "Leonardo DiCaprio", "Johnny Depp", "Luke Evans", "Brad Pitt", 3, QuestionModel.EASY_LEVEL);
        addQuestion(q9);
        QuestionModel q10 = new QuestionModel("Which state is Washington D.C. located in?", "Washington", "Maryland",
                "Maine", "Montana", "Arizona", "Utah", 2, QuestionModel.EASY_LEVEL);
        addQuestion(q10);
        QuestionModel q11 = new QuestionModel("How many days are in a leap year?", "366", "365", "380",
                "345", "356", "353", 1, QuestionModel.EASY_LEVEL);
        addQuestion(q11);
        QuestionModel q12 = new QuestionModel("Who is known as the GOAT in the professional sport of gymnastics?", "Jordan Chiles",
                "Gabby Douglas", "Simone Biles", "Shannon Miller", "Aly Raisman",
                "Laurie Hernandez", 3, QuestionModel.EASY_LEVEL);
        addQuestion(q12);
        QuestionModel q13 = new QuestionModel("What type of animal is Bambi?", "Horse", "Bird", "Deer", "Fox",
                "Tiger", "Lion", 3, QuestionModel.EASY_LEVEL);
        addQuestion(q13);
        QuestionModel q14 = new QuestionModel("How many Harry Potter books are there?", "2", "8", "4",
                "7", "1", "10", 4, QuestionModel.EASY_LEVEL);
        addQuestion(q14);
        QuestionModel q15 = new QuestionModel("How many Harry Potter movies are there?", "2", "8", "4",
                "7", "1", "10", 2, QuestionModel.EASY_LEVEL);
        addQuestion(q15);
        QuestionModel q16 = new QuestionModel("Which of the following cities is the most populous city in the United States?", "San Francisco",
                "New York City", "Seattle", "Miami", "Orlando", "Austin", 2, QuestionModel.EASY_LEVEL);
        addQuestion(q16);
        QuestionModel q17 = new QuestionModel("Which color eyes do most humans have?", "Brown", "Blue",
                "Green", "Hazel", "Black", "Light-Blue", 1, QuestionModel.EASY_LEVEL);
        addQuestion(q17);
        QuestionModel q18 = new QuestionModel("How many years are there in a century?", "20", "10", "1,000",
                "10000", "1", "100", 6, QuestionModel.EASY_LEVEL);
        addQuestion(q18);
        QuestionModel q19 = new QuestionModel("Where did french fries originate from", "France", "Germany", "Italy",
                "Russia", "England", "Belgium", 6, QuestionModel.EASY_LEVEL);
        addQuestion(q19);
        QuestionModel q20 = new QuestionModel("Which president appears on the one dollar bill?", "George Washington", "Barack Obama",
                "George W. Bush", "Bill Clinton", "Abraham Lincoln", "Ronald Reagan",1, QuestionModel.EASY_LEVEL);
        addQuestion(q20);
        QuestionModel q21 = new QuestionModel("Which is the largest continent on earth", "North America", "South America",
                "Asia", "Europe", "Africa", "Antarctica", 3, QuestionModel.EASY_LEVEL);
        addQuestion(q21);
        QuestionModel q22 = new QuestionModel("How many legs do spiders have?", "4", "2", "8", "6",
                "10", "12", 3, QuestionModel.EASY_LEVEL);
        addQuestion(q22);
        QuestionModel q23 = new QuestionModel("How many dwarfs are in the movie Snow White?", "8", "7", "17",
                "27", "6", "3", 2, QuestionModel.EASY_LEVEL);
        addQuestion(q23);
        QuestionModel q24 = new QuestionModel("What is the fastest land animal", "Cheetah", "Tiger", "Lion",
                "Puma", "Bear", "Cat", 1, QuestionModel.EASY_LEVEL);
        addQuestion(q24);
        QuestionModel q25 = new QuestionModel("Where is the Eiffel Tower located?", "Paris, Texas", "Paris, Maine",
                "Paris, Idaho", "Paris, Kentucky", "Paris, France", "Paris, Michigan", 5, QuestionModel.EASY_LEVEL);
        addQuestion(q25);
        QuestionModel q26 = new QuestionModel("By land mass, which state is the smallest state in the United States?", "Hawaii",
                "Connecticut", "Rhode Island", "Delaware", "New Jersey", "Vermont", 4, QuestionModel.EASY_LEVEL);
        addQuestion(q26);
        QuestionModel q27 = new QuestionModel("By land mass, which state is the largest state in the United States?", "California",
                "Alaska", "Texas", "New York", "Montana", "Nevada",2, QuestionModel.EASY_LEVEL);
        addQuestion(q27);
        QuestionModel q28 = new QuestionModel("How many bones do sharks have?", "100", "300", "0",
                "4,000", "50", "600", 3, QuestionModel.EASY_LEVEL);
        addQuestion(q28);
        QuestionModel q29 = new QuestionModel("Which fruit serves as a base for guacamole?", "Strawberry", "Kiwi",
                "Apple", "Avocado", "Banana", "Orange", 4, QuestionModel.EASY_LEVEL);
        addQuestion(q29);
        QuestionModel q30 = new QuestionModel("What is the most popular car color?", "White", "Orange",
                "Black", "Red", "Blue", "Silver", 1, QuestionModel.EASY_LEVEL);
        addQuestion(q30);

        QuestionModel q31 = new QuestionModel("Who is the owner of Amazon?", "A", "B", "C",
                "D", "E", "F", 1, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q31);
        QuestionModel q32 = new QuestionModel("Who is the owner of Amazon?", "A", "B", "C",
                "D", "E", "F", 1, QuestionModel.HARD_LEVEL);
        addQuestion(q32);
        QuestionModel q33 = new QuestionModel("Who is the owner of Amazon?", "A", "B", "C",
                "D", "E", "F", 1, QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q33);

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
        cv.put(QuestionsTable.COLUMN_DIFFICULTY, question.getDifficulty());
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
                question.setDifficulty(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));


                questionModelList.add(question);
            }while (cursor.moveToNext());
        }

        cursor.close();
        return questionModelList;
    }

    public ArrayList<QuestionModel> getQuestions(String difficulty){
        ArrayList<QuestionModel> questionModelList = new ArrayList<>();
        db = getReadableDatabase(); // This will call the database onCreate method and create the database;

        String[] selectionArgs =  new String[]{difficulty};

        Cursor cursor = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME
                + " WHERE " + QuestionsTable.COLUMN_DIFFICULTY + " = ?", selectionArgs);
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
                question.setDifficulty(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));


                questionModelList.add(question);
            }while (cursor.moveToNext());
        }

        cursor.close();
        return questionModelList;
    }
}
