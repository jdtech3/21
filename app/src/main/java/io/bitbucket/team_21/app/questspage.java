package io.bitbucket.team_21.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import io.bitbucket.team_21.app.recycler.Assignment;
import io.bitbucket.team_21.app.recycler.AssignmentsAdapter;

public class questspage extends AppCompatActivity {
    protected void initRecycler(Context context) {
        // Define
        RecyclerView assignmentRecycler = (RecyclerView) findViewById(R.id.assignmentRecycler);
        LinearLayoutManager assignmentRecyclerLLM = (LinearLayoutManager) new LinearLayoutManager(context);
        ArrayList assignments = Assignment.createDummyAssignments();
        AssignmentsAdapter adapter = new AssignmentsAdapter(assignments);

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


}
