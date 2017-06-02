package com.infinite.chickypic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.infinite.chickypic.R;
import com.infinite.chickypic.fragment.Fragment_Home;
import com.infinite.chickypic.fragment.Fragment_Sales;

/**
 * ujwalv on 13-04-2017.
 */

public class MainScreenActivity extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout rlSales, rlHome;
    private static final String TAG = "MainScreenActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        rlSales = (RelativeLayout) findViewById(R.id.rlSales);
        rlHome = (RelativeLayout) findViewById(R.id.rlHome);
        Fragment_Home fragment = new Fragment_Home();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_fragment_holder, fragment,"home_fragment");
        ft.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //rlBusiness.setOnClickListener(this);
        rlSales.setOnClickListener(this);
        rlHome.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rlHome: {
                Fragment fragment = getSupportFragmentManager().findFragmentByTag("home_fragment");
                if(fragment==null){fragment = new Fragment_Home();}
                if(fragment.isVisible()){
                    Log.i(TAG, "onClick: fragment visible,so click disabled");
                    return;
                }
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fl_fragment_holder, fragment,"home_fragment");
                ft.commit();
            }
                break;
            case R.id.rlSales: {
                Intent intent = new Intent(MainScreenActivity.this, FullScreenFragmentActivity.class);
                intent.putExtra("fragment","sales");
                intent.putExtra("clicked_id",-1);
                intent.putParcelableArrayListExtra("home_categories",null);
                startActivity(intent);
            }
                break;
        }
    }

}
