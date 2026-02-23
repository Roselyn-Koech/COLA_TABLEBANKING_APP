package com.colatablebankingapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class ReportsActivity extends AppCompatActivity {

    private BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        barChart = findViewById(R.id.barChart);
        setupChart();
    }

    private void setupChart() {
        // 1️⃣ Example data
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(1f, 5000f));
        entries.add(new BarEntry(2f, 7000f));
        entries.add(new BarEntry(3f, 6500f));
        entries.add(new BarEntry(4f, 8000f));

        // 2️⃣ Create DataSet
        BarDataSet dataSet = new BarDataSet(entries, "Monthly Contributions");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setValueTextSize(12f);

        // 3️⃣ Create BarData
        BarData data = new BarData(dataSet);
        barChart.setData(data);

        // 4️⃣ Chart settings (all in Java)
        barChart.getDescription().setEnabled(false);  // disable description
        Legend legend = barChart.getLegend();
        legend.setEnabled(true);                     // show legend
        barChart.animateY(1000);
        barChart.invalidate();                       // refresh chart
    }
}