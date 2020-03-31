package io.bitbucket.team_21.app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class statuspage extends AppCompatActivity {

    BarChart barChart = (BarChart) findViewById(R.id.chart1);

    Integer[] dataObjects;

    ArrayList<BarEntry> entries = new ArrayList<>();

}
