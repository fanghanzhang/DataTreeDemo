package com.ironghui.datatree.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ZhangFangHan on 2018/3/8.
 */

public class SharedPreferenceDB {
    private Context mcontext;
    private final SharedPreferences preferences;

    public SharedPreferenceDB(Context context) {
        this.mcontext = context;
        preferences = context.getSharedPreferences("name", 0);

    }

    public void setString(String value, String key) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(value, key);
        editor.commit();
    }

    public String getString(String value, String key) {

        return preferences.getString(value, key);
    }
}
