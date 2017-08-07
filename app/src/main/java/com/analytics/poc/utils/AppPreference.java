package com.analytics.poc.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.analytics.poc.SingletonApp;

public class AppPreference implements MyConstants.PrefrenceKeys {
    private static AppPreference prefrence;
    private SharedPreferences _prefrence;

    public static AppPreference getInstance() {
        if (SingletonApp.getInstance().getActivityInstance() == null)
            return null;
        if (prefrence == null)
            prefrence = new AppPreference(SingletonApp.getInstance().getActivityInstance());
        return prefrence;
    }

    private AppPreference(Context context) {
        _prefrence = PreferenceManager.getDefaultSharedPreferences(context);
    }

    // For OTP
    public void setIsOtpReceived(boolean isLogin) {
        if (_prefrence != null) {
            _prefrence.edit().putBoolean(PREF_IS_OTP_RECEIVED, isLogin).apply();
        }
    }

    public boolean isOtpReceived() {
        return _prefrence != null && _prefrence.getBoolean(PREF_IS_OTP_RECEIVED, false);
    }

    // For Phone Number
    public void setPhoneNumber(String phoneNumber) {
        if (_prefrence != null) {
            _prefrence.edit().putString(PREF_SET_PHONE, phoneNumber).apply();
        }
    }

    public String getPhoneNumber() {
        if (_prefrence != null)
            return _prefrence.getString(PREF_SET_PHONE, null);
        return null;
    }


}