package com.infinite.chickypic.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.infinite.chickypic.R;
import com.infinite.chickypic.fragment.Fragment_StoreMain;

/**
 * ujwalv on 17-05-2017.
 */

public class FullScreenFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreenfragment);
        Fragment_StoreMain fragment = new Fragment_StoreMain();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_fullscreen_fragment_holder, fragment);
        ft.commit();
    }
}
