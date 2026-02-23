package com.colatablebankingapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class A extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a); // references the XML layout

        // Optional: interact with a view in the layout
        TextView textView = findViewById(R.id.textViewA);
        textView.setText("Welcome to Activity A!");
    }
}