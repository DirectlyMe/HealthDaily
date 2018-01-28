package com.jackal.jack.healthdaily.Database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.jackal.jack.healthdaily.Database.GoalDbSchema.GoalTable;

import com.jackal.jack.healthdaily.Goal;

/**
 * Created by Jack on 1/23/18.
 */

public class GoalCursorWrapper extends CursorWrapper {

    public GoalCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Goal getGoal() {
        String stringQuestionNumber = getString(getColumnIndex(GoalTable.Cols.questionNumber));
        String goalType = getString(getColumnIndex(GoalTable.Cols.type));
        String questionText = getString(getColumnIndex(GoalTable.Cols.questionText));
        String answer = getString(getColumnIndex(GoalTable.Cols.userAnswer));

        Goal goal = new Goal();

        goal.setQuestionNumber(Integer.parseInt(stringQuestionNumber));
        goal.setType(goalType);
        goal.setQuestion(questionText);

        return goal;
    }
}
