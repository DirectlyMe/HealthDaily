package com.jackal.jack.healthdaily;

import java.util.List;

/**
 * Created by Jack on 2/1/18.
 */

public class ProcessAnswers {

    private List<GoalUserInputType> mUserInputAnswers;
    private List<GoalToggleType> mToggleAnswers;

    public ProcessAnswers(List<GoalUserInputType> userInputAnswers,
                          List<GoalToggleType> toggleAnswers) {

        mUserInputAnswers = userInputAnswers;
        mToggleAnswers = toggleAnswers;

    }

    private void processInputAnswers(List<GoalUserInputType> answers) {

    }

    private void processToggleAnswers(List<GoalToggleType> answers) {

    }
}
