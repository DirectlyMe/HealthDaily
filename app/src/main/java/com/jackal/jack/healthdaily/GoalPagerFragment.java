package com.jackal.jack.healthdaily;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.telecom.Call;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Jack on 12/26/17.
 */

public class GoalPagerFragment extends Fragment {

    private TextView mQuestionNumber;
    private TextView mQuestionView;
    private EditText mUserInputEditText;
    private RadioButton mRadioButtonTrue;
    private RadioButton mRadioButtonFalse;
    private Button mSubmitButton;

    private Goal mGoal;
    private GoalToggleType mGoalToggle;
    private GoalUserInputType mGoalUserInput;
    private Callbacks mCallbacks;
    private static final String ARG_GOAL = "goal object";

    public interface Callbacks {
        void sendGoals();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallbacks = (Callbacks) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }


    public static GoalPagerFragment newInstance(Goal goal) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_GOAL, goal);

        GoalPagerFragment pager = new GoalPagerFragment();
        pager.setArguments(args);
        return pager;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mGoal = (Goal) getArguments().getSerializable(ARG_GOAL);

        //Casts the Goal to a specific type of goal depending on type variable
        if (mGoal.getType().equals("Toggle")) {
            mGoalToggle = (GoalToggleType) mGoal;
        }
        else {
            mGoalUserInput = (GoalUserInputType) mGoal;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view;

        //Check to know which goal type to display.
        if(mGoal.getType().equals("Toggle")) {
            view = inflater.inflate(R.layout.fragment_goals_toggle, container, false);

            mRadioButtonTrue = (RadioButton) view.findViewById(R.id.radio_button_true);
            mRadioButtonTrue.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mGoalToggle.setUserAnswer(true);
                }
            });
            mRadioButtonFalse = (RadioButton) view.findViewById(R.id.radio_button_false);
            mRadioButtonFalse.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mGoalToggle.setUserAnswer(false);
                }
            });
        }
        else {
            view = inflater.inflate(R.layout.fragment_goals_userinput, container, false);

            mUserInputEditText = (EditText) view.findViewById(R.id.editText);

            mUserInputEditText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    mGoalUserInput.setUserAnswer(mUserInputEditText.getText().toString());
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        mQuestionNumber = (TextView) view.findViewById(R.id.question_number_view);
        mQuestionNumber.setText(mGoal.getQuestionNumber() + "/20");

        mQuestionView = (TextView) view.findViewById(R.id.question_text_view);
        mQuestionView.setText(mGoal.getQuestion());


        mSubmitButton = (Button) view.findViewById(R.id.submit_button);
        if (mGoal.getQuestionNumber() != 20) {
            mSubmitButton.setVisibility(View.INVISIBLE);
        }
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mCallbacks.sendGoals();
            }
        });

        return view;
    }
}
