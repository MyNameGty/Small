package com.jiyun.mvp_wb.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class OneAdapter extends FragmentStatePagerAdapter {
    ArrayList<String> list;
    private ArrayList<Fragment>list_fra;

    public OneAdapter(FragmentManager fm, ArrayList<String> list, ArrayList<Fragment> list_fra) {
        super(fm);
        this.list = list;
        this.list_fra = list_fra;
    }

    @Override
    public Fragment getItem(int i) {
        return list_fra.get(i);
    }

    @Override
    public int getCount() {
        return list_fra.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
