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
import com.analytics.poc.databinding.FragmentMarvelBinding;
import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by Techno Blogger on 28/6/17.
 */

public class FragmentMarvel extends Fragment implements View.OnClickListener {

    Bundle btnSpider = new Bundle();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentMarvelBinding fragmentMarvelBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_marvel, container, false);
        View rootView = fragmentMarvelBinding.getRoot();

        fragmentMarvelBinding.btnSpider.setOnClickListener(this);
        fragmentMarvelBinding.btnIronMan.setOnClickListener(this);
        fragmentMarvelBinding.btnHulk.setOnClickListener(this);
        fragmentMarvelBinding.btnDaredevil.setOnClickListener(this);
        fragmentMarvelBinding.btnBlackWidow.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSpider:
                btnSpider.putString(FirebaseAnalytics.Param.ITEM_ID, "1");
                btnSpider.putString(FirebaseAnalytics.Param.ITEM_NAME, "btnSpider");
                btnSpider.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "SpiderMan");
                SingletonApp.getFirebaseAnalytics().logEvent("marvel_heroes", btnSpider);
                btnSpider.putString("btnSpider", "btnSpider");
                showDialog(btnSpider);
                break;
            case R.id.btnIronMan:
                Bundle btnIronMan = new Bundle();
                btnIronMan.putString(FirebaseAnalytics.Param.ITEM_ID, "2");
                btnIronMan.putString(FirebaseAnalytics.Param.ITEM_NAME, "btnIronMan");
                btnIronMan.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "Iron man");
                SingletonApp.getFirebaseAnalytics().logEvent("marvel_heroes", btnIronMan);
                btnIronMan.putString("btnIronMan", "btnIronMan");
                showDialog(btnIronMan);
                break;
            case R.id.btnHulk:
                Bundle btnHulk = new Bundle();
                btnHulk.putString(FirebaseAnalytics.Param.ITEM_ID, "3");
                btnHulk.putString(FirebaseAnalytics.Param.ITEM_NAME, "btnHulk");
                btnHulk.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "Hulk");
                SingletonApp.getFirebaseAnalytics().logEvent("marvel_heroes", btnHulk);
                btnHulk.putString("btnHulk", "btnHulk");
                showDialog(btnHulk);
                break;
            case R.id.btnDaredevil:
                Bundle btnDaredevil = new Bundle();
                btnDaredevil.putString(FirebaseAnalytics.Param.ITEM_ID, "4");
                btnDaredevil.putString(FirebaseAnalytics.Param.ITEM_NAME, "btnDaredevil");
                btnDaredevil.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "Dare Devil");
                SingletonApp.getFirebaseAnalytics().logEvent("marvel_heroes", btnDaredevil);
                btnDaredevil.putString("btnDaredevil", "btnDaredevil");
                showDialog(btnDaredevil);
                break;
            case R.id.btnBlackWidow:
                Bundle btnBlackWidow = new Bundle();
                btnBlackWidow.putString(FirebaseAnalytics.Param.ITEM_ID, "5");
                btnBlackWidow.putString(FirebaseAnalytics.Param.ITEM_NAME, "btnBlackWidow");
                btnBlackWidow.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "Black Widow");
                SingletonApp.getFirebaseAnalytics().logEvent("marvel_heroes", btnBlackWidow);
                btnBlackWidow.putString("btnBlackWidow", "btnBlackWidow");
                showDialog(btnBlackWidow);
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
