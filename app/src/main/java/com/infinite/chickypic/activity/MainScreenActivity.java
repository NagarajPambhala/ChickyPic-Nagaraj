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

import com.infinite.chickypic.R;
import com.infinite.chickypic.adapter.Adapter_RvMainScreen;
import com.infinite.chickypic.fragment.Fragment_MainScreenViewPager;
import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.TitlePageIndicator;

/**
 * ujwalv on 13-04-2017.
 */

public class MainScreenActivity extends AppCompatActivity{

    ViewPager vpMainSCreen;
    CirclePageIndicator indicator;
    RecyclerView rvMainSCreen;
    LinearLayoutManager linearLayoutManager;
    Adapter_RvMainScreen adapterRvMainScreen;
    Adapter_VpMainScreen adapterVpMainScreen;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        vpMainSCreen = (ViewPager) findViewById(R.id.vpMainScreen);
        indicator = (CirclePageIndicator) findViewById(R.id.vpIndicatorMainScreen);
        adapterVpMainScreen = new Adapter_VpMainScreen(getSupportFragmentManager());
        vpMainSCreen.setAdapter(adapterVpMainScreen);
        indicator.setViewPager(vpMainSCreen);
        linearLayoutManager = new LinearLayoutManager(MainScreenActivity.this);
        rvMainSCreen = (RecyclerView) findViewById(R.id.rvMainScreen);
        adapterRvMainScreen = new Adapter_RvMainScreen(MainScreenActivity.this);
        rvMainSCreen.setLayoutManager(linearLayoutManager);
        rvMainSCreen.setAdapter(adapterRvMainScreen);
        rvMainSCreen.setNestedScrollingEnabled(false);
        final float density = getResources().getDisplayMetrics().density;
        indicator.setRadius(6 * density);
        indicator.setPageColor(0xFFFFFFFF);
        indicator.setFillColor(0xFFffd32e);
        indicator.setStrokeColor(0xFFffd32e);
        indicator.setStrokeWidth(1 * density);

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
}
