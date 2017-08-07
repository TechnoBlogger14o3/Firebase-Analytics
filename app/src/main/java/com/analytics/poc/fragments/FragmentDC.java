package com.analytics.poc.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.analytics.poc.R;
import com.analytics.poc.SingletonApp;
import com.analytics.poc.databinding.FragmentDcBinding;
import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by Techno Blogger on 28/6/17.
 */

public class FragmentDC extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentDcBinding fragmentDcBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_dc, container, false);
        View rootView = fragmentDcBinding.getRoot();

        fragmentDcBinding.btnBatMan.setOnClickListener(this);
        fragmentDcBinding.btnFlash.setOnClickListener(this);
        fragmentDcBinding.btnGreenArrow.setOnClickListener(this);
        fragmentDcBinding.btnWonderWoman.setOnClickListener(this);
        fragmentDcBinding.btnSuperMan.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBatMan:
                Bundle btnBatMan = new Bundle();
                btnBatMan.putString(FirebaseAnalytics.Param.ITEM_ID, "1");
                btnBatMan.putString(FirebaseAnalytics.Param.ITEM_NAME, "btnBatMan");
                btnBatMan.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "BatMan");
                SingletonApp.getFirebaseAnalytics().logEvent("dc_heroes", btnBatMan);
                btnBatMan.putString("btnBatMan", "btnBatMan");
                showDialog(btnBatMan);
                break;
            case R.id.btnFlash:
                Bundle btnFlash = new Bundle();
                btnFlash.putString(FirebaseAnalytics.Param.ITEM_ID, "2");
                btnFlash.putString(FirebaseAnalytics.Param.ITEM_NAME, "btnFlash");
                btnFlash.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "Flash");
                SingletonApp.getFirebaseAnalytics().logEvent("dc_heroes", btnFlash);
                btnFlash.putString("btnFlash", "btnFlash");
                showDialog(btnFlash);
                break;
            case R.id.btnGreenArrow:
                Bundle btnGreenArrow = new Bundle();
                btnGreenArrow.putString(FirebaseAnalytics.Param.ITEM_ID, "3");
                btnGreenArrow.putString(FirebaseAnalytics.Param.ITEM_NAME, "btnGreenArrow");
                btnGreenArrow.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "Green Arrow");
                SingletonApp.getFirebaseAnalytics().logEvent("dc_heroes", btnGreenArrow);
                btnGreenArrow.putString("btnGreenArrow", "btnGreenArrow");
                showDialog(btnGreenArrow);
                break;
            case R.id.btnWonderWoman:
                Bundle btnWonderWoman = new Bundle();
                btnWonderWoman.putString(FirebaseAnalytics.Param.ITEM_ID, "4");
                btnWonderWoman.putString(FirebaseAnalytics.Param.ITEM_NAME, "btnWonderWoman");
                btnWonderWoman.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "Wonder Woman");
                SingletonApp.getFirebaseAnalytics().logEvent("dc_heroes", btnWonderWoman);
                btnWonderWoman.putString("btnWonderWoman", "btnWonderWoman");
                showDialog(btnWonderWoman);
                break;
            case R.id.btnSuperMan:
                Bundle btnSuperMan = new Bundle();
                btnSuperMan.putString(FirebaseAnalytics.Param.ITEM_ID, "5");
                btnSuperMan.putString(FirebaseAnalytics.Param.ITEM_NAME, "btnSuperMan");
                btnSuperMan.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "SuperMan");
                SingletonApp.getFirebaseAnalytics().logEvent("dc_heroes", btnSuperMan);
                btnSuperMan.putString("btnSuperMan", "btnSuperMan");
                showDialog(btnSuperMan);
                break;
            default:
                break;
        }
    }

    public void showDialog(final Bundle bundle) {

        new AlertDialog.Builder(SingletonApp.getInstance().getActivityInstance())
                .setTitle("SuperHero")
                .setMessage("Choose your option")
                .setPositiveButton("Info", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SingletonApp.getInstance().getFlowOrganization().replace(new FragmentInfo(), bundle, true);
                    }
                })
                .setNegativeButton("WallPaper", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(SingletonApp.getInstance().getActivityInstance(), "We will use Firebase Storage to show the wallpaper", Toast.LENGTH_LONG).show();
                    }
                }).show();

    }

}
