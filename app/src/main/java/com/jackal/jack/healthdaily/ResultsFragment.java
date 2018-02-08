package com.jackal.jack.healthdaily;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 1/16/18.
 */

public class ResultsFragment extends Fragment {

    private static final String ARG_ANSWERS = "user answers";
    private final String TEST_ANSWER_LOG = "Answers";

    private ProgressBar mProgressBarVitB;
    private ProgressBar mProgressBarVitD;
    private ProgressBar mProgressBarOmega3;

    private ProcessAnswers mProcessAnswers;

    private List<Goal> userAnswers;
    private List<GoalUserInputType> mUserTextAnswers;
    private List<GoalToggleType> mUserToggleAnswers;

    public static ResultsFragment newInstance(List<Goal> userAnswers) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_ANSWERS, (Serializable) userAnswers);

        ResultsFragment fragment = new ResultsFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userAnswers = (ArrayList) getArguments().getSerializable(ARG_ANSWERS);

        mUserTextAnswers = new ArrayList<>();
        mUserToggleAnswers = new ArrayList<>();

        for (Goal answer : userAnswers) {
            if (answer.getType().equals("Toggle")) {
                mUserToggleAnswers.add((GoalToggleType) answer);
            }
            else {
                mUserTextAnswers.add((GoalUserInputType) answer);
            }
        }

        for (GoalToggleType toggleAnswer : mUserToggleAnswers) {
            Log.i(TEST_ANSWER_LOG, Boolean.toString(toggleAnswer.getUserAnswer()));
        }
        for (GoalUserInputType userInput : mUserTextAnswers) {
            Log.i(TEST_ANSWER_LOG, userInput.getUserAnswer());
        }

        mProcessAnswers = new ProcessAnswers(mUserTextAnswers, mUserToggleAnswers);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_results_page, container, false);

        mProgressBarVitD = (ProgressBar) view.findViewById(R.id.progress_bar_vit_d);
        mProgressBarVitD.setScaleY(4f);

        mProgressBarVitB = (ProgressBar) view.findViewById(R.id.progress_bar_vitamin_b);
        mProgressBarVitB.setScaleY(4f);

        mProgressBarOmega3 = (ProgressBar) view.findViewById(R.id.progress_bar_omega_3);
        mProgressBarOmega3.setScaleY(4f);

        return view;
    }

}
