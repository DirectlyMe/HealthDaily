package com.jackal.jack.healthdaily;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 1/16/18.
 */

public class ResultsActivity extends ActivityMain {

    private static final String USER_ANSWERS = "com.jackal.jack.healthdaily.useranswers";

    private static List<Goal> mGoals;

    protected Fragment createFragment() {
        return new ResultsFragment().newInstance(mGoals);
    }

    public static Intent newIntent(Context context, List<Goal> answers) {

        Intent intent = new Intent(context, ResultsActivity.class);

        mGoals = answers;

        return intent;
    }

}
