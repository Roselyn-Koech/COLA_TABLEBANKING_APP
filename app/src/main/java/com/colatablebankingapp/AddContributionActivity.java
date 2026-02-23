package com.colatablebankingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddContributionActivity extends AppCompatActivity {

    private EditText etAmount, etDescription;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contribution);

        // Link UI elements
        etAmount = findViewById(R.id.etAmount);
        etDescription = findViewById(R.id.etDescription);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Handle button click
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount = etAmount.getText().toString().trim();
                String description = etDescription.getText().toString().trim();

                if (amount.isEmpty() || description.isEmpty()) {
                    Toast.makeText(AddContributionActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // TODO: Add your logic to save contribution
                    Toast.makeText(AddContributionActivity.this, "Contribution Added!", Toast.LENGTH_SHORT).show();
                    finish(); // go back to DashboardActivity
                }
            }
        });
    }
}