package io.bitbucket.team_21.app;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class statuspage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //creating the color light blue
    int lightblue = Color.parseColor("#648BFF");

    //creating the x values
    final String[] classes = new String[]{"ENG","MATH","SCI","SS","ICT","GOA"};
    //formatting values
    ValueFormatter formatter = new ValueFormatter() {
        @Override
        public String getAxisLabel(float value, AxisBase axis){
            return classes[(int) value];
        }
    };

    //creating the x values
    final String[] months = new String[]{"","","","","","",""};
    //formatting values
    ValueFormatter formatter1 = new ValueFormatter() {
        @Override
        public String getAxisLabel(float value, AxisBase axis){
            return months[(int) value];
        }
    };


    //defining variables
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

        //sets the page this is interacting with
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statuspage);

        //spinner
        Spinner spinner = findViewById(R.id.termSelectorSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.termselector, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        //finding the charts
        lineChart = findViewById(R.id.chart2);
        barChart = findViewById(R.id.chart1);

        //data sets
        BarDataSet barDataSet1 = new BarDataSet(dataValues1(),"Classes");

        LineDataSet lineDataSet = new LineDataSet(lineValues1(),"DataSet 1");



        //connecting the dots
        BarData barData = new BarData();
        barData.addDataSet(barDataSet1);

        LineData lineData = new LineData();
        lineData.addDataSet(lineDataSet);

        //refreshing the chart so the values are correct
        barChart.setData(barData);
        barChart.invalidate();
        lineChart.setData(lineData);
        lineChart.invalidate();

        //customizing values in the X Axis
        XAxis xAxis = barChart.getXAxis();
        xAxis.setLabelRotationAngle(0);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(11);
        xAxis.setTextColor(Color.DKGRAY);
        xAxis.setDrawGridLines(false);
        //setting the x axis values
        xAxis.setValueFormatter(formatter);
        //changes the minimum distance between values to 1
        xAxis.setGranularity(1f);

        //customizing values in the X Axis
        XAxis lineX = lineChart.getXAxis();
        lineX.setLabelRotationAngle(0);
        lineX.setPosition(XAxis.XAxisPosition.BOTTOM);
        lineX.setTextSize(11);
        lineX.setTextColor(Color.DKGRAY);
        lineX.setDrawGridLines(false);
        //setting the x axis values
        lineX.setValueFormatter(formatter1);
        //changes the minimum distance between values to 1
        lineX.setGranularity(1f);

        //customizing gridlines for barchart
        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setDrawGridLines(false);
        leftAxis.setDrawZeroLine(true);
        leftAxis.setDrawLabels(true);
        barChart.getAxisRight().setEnabled(false);
        leftAxis.setTextSize(11f);

        //customizing gridlines for linechart
        YAxis lineLeft = lineChart.getAxisLeft();
        lineLeft.setDrawGridLines(false);
        lineLeft.setDrawZeroLine(true);
        lineLeft.setDrawLabels(true);
        lineChart.getAxisRight().setEnabled(false);
        lineLeft.setTextSize(11f);
        lineLeft.setAxisMinimum(0f);


        //makes it so that the values will not extend the chart area
        barChart.setFitBars(true);
        //sets width of bar values
        barData.setBarWidth(0.5f);
        //sets text size on top of bars
        barDataSet1.setValueTextSize(11f);
        //removing the description text at the bottom right of the charts
        barChart.getDescription().setEnabled(false);
        //makes it so the bars won't light up when you tap on them
        barDataSet1.setHighlightEnabled(false);
        //disables zooming
        barChart.setScaleEnabled(false);
        barDataSet1.setColor(lightblue);


        //copy of above code, but for linechart
        //removing the description text at the bottom right of the charts
        lineChart.setFitsSystemWindows(true);
        lineChart.getDescription().setEnabled(false);
        //makes it so the bars won't light up when you tap on them
        lineDataSet.setHighlightEnabled(false);
        //disables zooming
        lineChart.setScaleEnabled(false);
        //sets color
        lineDataSet.setColor(lightblue);
        //sets text size above the chart
        lineDataSet.setValueTextSize(0f);
        lineDataSet.setDrawFilled(true);
        lineDataSet.setCircleColor(Color.BLACK);
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

    //adding values to the bar chart
    private ArrayList<BarEntry> dataValues1(){
        ArrayList<BarEntry> dataVals = new ArrayList<>();
        dataVals.add(new BarEntry(0,15));
        dataVals.add(new BarEntry(1,12));
        dataVals.add(new BarEntry(2,5));
        dataVals.add(new BarEntry(3,16));
        dataVals.add(new BarEntry(4,9));
        dataVals.add(new BarEntry(5,15));
        return dataVals;
    }


    //adding values to the linechart
    private ArrayList<Entry> lineValues1(){
        ArrayList<Entry> lineVals = new ArrayList<>();
        lineVals.add(new BarEntry(1,0));
        lineVals.add(new BarEntry(2,10));
        lineVals.add(new BarEntry(3,8));
        lineVals.add(new BarEntry(4,9));
        lineVals.add(new BarEntry(5,3));
        lineVals.add(new BarEntry(6,0));
        return lineVals;
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

