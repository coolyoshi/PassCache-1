package com.example.android.passcache;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.content.Context;

/**
 * Created by Chris on 2016-02-27.
 */
public class PrefUtilis {
    public static final String PREFS_LOGIN_PASSWORD_KEY = "__PASSWORD__" ;
    public static final String PREFS_LOGIN_SECURITY_KEY = "__SECURITY__" ;
    public static final String PREFS_LOGIN_QUESTION_KEY = "__QUESTION__" ;
    public static final String PREFS_LOGIN_FIRST_TIME_KEY = "__FIRST__" ;

    /**
     * Called to save supplied value in shared preferences against given key.
     * @param context Context of caller activity
     * @param key Key of value to save against
     * @param value Value to save
     */
    public static void saveToPrefs(Context context, String key, String value) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        final SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key,value);
        editor.commit();
    }

    /**
     * Called to retrieve required value from shared preferences, identified by given key.
     * Default value will be returned of no value found or error occurred.
     * @param context Context of caller activity
     * @param key Key to find value against
     * @param defaultValue Value to return if no data found against given key
     * @return Return the value found against given key, default if not found or any error occurs
     */
    public static String getFromPrefs(Context context, String key, String defaultValue) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            return sharedPrefs.getString(key, defaultValue);
        } catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }
}
