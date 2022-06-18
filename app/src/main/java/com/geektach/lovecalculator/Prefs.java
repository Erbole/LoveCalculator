package com.geektach.lovecalculator;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {
    private SharedPreferences preferences;

    public void saveBoard() {
        preferences.edit().putBoolean("isBoardShown", true).apply();
    }

    public boolean isBoardShown() {
        return preferences.getBoolean("isBoardShown", false);
    }

    public void setContext(Context context) {
        preferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE);
    }
}
