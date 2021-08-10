package com.gia.triviaminute;

import android.os.Parcel;
import android.os.Parcelable;

/*
 * Bridge between app and database
 * */
public class QuestionModel implements Parcelable {

    public static final String EASY_LEVEL ="Easy";
    public static final String MEDIUM_LEVEL ="Medium";
    public static final String HARD_LEVEL ="Hard";
    public static final String EXTREMELY_HARD_LEVEL ="Difficult";


    private String question;
    private String optionOne;
    private String optionTwo;
    private String optionThree;
    private String optionFour;
    private String optionFive;
    private String optionSix;
    private int answerNum;
    private String difficulty;
    //private String saveAnswer;


    public QuestionModel(){

    }


    public QuestionModel(String question, String optionOne, String optionTwo, String optionThree, String optionFour, String optionFive,
                         String optionSix, int answerNum, String difficulty) {
        this.question = question;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.optionThree = optionThree;
        this.optionFour = optionFour;
        this.optionFive = optionFive;
        this.optionSix = optionSix;
        this.answerNum = answerNum;
        this.difficulty = difficulty;
    }
    public QuestionModel(String question, String optionOne, String optionTwo, String optionThree, String optionFour, String optionFive,
                         String optionSix, int answerNum) {
        this.question = question;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.optionThree = optionThree;
        this.optionFour = optionFour;
        this.optionFive = optionFive;
        this.optionSix = optionSix;
        this.answerNum = answerNum;
    }
    //    public QuestionModel(String saveAnswer){
//        this.saveAnswer = saveAnswer;
//    }
//
    protected QuestionModel(Parcel in) {
        question = in.readString();
        optionOne = in.readString();
        optionTwo = in.readString();
        optionThree = in.readString();
        answerNum = in.readInt();
        difficulty = in.readString();
    }

    public static final Creator<QuestionModel> CREATOR = new Creator<QuestionModel>() {
        @Override
        public QuestionModel createFromParcel(Parcel in) {
            return new QuestionModel(in);
        }

        @Override
        public QuestionModel[] newArray(int size) {
            return new QuestionModel[size];
        }
    };

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionOne() {
        return optionOne;
    }

    public void setOptionOne(String optionOne) {
        this.optionOne = optionOne;
    }

    public String getOptionTwo() {
        return optionTwo;
    }

    public void setOptionTwo(String optionTwo) {
        this.optionTwo = optionTwo;
    }

    public String getOptionThree() {
        return optionThree;
    }

    public void setOptionThree(String optionThree) {
        this.optionThree = optionThree;
    }

    public String getOptionFour() { return optionFour; }

    public void setOptionFour(String optionFour) {
        this.optionFour = optionFour;
    }

    public String getOptionFive() {
        return optionFive;
    }

    public void setOptionFive(String optionFive) {
        this.optionFive = optionFive;
    }

    public String getOptionSix() {
        return optionSix;
    }

    public void setOptionSix(String optionSix) {
        this.optionSix = optionSix;
    }

    public int getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(int answerNum) {
        this.answerNum = answerNum;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeString(optionOne);
        dest.writeString(optionTwo);
        dest.writeString(optionThree);
        dest.writeString(optionFour);
        dest.writeString(optionFive);
        dest.writeString(optionSix);
        dest.writeInt(answerNum);
        dest.writeString(difficulty);
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public static String[] getAllDifficultyLevels(){
        return new String[]{
                EASY_LEVEL,
                MEDIUM_LEVEL,
                HARD_LEVEL,
                EXTREMELY_HARD_LEVEL
        };
    }
}
