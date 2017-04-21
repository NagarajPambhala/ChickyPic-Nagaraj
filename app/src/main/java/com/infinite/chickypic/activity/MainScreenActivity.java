package com.infinite.chickypic.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.infinite.chickypic.R;
import com.infinite.chickypic.adapter.Adapter_RvMainScreen;
import com.infinite.chickypic.fragment.Fragment_MainScreenViewPager;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.Timer;
import java.util.TimerTask;

/**
 * ujwalv on 13-04-2017.
 */

public class MainScreenActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    ViewPager vpMainSCreen;
    CirclePageIndicator indicator;
    RecyclerView rvMainSCreen;
    LinearLayoutManager linearLayoutManager;
    Adapter_RvMainScreen adapterRvMainScreen;
    Adapter_VpMainScreen adapterVpMainScreen;
    RelativeLayout rlVpMainScreenHolder;
    int selectedPage = 0;
    Timer timer;
    int page = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        vpMainSCreen = (ViewPager) findViewById(R.id.vpMainScreen);
        rlVpMainScreenHolder = (RelativeLayout) findViewById(R.id.rlVpMainScreenHolder);
        indicator = (CirclePageIndicator) findViewById(R.id.vpIndicatorMainScreen);
        adapterVpMainScreen = new Adapter_VpMainScreen(getSupportFragmentManager());
        vpMainSCreen.setAdapter(adapterVpMainScreen);
        indicator.setViewPager(vpMainSCreen);
        pageSwitcher(3);
        linearLayoutManager = new LinearLayoutManager(MainScreenActivity.this);
        rvMainSCreen = (RecyclerView) findViewById(R.id.rvMainScreen);
        //rlVpMainScreenHolder.requestFocus();

        adapterRvMainScreen = new Adapter_RvMainScreen(MainScreenActivity.this);
        rvMainSCreen.setLayoutManager(linearLayoutManager);
        rvMainSCreen.setAdapter(adapterRvMainScreen);
        rvMainSCreen.setNestedScrollingEnabled(false);
        final float density = getResources().getDisplayMetrics().density;
        indicator.setRadius(4 * density);
        indicator.setPageColor(0xFFFFFFFF);
        indicator.setFillColor(0xFFFD2154);
        //indicator.setStrokeColor(0xFFffd32e);
        //indicator.setStrokeWidth(1 * density);
    }

    @Override
    protected void onStart() {
        super.onStart();
        vpMainSCreen.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        page = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private class Adapter_VpMainScreen extends FragmentPagerAdapter{

        Adapter_VpMainScreen(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new Fragment_MainScreenViewPager();
        }

        @Override
        public int getCount() {
            return 5;
        }
    }

    public void pageSwitcher(int seconds) {
        timer = new Timer(); // At this line a new Thread will be created
        timer.scheduleAtFixedRate(new RemindTask(), 0, seconds * 1000); // delay
        // in
        // milliseconds
    }

    // this is an inner class...
    class RemindTask extends TimerTask {

        @Override
        public void run() {

            // As the TimerTask run on a seprate thread from UI thread we have
            // to call runOnUiThread to do work on UI thread.
            runOnUiThread(new Runnable() {
                public void run() {

                    if (page > 4) { // In my case the number of pages are 5
                        //timer.cancel();
                        page=0;
                        vpMainSCreen.setCurrentItem(page);
                        // Showing a toast for just testing purpose
                        //Toast.makeText(getApplicationContext(), "Timer stoped",Toast.LENGTH_LONG).show();
                    } else {
                        vpMainSCreen.setCurrentItem(page++);
                    }
                }
            });

        }
    }
}
