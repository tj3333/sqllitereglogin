package com.example.santoshyadav.sqllitereglogin.Service;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class SharedPref {

    private static final String PREFERENCE_NAME = "TREKING";
    private static final String KEY_APP_VERSION = "AppVersion";
    private static final String KEY_LOGIN_STATUS = "Login_user";
    private static final String KEY_LOGIN_NAME = "Login_name";
    private static final String KEY_LOGIN_EMAIL = "Login_email";
    private static final String KEY_LOGIN_PHONE_NUMBER = "Login_user";

    static SharedPreferences sharedPreferences;
    public static final int KEY_DEFAULT = 0;

    public static void setLoginStatus(Context context, int status) {
        sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_LOGIN_STATUS, status);
        editor.apply();
        editor.commit();
    }

    public static int getLoginStatus(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Activity.MODE_PRIVATE);
        return sharedPreferences.getInt(KEY_LOGIN_STATUS, 0);
    }

    //LOGIN NAME
    public static void setKeyLoginName(Context context, String status) {
        sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_LOGIN_NAME,status );
        editor.apply();
        editor.commit();
    }

    public static String getKeyLoginName(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Activity.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_LOGIN_NAME, "");
    }

    //LOGIN EMAIL
    public static void setKeyLoginEmail(Context context, String status) {
        sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_LOGIN_EMAIL, status);
        editor.apply();
        editor.commit();
    }

    public static String getKeyLoginEmail(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Activity.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_LOGIN_EMAIL, "");
    }

    //LOGIN MOBILE NUMBER
    public static void setKeyLoginPhoneNumber(Context context, String status) {
        sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_LOGIN_PHONE_NUMBER, status);
        editor.apply();
        editor.commit();
    }

    public static String getKeyLoginPhoneNumber(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Activity.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_LOGIN_PHONE_NUMBER, "");
    }

    public void clearSharedPreference(Context context) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;
        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();
        editor.clear();
        editor.commit();

    }

}