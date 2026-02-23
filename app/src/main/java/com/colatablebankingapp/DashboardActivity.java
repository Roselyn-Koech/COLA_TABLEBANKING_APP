package com.colatablebankingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class DashboardActivity extends AppCompatActivity {

    private MaterialButton btnAddContribution;
    private MaterialButton btnViewReports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize buttons
        btnAddContribution = findViewById(R.id.btnAddContribution);
        btnViewReports = findViewById(R.id.btnViewReports);

        // Button click listeners
        btnAddContribution.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, AddContributionActivity.class);
            startActivity(intent);
        });

        btnViewReports.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, ReportsActivity.class);
            startActivity(intent);
        });
    }
}