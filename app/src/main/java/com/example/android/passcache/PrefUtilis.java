package com.example.android.passcache;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.content.Context;
import java.util.List;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import android.util.Log;

/**
 * Created by Chris on 2016-02-27.
 */
public class PrefUtilis {
    public static final String PREFS_LOGIN_PASSWORD_KEY = "__PASSWORD__" ;
    public static final String PREFS_LOGIN_SECURITY_KEY = "__SECURITY__" ;
    public static final String PREFS_LOGIN_QUESTION_KEY = "__QUESTION__" ;
    public static final String PREFS_LOGIN_FIRST_TIME_KEY = "__FIRST__" ;
    public static final String PREFS_CIRCLE_KEY = "__CIRCLELIST__" ;

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
     * Saving the Circle objects
     * @param context
     * @param key
     * @param circleList
     */
    public static void saveToPrefs2(Context context, String key, List<Circle> circleList) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        final SharedPreferences.Editor editor = prefs.edit();

        Gson gson = new Gson();
        String jsonCircles = gson.toJson(circleList);
        Log.d("TAG","jsonCircles = " + jsonCircles);
        editor.putString(key, jsonCircles);
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

    /**
     * Retrieve the list of circles
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static List<Circle> getFromPrefs2(Context context, String key, List<Circle> defaultValue) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);

        try {
            String jsonCircles = sharedPrefs.getString(key, "wtf");
            Type type = new TypeToken<List<Circle>>(){}.getType();
            Gson gson = new Gson();
            List<Circle> resultList = gson.fromJson(jsonCircles, type);
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }
}
