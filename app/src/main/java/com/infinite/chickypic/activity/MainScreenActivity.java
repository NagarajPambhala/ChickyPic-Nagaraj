package com.infinite.chickypic.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.infinite.chickypic.R;
import com.infinite.chickypic.adapter.Adapter_RvMainScreen;
import com.infinite.chickypic.fragment.Fragment_Home;
import com.infinite.chickypic.fragment.Fragment_MainScreenViewPager;
import com.infinite.chickypic.fragment.Fragment_StoreMain;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.Timer;
import java.util.TimerTask;

/**
 * ujwalv on 13-04-2017.
 */

public class MainScreenActivity extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout rlBusiness,rlContactUs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        rlBusiness = (RelativeLayout) findViewById(R.id.rlBusiness);
        rlContactUs = (RelativeLayout) findViewById(R.id.rlContactUs);
        Fragment_Home fragment = new Fragment_Home();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_fragment_holder, fragment);
        ft.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        rlBusiness.setOnClickListener(this);
        rlContactUs.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rlContactUs: {
                Fragment_Home fragment = new Fragment_Home();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fl_fragment_holder, fragment);
                ft.commit();
            }
                break;
            case R.id.rlBusiness: {
                Fragment_StoreMain fragment = new Fragment_StoreMain();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fl_fragment_holder, fragment);
                ft.commit();
            }
                break;
        }
    }
}
