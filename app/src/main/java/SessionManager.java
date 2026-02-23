package com.colatablebankingapp;

import android.content.*;

public class SessionManager {

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private Context context;

    public SessionManager(Context context) {
        this.context = context;
        sp = context.getSharedPreferences("LoginSession", Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public void createLoginSession(String email) {
        editor.putBoolean("isLoggedIn", true);
        editor.putString("email", email);
        editor.apply();
    }

    public boolean isLoggedIn() {
        return sp.getBoolean("isLoggedIn", false);
    }

    public String getUserEmail() {
        return sp.getString("email", null);
    }

    public void logout() {
        editor.clear();
        editor.apply();
    }
}