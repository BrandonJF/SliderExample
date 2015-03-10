package com.brandonjf.sliderexample;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class SliderActivity
        extends FragmentActivity
        implements SlideFragment.OnFragmentInteractionListener{
    CustomPageAdapter pageAdapter;

    public void onFragmentInteraction(Uri uri){
        Log.w("SliderExample", uri.toString());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slider_activity_layout);
        List<android.support.v4.app.Fragment> fragments = getFragments();
        pageAdapter = new CustomPageAdapter(getSupportFragmentManager(), fragments);
        ViewPager pager = (ViewPager)findViewById(R.id.viewpager);
        pager.setPageTransformer(true, new ZoomPageTransformer());
        pager.setAdapter(pageAdapter);
    }

    private List<android.support.v4.app.Fragment> getFragments(){
        List<android.support.v4.app.Fragment> fList = new ArrayList<android.support.v4.app.Fragment>();
        fList.add(SlideFragment.newInstance(1));
        fList.add(SlideFragment.newInstance(2));
        fList.add(SlideFragment.newInstance(3));
        fList.add(SlideFragment.newInstance(4));
        fList.add(SlideFragment.newInstance(5));
        return fList;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_slider, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
