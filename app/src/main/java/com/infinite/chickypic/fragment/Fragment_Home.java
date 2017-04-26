package com.infinite.chickypic.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.infinite.chickypic.R;
import com.infinite.chickypic.adapter.Adapter_RvMainScreen;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.Timer;
import java.util.TimerTask;

/**
 * ujwalv on 26-04-2017.
 */

public class Fragment_Home extends Fragment implements ViewPager.OnPageChangeListener{

    ViewPager vpMainSCreen;
    CirclePageIndicator indicator;
    RecyclerView rvMainSCreen;
    LinearLayoutManager linearLayoutManager;
    Adapter_RvMainScreen adapterRvMainScreen;
    Adapter_VpMainScreen adapterVpMainScreen;
    RelativeLayout rlVpMainScreenHolder;
    Timer timer;
    int page = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        vpMainSCreen = (ViewPager) view.findViewById(R.id.vpMainScreen);
        rlVpMainScreenHolder = (RelativeLayout) view.findViewById(R.id.rlVpMainScreenHolder);
        indicator = (CirclePageIndicator) view.findViewById(R.id.vpIndicatorMainScreen);
        adapterVpMainScreen = new Adapter_VpMainScreen(getChildFragmentManager());
        vpMainSCreen.setAdapter(adapterVpMainScreen);
        indicator.setViewPager(vpMainSCreen);
        pageSwitcher(3);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        rvMainSCreen = (RecyclerView) view.findViewById(R.id.rvMainScreen);
        //rlVpMainScreenHolder.requestFocus();

        adapterRvMainScreen = new Adapter_RvMainScreen(getActivity());
        rvMainSCreen.setLayoutManager(linearLayoutManager);
        rvMainSCreen.setAdapter(adapterRvMainScreen);
        rvMainSCreen.setNestedScrollingEnabled(false);
        final float density = getResources().getDisplayMetrics().density;
        indicator.setRadius(6 * density);
        indicator.setPageColor(0xFFFFFFFF);
        indicator.setFillColor(0xFFFD2154);
        indicator.setStrokeWidth(0);
        //indicator.setStrokeColor(0xFFffd32e);

        return view;
    }

    @Override
    public void onStart() {
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

    private class Adapter_VpMainScreen extends FragmentPagerAdapter {

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
        timer.scheduleAtFixedRate(new RemindTask(), 0, seconds * 1000);
    }

    // this is an inner class...
    private class RemindTask extends TimerTask {

        @Override
        public void run() {

            // As the TimerTask run on a seprate thread from UI thread we have
            // to call runOnUiThread to do work on UI thread.
            if(getActivity()!=null) {
                getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        if (page > 4) { // In my case the number of pages are 5
                            //timer.cancel();
                            page = 0;
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
}
