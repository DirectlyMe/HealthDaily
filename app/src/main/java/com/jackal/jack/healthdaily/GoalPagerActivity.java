package com.jackal.jack.healthdaily;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

/**
 * Created by Jack on 12/26/17.
 */

public class GoalPagerActivity extends AppCompatActivity implements GoalPagerFragment.Callbacks {

    ViewPager mViewPager;

    List<Goal> mGoals;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_pager);

        mViewPager = (ViewPager) findViewById(R.id.goal_view_pager);

        mGoals = GoalSingleton.get(this).getGoals();

        FragmentManager manager = getSupportFragmentManager();

        mViewPager.setAdapter(new FragmentStatePagerAdapter(manager) {
            @Override
            public Fragment getItem(int position) {
                Goal goal = mGoals.get(position);
                return new GoalPagerFragment().newInstance(goal);
            }

            @Override
            public int getCount() {
                return mGoals.size();
            }
        });
    }

    @Override
    public void sendGoals() {
        Intent intent = new ResultsActivity().newIntent(getApplicationContext(), mGoals);

        startActivity(intent);
    }
}
