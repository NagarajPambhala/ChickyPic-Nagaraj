package com.infinite.chickypic.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.infinite.chickypic.R;
import com.infinite.chickypic.fragment.Fragment_PictureSource;
import com.infinite.chickypic.fragment.Fragment_Sales;
import com.infinite.chickypic.fragment.Fragment_StoreMain;

/**
 * ujwalv on 17-05-2017.
 */

public class FullScreenFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreenfragment);

        //Attempt on UNIT test here
        if(getIntent().getStringExtra("fragment")==null){
            Toast.makeText(this, "Missing argument", Toast.LENGTH_SHORT).show();
            return;
        }


        if(getIntent().getStringExtra("fragment").equalsIgnoreCase("sales")){
            Fragment_Sales fragment = new Fragment_Sales();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            Bundle bundle = new Bundle();
            fragment.setArguments(bundle);
            ft.replace(R.id.fl_fullscreen_fragment_holder, fragment);
            ft.commit();
        }else if(getIntent().getStringExtra("fragment").equalsIgnoreCase("storemain")){
            Fragment_StoreMain fragment = new Fragment_StoreMain();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("home_categories",getIntent().getParcelableArrayListExtra("home_categories"));
            bundle.putString("clicked_id",getIntent().getStringExtra("clicked_id"));
            fragment.setArguments(bundle);
            ft.replace(R.id.fl_fullscreen_fragment_holder, fragment);
            ft.commit();
        }else if(getIntent().getStringExtra("fragment").equalsIgnoreCase("pictures_source")){

            Fragment_PictureSource fragment = new Fragment_PictureSource();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            Bundle bundle = new Bundle();
            fragment.setArguments(bundle);
            ft.replace(R.id.fl_fullscreen_fragment_holder, fragment);
            ft.commit();
        }


    }
}
