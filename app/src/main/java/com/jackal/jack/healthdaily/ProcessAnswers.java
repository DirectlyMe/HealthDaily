package com.jackal.jack.healthdaily;

import java.util.List;

/**
 * Created by Jack on 2/1/18.
 */

public class ProcessAnswers {

    private List<GoalUserInputType> mUserInputAnswers;
    private List<GoalToggleType> mToggleAnswers;

    private int userHeightFeet;
    private int userHeightInches;
    private int userWeight;
    private int vitaminD;
    private int veggies;
    private int protien;
    private double optimalProtein;

    public ProcessAnswers(List<GoalUserInputType> userInputAnswers,
                          List<GoalToggleType> toggleAnswers) {

        mUserInputAnswers = userInputAnswers;
        mToggleAnswers = toggleAnswers;

        processInputAnswers(mUserInputAnswers);

    }

    private void processInputAnswers(List<GoalUserInputType> answers) {
        for (GoalUserInputType answer : answers) {
            int userAnswer = Integer.parseInt(answer.getUserAnswer());
            switch (answer.getQuestionNumber()) {
                case 6:
                    String userHeight = answer.getUserAnswer();
                    String[] tokenize = userHeight.split("'");
                    userHeightFeet = Integer.parseInt(tokenize[0]);
                    userHeightInches = Integer.parseInt(tokenize[1]);
                case 7:
                    userWeight = userAnswer;
                    optimalProtein = userWeight * .37;
                case 8:
                    if (userAnswer >= 5) {
                        vitaminD = 100;
                    }
                    else if (userAnswer < 5 && userAnswer >= 3) {
                        vitaminD = 50;
                    }
                    else if (userAnswer < 3 && userAnswer >= 1) {
                        vitaminD = 30;
                    }
                    else {
                        vitaminD = 0;
                    }
                case 9:
                    if (userAnswer >= 20) {
                        veggies = 100;
                    }
                    else if (userAnswer < 20 && userAnswer >= 10) {
                        veggies = 60;
                    }
                    else if (userAnswer < 10 && userAnswer > 5) {
                        veggies = 30;
                    }
                    else {
                        veggies = 0;
                    }
                case 10:
                    double tempAnswer = (double) userAnswer;
                    if (tempAnswer >= optimalProtein) {
                        protien = 100;
                    }
                    else if (tempAnswer < optimalProtein && tempAnswer >= optimalProtein /2) {
                        protien = 60;
                    }
                    else if (tempAnswer < optimalProtein /2 && tempAnswer >= optimalProtein /4) {
                        protien = 30;
                    }
                    else {
                        protien = 0;
                    }
            }
        }
    }

    private void processToggleAnswers(List<GoalToggleType> answers) {

    }
}
