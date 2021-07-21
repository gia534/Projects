package com.gia.quizapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class SaveAnswers implements Parcelable {
    private String question;
    private String answer;
    SaveAnswers(){

    }

    SaveAnswers(String question, String answer){
        this.question = question;
        this.answer = answer;
    }


    protected SaveAnswers(Parcel in) {
        question = in.readString();
        answer = in.readString();
    }

    public static final Creator<SaveAnswers> CREATOR = new Creator<SaveAnswers>() {
        @Override
        public SaveAnswers createFromParcel(Parcel in) {
            return new SaveAnswers(in);
        }

        @Override
        public SaveAnswers[] newArray(int size) {
            return new SaveAnswers[size];
        }
    };

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeString(answer);
    }
}
