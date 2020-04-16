package io.bitbucket.team_21.app;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class rewardspage extends AppCompatActivity {
    // Nav buttons
    public void goToHomepage(View view) {
        Intent intent = new Intent(this, homepage.class);
        startActivity(intent);
    }
    public void goToQuestspage(View view) {
        Intent intent = new Intent(this, questspage.class);
        startActivity(intent);
    }
    public void goToRewardspage(View view) {
        Intent intent = new Intent(this, rewardspage.class);
        startActivity(intent);
    }
    public void goToStatuspage(View view) {
        Intent intent = new Intent(this, statuspage.class);
        startActivity(intent);
    }
}
