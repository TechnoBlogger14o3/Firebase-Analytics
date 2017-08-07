package com.analytics.poc;

import android.app.Application;

import com.analytics.poc.activities.MainActivity;
import com.analytics.poc.utils.FlowOrganizer;
import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by Techno Blogger on 27/6/17.
 */

public class SingletonApp extends Application {
    private static SingletonApp _singletonApp;
    private static FirebaseAnalytics mFirebaseAnalytics;
    private MainActivity _mainActivity;
    private FlowOrganizer _flowOrganizer;

    public SingletonApp() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        _singletonApp = this;
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mFirebaseAnalytics.setAnalyticsCollectionEnabled(true);
    }

    public static FirebaseAnalytics getFirebaseAnalytics() {
        return mFirebaseAnalytics;
    }

    public static SingletonApp getInstance() {
        if (_singletonApp == null)
            _singletonApp = new SingletonApp();
        return _singletonApp;
    }

    public void init(MainActivity _mainActivity) {
        this._mainActivity = _mainActivity;
    }

    public FlowOrganizer getFlowOrganization() {
        if (_flowOrganizer == null)
            _flowOrganizer = new FlowOrganizer(_mainActivity, R.id.frame_parent);
        return _flowOrganizer;
    }

    public MainActivity getActivityInstance() {
        return _mainActivity;
    }

    public void onDestroy() {
        _singletonApp = null;
        _mainActivity = null;
        _flowOrganizer = null;
    }

}
