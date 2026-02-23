package com.colatablebankingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecentActivityAdapter extends RecyclerView.Adapter<RecentActivityAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String> names;
    private ArrayList<String> amounts;
    private ArrayList<String> paymentMethods;
    private ArrayList<String> dates;

    public RecentActivityAdapter(Context context, ArrayList<String> names, ArrayList<String> amounts,
                                 ArrayList<String> paymentMethods, ArrayList<String> dates) {
        this.context = context;
        this.names = names;
        this.amounts = amounts;
        this.paymentMethods = paymentMethods;
        this.dates = dates;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recent_activity, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(names.get(position));
        holder.tvAmount.setText(amounts.get(position));
        holder.tvPaymentMethod.setText(paymentMethods.get(position));
        holder.tvDate.setText(dates.get(position));
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAmount, tvPaymentMethod, tvDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvMemberName);
            tvAmount = itemView.findViewById(R.id.tvAmount);
            tvPaymentMethod = itemView.findViewById(R.id.tvPaymentMethod);
            tvDate = itemView.findViewById(R.id.tvDate);
        }
    }
}