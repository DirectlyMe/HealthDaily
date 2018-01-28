package com.jackal.jack.healthdaily.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jackal.jack.healthdaily.Database.GoalDbSchema.GoalTable;


/**
 * Created by Jack on 1/17/18.
 */

public class GoalBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "goalBase.db";

    public GoalBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + DATABASE_NAME
        + "(" + "_id integer primary key autoincrement, " +
                GoalTable.Cols.questionNumber + ", " +
                GoalTable.Cols.type + ", " +
                GoalTable.Cols.questionText + ", " +
                GoalTable.Cols.userAnswer + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
