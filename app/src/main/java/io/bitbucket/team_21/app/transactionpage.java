package io.bitbucket.team_21.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class transactionpage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
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
        TextView points = (TextView) findViewById(R.id.pointsValue);
        variables v = (variables) getApplication();
        points.setText(Integer.toString(v.getData()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.points, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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
    public void makePurchase(View view) {
        variables v = (variables) getApplication();
        if (v.getData() > 1000) {
            v.setData(v.getData() - 1000);
            Intent intent = new Intent(this, rewardspage.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        } else {
            Button buyButton = (Button)findViewById(R.id.buyButton);
            buyButton.setText("Insufficient Points");
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String reet = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), reet, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
