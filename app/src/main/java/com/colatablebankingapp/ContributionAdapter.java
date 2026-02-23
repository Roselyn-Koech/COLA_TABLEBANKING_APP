package com.colatablebankingapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cursoradapter.widget.CursorAdapter;

public class ContributionAdapter extends CursorAdapter {

    public ContributionAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context)
                .inflate(R.layout.item_contribution, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView amount = view.findViewById(R.id.itemAmount);
        TextView date = view.findViewById(R.id.itemDate);

        double value = cursor.getDouble(cursor.getColumnIndexOrThrow("amount"));
        String contributionDate = cursor.getString(cursor.getColumnIndexOrThrow("date"));

        amount.setText("KES " + value);
        date.setText(contributionDate);
    }
}