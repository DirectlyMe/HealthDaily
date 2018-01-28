package com.jackal.jack.healthdaily;

import java.io.Serializable;
/**
 * Created by Jack on 1/11/18.
 */

public class GoalUserInputType extends Goal implements Serializable {


    private String mUserAnswer = "";

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public void setType(String type) {
        super.setType(type);
    }

    public String getUserAnswer() {
        return mUserAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        mUserAnswer = userAnswer;
    }

}
