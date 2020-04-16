package io.bitbucket.team_21.app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.graphics.Color;


import java.util.ArrayList;
import java.util.List;
import android.widget.Button;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class homepage extends AppCompatActivity {
    private Button homeButoon;
    private Button questButoon;
    private Button rewardsButoon;
    private Button statusButoon;
    PieChartView pieChartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Get decorView so we can make changes to it
        final View decorView = getWindow().getDecorView();
        homeButoon = (Button) findViewById(R.id.homeButton);
        homeButoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });
        questButoon = (Button) findViewById(R.id.questButton);
        questButoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuest();
            }
        });
        rewardsButoon = (Button) findViewById(R.id.rewardsButton);
        rewardsButoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRewards();
            }
        });
        statusButoon = (Button) findViewById(R.id.statusButton);
        statusButoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStatus();
            }
        });
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
        setContentView(R.layout.activity_homepage);

        pieChartView = findViewById(R.id.chart);

        List pieData = new ArrayList<>();
        pieData.add(new SliceValue(28, Color.parseColor("#648BFF")));
        pieData.add(new SliceValue(11, Color.parseColor("#FFDD66")));
        pieData.add(new SliceValue(2, Color.parseColor("#FF7664")));
        pieData.add(new SliceValue(2, Color.parseColor("#A1A1A1")));

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasCenterCircle(true).setCenterText1("Total Assignments").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#000000"));
        pieChartView.setPieChartData(pieChartData);
    }

    public  void openHome() {
        Intent home;
        home = new Intent(this, homepage.class);
        startActivity(home);
    }
    public  void openQuest() {
        Intent quest = new Intent(this, questspage.class);
        startActivity(quest);
    }
    public  void openRewards() {
        Intent rewards = new Intent(this, rewardspage.class);
        startActivity(rewards);
    }
    public  void openStatus() {
        Intent status = new Intent(this, statuspage.class);
        startActivity(status);
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
