package com.analytics.poc.fragments;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analytics.poc.R;
import com.analytics.poc.SingletonApp;
import com.analytics.poc.databinding.FragmentHomeBinding;
import com.analytics.poc.utils.AppPreference;
import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by Techno Blogger on 28/6/17.
 */

public class FragmentHome extends Fragment implements View.OnClickListener {

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentHomeBinding fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        View rootView = fragmentHomeBinding.getRoot();

        SingletonApp.getInstance().getActivityInstance().showFloatingButton();

        fragmentHomeBinding.txtMobileNumber.setText(getResources().getString(R.string.welcome) + AppPreference.getInstance().getPhoneNumber());

        // Setting the onClickListener on every Button
        fragmentHomeBinding.btnMarvel.setOnClickListener(this);
        fragmentHomeBinding.btnDC.setOnClickListener(this);
        fragmentHomeBinding.btnCrash.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMarvel:
                Bundle btnMarvel = new Bundle();
                btnMarvel.putString(FirebaseAnalytics.Param.ITEM_ID, "1");
                btnMarvel.putString(FirebaseAnalytics.Param.ITEM_NAME, "btnMarvel");
                btnMarvel.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "Marvel Heroes");
                SingletonApp.getFirebaseAnalytics().logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, btnMarvel);
                SingletonApp.getInstance().getFlowOrganization().replace(new FragmentMarvel(), true);
                break;
            case R.id.btnDC:
                Bundle btnDC = new Bundle();
                btnDC.putString(FirebaseAnalytics.Param.ITEM_ID, "2");
                btnDC.putString(FirebaseAnalytics.Param.ITEM_NAME, "btnDC");
                btnDC.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "DC Heroes");
                SingletonApp.getFirebaseAnalytics().logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, btnDC);
                SingletonApp.getInstance().getFlowOrganization().replace(new FragmentDC(), true);
                break;
            case R.id.btnCrash:
                // Simple Code to crash the application.
                Integer i = null;
                i.byteValue();
                break;
        }

    }
}
