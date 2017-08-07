package com.analytics.poc.fragments;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analytics.poc.R;
import com.analytics.poc.databinding.FragmentInfoBinding;
import com.analytics.poc.utils.MyConstants;

/**
 * Created by Techno Blogger on 28/6/17.
 */

public class FragmentInfo extends Fragment implements View.OnClickListener {

    private FragmentInfoBinding fragmentInfoBinding;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentInfoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_info, container, false);
        View rootView = fragmentInfoBinding.getRoot();

        Bundle bundle = new Bundle();
        bundle = getArguments();
        // Marvel
        String btnSpider = bundle.getString("btnSpider");
        String btnIronMan = bundle.getString("btnIronMan");
        String btnHulk = bundle.getString("btnHulk");
        String btnDaredevil = bundle.getString("btnDaredevil");
        String btnBlackWidow = bundle.getString("btnBlackWidow");

        String btnBatMan = bundle.getString("btnBatMan");
        String btnFlash = bundle.getString("btnFlash");
        String btnGreenArrow = bundle.getString("btnGreenArrow");
        String btnWonderWoman = bundle.getString("btnWonderWoman");
        String btnSuperMan = bundle.getString("btnSuperMan");

        if (btnSpider != null)
            if (btnSpider.equalsIgnoreCase("btnSpider")) {
                fragmentInfoBinding.txtInfo.setText(MyConstants.SuperHeroInfo.M_SPIDERMAN);
                fragmentInfoBinding.txtSuperHero.setText(R.string.spider_man);
            }

        if (btnIronMan != null)
            if (btnIronMan.equalsIgnoreCase("btnIronMan")) {
                fragmentInfoBinding.txtInfo.setText(MyConstants.SuperHeroInfo.M_IRONMAN);
                fragmentInfoBinding.txtSuperHero.setText(R.string.iron_man);
            }

        if (btnHulk != null)
            if (btnHulk.equalsIgnoreCase("btnHulk")) {
                fragmentInfoBinding.txtInfo.setText(MyConstants.SuperHeroInfo.M_HULK);
                fragmentInfoBinding.txtSuperHero.setText(R.string.hulk);
            }

        if (btnDaredevil != null)
            if (btnDaredevil.equalsIgnoreCase("btnDaredevil")) {
                fragmentInfoBinding.txtInfo.setText(MyConstants.SuperHeroInfo.M_DAREDEVIL);
                fragmentInfoBinding.txtSuperHero.setText(R.string.daredevil);
            }

        if (btnBlackWidow != null)
            if (btnBlackWidow.equalsIgnoreCase("btnBlackWidow")) {
                fragmentInfoBinding.txtInfo.setText(MyConstants.SuperHeroInfo.M_BLACKWIDOW);
                fragmentInfoBinding.txtSuperHero.setText(R.string.black_widow);
            }

        if (btnBatMan != null)
            if (btnBatMan.equalsIgnoreCase("btnBatMan")) {
                fragmentInfoBinding.txtInfo.setText(MyConstants.SuperHeroInfo.D_BATMAN);
                fragmentInfoBinding.txtSuperHero.setText(R.string.batman);
            }

        if (btnFlash != null)
            if (btnFlash.equalsIgnoreCase("btnFlash")) {
                fragmentInfoBinding.txtInfo.setText(MyConstants.SuperHeroInfo.D_FLASH);
                fragmentInfoBinding.txtSuperHero.setText(R.string.flash);
            }

        if (btnGreenArrow != null)
            if (btnGreenArrow.equalsIgnoreCase("btnGreenArrow")) {
                fragmentInfoBinding.txtInfo.setText(MyConstants.SuperHeroInfo.D_GREENARROW);
                fragmentInfoBinding.txtSuperHero.setText(R.string.green_arrow);
            }

        if (btnWonderWoman != null)
            if (btnWonderWoman.equalsIgnoreCase("btnWonderWoman")) {
                fragmentInfoBinding.txtInfo.setText(MyConstants.SuperHeroInfo.D_WONDERWOMAN);
                fragmentInfoBinding.txtSuperHero.setText(R.string.wonder_woman);
            }

        if (btnSuperMan != null)
            if (btnSuperMan.equalsIgnoreCase("btnSuperMan")) {
                fragmentInfoBinding.txtInfo.setText(MyConstants.SuperHeroInfo.D_SUPERMAN);
                fragmentInfoBinding.txtSuperHero.setText(R.string.superman);
            }

        fragmentInfoBinding.imgShare.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgShare:
                String strSuperHero = fragmentInfoBinding.txtInfo.getText().toString();
                shareTheSuperHeroInfo(strSuperHero);
                break;
            default:
                break;
        }
    }

    public void shareTheSuperHeroInfo(String strMessage) {
        try {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Check this out.");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, strMessage);
            startActivity(Intent.createChooser(sharingIntent, "Share your Super Hero Information"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
