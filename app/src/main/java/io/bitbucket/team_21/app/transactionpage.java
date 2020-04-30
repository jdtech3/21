package io.bitbucket.team_21.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class transactionpage extends AppCompatActivity {

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
        setContentView(R.layout.activity_transactionpage);
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
