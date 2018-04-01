package com.example.android.labbaikatiovani_1202152330_modul6.Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Labbaika Putri on 4/1/2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int mNumOfTabs) {
        super(fm);
        this.mNumOfTabs = mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new PostsFragment();
            case 1:
                return new MyPostsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}