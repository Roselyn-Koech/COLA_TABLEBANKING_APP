package com.colatablebankingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ContributionActivity extends AppCompatActivity {

    EditText etAmount, etDate;
    Button btnSubmit;
    DatabaseHelper db;

    // ⚠️ Replace this with your actual logged-in user email retrieval
    String userEmail = "test@gmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contribution);

        etAmount = findViewById(R.id.etAmount);
        etDate = findViewById(R.id.etDate);
        btnSubmit = findViewById(R.id.btnSubmit);
        db = new DatabaseHelper(this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = etAmount.getText().toString().trim();
                String date = etDate.getText().toString().trim();

                if (input.isEmpty() || date.isEmpty()) {
                    Toast.makeText(ContributionActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                double amount;

                try {
                    amount = Double.parseDouble(input);
                } catch (NumberFormatException e) {
                    Toast.makeText(ContributionActivity.this, "Enter a valid amount", Toast.LENGTH_SHORT).show();
                    return;
                }

                // ✅ Get userId from email
                int userId = db.getUserId(userEmail);

                if (userId == -1) {
                    Toast.makeText(ContributionActivity.this, "User not found", Toast.LENGTH_SHORT).show();
                    return;
                }

                // ✅ Call the correct method
                boolean inserted = db.addContribution(userId, amount, date);

                if (inserted) {
                    Toast.makeText(ContributionActivity.this, "Contribution recorded successfully", Toast.LENGTH_SHORT).show();
                    etAmount.setText("");
                    etDate.setText("");
                } else {
                    Toast.makeText(ContributionActivity.this, "Failed to save, please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}