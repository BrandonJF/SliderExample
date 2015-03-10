package com.brandonjf.sliderexample;

import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by brandon on 3/8/15.
 */
public class CustomPageAdapter extends FragmentPagerAdapter{
    private List<android.support.v4.app.Fragment> fragments;

    public CustomPageAdapter(android.support.v4.app.FragmentManager fm, List<android.support.v4.app.Fragment> fragments){
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position){
        return this.fragments.get(position);
    }

    @Override
    public int getCount(){
        return this.fragments.size();
    }
}
