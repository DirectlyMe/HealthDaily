package com.jackal.jack.healthdaily.Database;

/**
 * Created by Jack on 1/17/18.
 */

public class GoalDbSchema {

    public static final class GoalTable {
        public static final String NAME = "goalsTable";

        public static final class Cols {
            public static final String questionNumber = "questionNum";
            public static final String type = "type";
            public static final String userAnswer = "answer";
            public static final String questionText = "questionText";
        }
    }
}
