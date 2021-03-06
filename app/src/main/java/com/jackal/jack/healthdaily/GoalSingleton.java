package com.jackal.jack.healthdaily;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 12/27/17.
 */

public class GoalSingleton {

    private Context mContext;

    private static GoalSingleton sGoalSingleton;


    public static GoalSingleton get(Context context) {

        if (sGoalSingleton == null) {
            sGoalSingleton = new GoalSingleton(context);
        }
        return sGoalSingleton;
    }

    public GoalSingleton(Context context) {

        mContext = context.getApplicationContext();

    }

    public List<Goal> getGoals() {
        List<Goal> goals = new ArrayList<>();

        Resources res = mContext.getResources();

        String[] questionsToggle = res.getStringArray(R.array.questions_toggle);
        String[] questionsUserInput = res.getStringArray(R.array.questions_user_input);
        String[] userInputHints = res.getStringArray(R.array.user_input_hints);


        for (int i = 0; i < questionsToggle.length; i++) {
            GoalToggleType goal = new GoalToggleType();
            goal.setType("Toggle");
            goal.setQuestion(questionsToggle[i]);
            goal.setQuestionNumber(i + 1);
            goals.add(goal);
        }

        for (int i = 0; i < questionsUserInput.length; i++) {
            GoalUserInputType goal = new GoalUserInputType();
            goal.setType("UserInput");
            goal.setUserHint(userInputHints[i]);
            goal.setQuestion(questionsUserInput[i]);
            goal.setQuestionNumber(i + 6);
            goals.add(goal);
        }

        return goals;
    }



}
