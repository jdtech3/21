package io.bitbucket.team_21.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import io.bitbucket.team_21.app.recycler.Assignment;
import io.bitbucket.team_21.app.recycler.AssignmentsAdapter;

public class questspage extends AppCompatActivity {
    ArrayList assignments;
    AssignmentsAdapter adapter;

    protected void initRecycler(Context context) {
        // Define
        RecyclerView assignmentRecycler = (RecyclerView) findViewById(R.id.assignmentRecycler);
        LinearLayoutManager assignmentRecyclerLLM = (LinearLayoutManager) new LinearLayoutManager(context);
        assignments = Assignment.createDummyAssignments("upcoming");
        adapter = new AssignmentsAdapter(assignments);

        // Set things
        assignmentRecycler.setAdapter(adapter);
        assignmentRecycler.setLayoutManager(assignmentRecyclerLLM);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Get decorView so we can make changes to it
        final View decorView = getWindow().getDecorView();

        // Override the SystemUiVisibilityChange event listener
        decorView.setOnSystemUiVisibilityChangeListener(
                new View.OnSystemUiVisibilityChangeListener() {
                    @Override
                    public void onSystemUiVisibilityChange(int visibility) {
                        // Force the flags to be immersive mode every time, mwahahaha
                        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

                        decorView.setSystemUiVisibility(uiOptions);
                    }
                });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questspage);

        // Init RecyclerViews
        initRecycler(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Force the flags to be immersive mode, mwahahaha
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        decorView.setSystemUiVisibility(uiOptions);
    }

    // Overdue/Upcoming toggle
    public void overdueClicked(View view) {
        Button overdueBtnView = findViewById(R.id.overdueButton);
        overdueBtnView.setBackgroundResource(R.drawable.half_rounded_corners_right);
        overdueBtnView.setTextColor(Color.parseColor("#000000"));
        Button upcomingBtnView = findViewById(R.id.upcomingButton);
        upcomingBtnView.setBackgroundResource(R.drawable.half_rounded_corners_left_transparent);
        upcomingBtnView.setTextColor(Color.parseColor("#FFFFFF"));

        adapter.notifyItemRangeRemoved(0, assignments.size());
        assignments.clear();
        assignments.addAll(Assignment.createDummyAssignments("overdue"));
        adapter.notifyItemRangeInserted(0, assignments.size());
    }
    public void upcomingClicked(View view) {
        Button overdueBtnView = findViewById(R.id.overdueButton);
        overdueBtnView.setBackgroundResource(R.drawable.half_rounded_corners_right_transparent);
        overdueBtnView.setTextColor(Color.parseColor("#FFFFFF"));
        Button upcomingBtnView = findViewById(R.id.upcomingButton);
        upcomingBtnView.setBackgroundResource(R.drawable.half_rounded_corners_left);
        upcomingBtnView.setTextColor(Color.parseColor("#000000"));

        adapter.notifyItemRangeRemoved(0, assignments.size());
        assignments.clear();
        assignments.addAll(Assignment.createDummyAssignments("upcoming"));
        adapter.notifyItemRangeInserted(0, assignments.size());
    }

    // Nav buttons
    public void goToHomepage(View view) {
        Intent intent = new Intent(this, homepage.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
    public void goToQuestspage(View view) {
        Intent intent = new Intent(this, questspage.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
    public void goToRewardspage(View view) {
        Intent intent = new Intent(this, rewardspage.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
    public void goToStatuspage(View view) {
        Intent intent = new Intent(this, statuspage.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
}
