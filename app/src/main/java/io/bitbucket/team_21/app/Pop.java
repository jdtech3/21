package io.bitbucket.team_21.app;

import android.os.Bundle;
import android.util.DisplayMetrics;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Pop extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.choose_account);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.75), (int) (height * 0.5));
    }
}
