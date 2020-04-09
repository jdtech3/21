package io.bitbucket.team_21.app;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class statuspage extends AppCompatActivity{

    BarChart barChart;
    LineChart lineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState){
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
        setContentView(R.layout.activity_statuspage);

        lineChart = findViewById(R.id.chart2);
        barChart = findViewById(R.id.chart1);

        BarDataSet barDataSet1 = new BarDataSet(dataValues1(),"DataSet 1");
        LineDataSet lineDataSet = new LineDataSet(lineValues1(),"DataSet 1");

        BarData barData = new BarData();
        barData.addDataSet(barDataSet1);
        LineData lineData = new LineData();
        lineData.addDataSet(lineDataSet);

        barChart.setData(barData);
        barChart.invalidate();
        lineChart.setData(lineData);
        lineChart.invalidate();

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

    private ArrayList<BarEntry> dataValues1(){
        ArrayList<BarEntry> dataVals = new ArrayList<>();
        dataVals.add(new BarEntry(0,3));
        dataVals.add(new BarEntry(1,4));
        dataVals.add(new BarEntry(2,6));
        dataVals.add(new BarEntry(3,10));
        return dataVals;
    }

    private ArrayList<Entry> lineValues1(){
        ArrayList<Entry> lineVals = new ArrayList<>();
        lineVals.add(new Entry(0,3));
        lineVals.add(new Entry(1,4));
        lineVals.add(new Entry(2,6));
        lineVals.add(new Entry(3,10));
        return lineVals;
    }
}

