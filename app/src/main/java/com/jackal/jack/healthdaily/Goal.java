package com.jackal.jack.healthdaily;

import java.io.Serializable;

/**
 * Created by Jack on 1/11/18.
 */

public class Goal implements Serializable{

    private int mQuestionNumber;
    private String mQuestion;
    private String type;


    public int getQuestionNumber() {
        return mQuestionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        mQuestionNumber = questionNumber;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
