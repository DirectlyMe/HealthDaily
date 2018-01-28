package com.jackal.jack.healthdaily;

import java.io.Serializable;

/**
 * Created by Jack on 12/26/17.
 */

public class GoalToggleType extends Goal implements Serializable {

    private boolean mUserAnswer = false;

    public boolean getUserAnswer() {
        return mUserAnswer;
    }

    public void setUserAnswer(boolean userAnswer) {
        mUserAnswer = userAnswer;
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public void setType(String type) {
        super.setType(type);
    }
}
