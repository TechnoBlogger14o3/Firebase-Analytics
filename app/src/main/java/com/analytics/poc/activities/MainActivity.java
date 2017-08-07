package com.analytics.poc.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.analytics.poc.R;
import com.analytics.poc.SingletonApp;
import com.analytics.poc.databinding.ActivityMainBinding;
import com.analytics.poc.fragments.FragmentAuth;
import com.analytics.poc.fragments.FragmentHome;
import com.analytics.poc.utils.AppPreference;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.iid.FirebaseInstanceId;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mFirebaseAuth = FirebaseAuth.getInstance();
        FirebaseInstanceId.getInstance().getToken();
        Log.e("Token ", " is " + FirebaseInstanceId.getInstance().getToken());
        activityMainBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(getResources().getString(R.string.logout))
                        .setMessage(getResources().getString(R.string.are_you_sure))
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mFirebaseAuth.signOut();
                                AppPreference.getInstance().setIsOtpReceived(false);
                                SingletonApp.getInstance().getFlowOrganization().replace(new FragmentAuth(), false);
                                SingletonApp.getInstance().getFlowOrganization().clearBackStack();
                            }
                        }).setNegativeButton("No", null).show();
            }
        });

        SingletonApp.getInstance().init(this);

        if (AppPreference.getInstance().isOtpReceived()) {
            SingletonApp.getInstance().getFlowOrganization().add(new FragmentHome());
        } else {
            SingletonApp.getInstance().getFlowOrganization().add(new FragmentAuth());
        }
    }

    // Method to Show and Hide the Floating Button
    public void hideFloatingButton() {
        activityMainBinding.fab.setVisibility(View.GONE);
    }

    public void showFloatingButton() {
        activityMainBinding.fab.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SingletonApp.getInstance().onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
