package com.lcworld.shopdemo.tsq.ui.main.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class TabVideoAdapter extends FragmentPagerAdapter {


    private ArrayList<String> tabArr;
    private ArrayList<Fragment> fragmentList;

    public TabVideoAdapter(FragmentManager fm, ArrayList<Fragment> fragmentList, ArrayList<String> tabArr) {
        super(fm);
        this.tabArr = tabArr;
        this.fragmentList = fragmentList;
    }

    public void setTabArr(ArrayList<String> tabArr) {
        this.tabArr = tabArr;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }


    @Override
    public int getCount() {
        return tabArr.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabArr.get(position);
    }
}
