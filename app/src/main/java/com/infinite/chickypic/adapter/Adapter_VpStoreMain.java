package com.infinite.chickypic.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.infinite.chickypic.fragment.Fragment_Home;
import com.infinite.chickypic.fragment.Fragment_StoreMainGrids;

import java.util.ArrayList;

/**
 * ujwalv on 26-04-2017.
 */

public class Adapter_VpStoreMain extends FragmentStatePagerAdapter {

    private ArrayList<Fragment_Home.HomeDisplayItems> itemsHome = new ArrayList<>();
    public Adapter_VpStoreMain(FragmentManager fm, ArrayList<Fragment_Home.HomeDisplayItems> itemsHome) {
        super(fm);
        this.itemsHome = itemsHome;
    }

    @Override
    public Fragment getItem(int position) {
        //for(int i=0;i<itemsHome.size();i++){
            Fragment frag = new Fragment_StoreMainGrids();
            Bundle bundle = new Bundle();
            bundle.putString("featured_img",itemsHome.get(position).getFeaturedUrl());
            //TODO pass the category name here, to fetch the related data based on this
            bundle.putString("category_id",itemsHome.get(position).getFeaturedUrl());
            frag.setArguments(bundle);
            return frag;
       // }
       // return null;
    }

    @Override
    public int getCount() {
        return itemsHome.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //This will set title for the TAB
       return itemsHome.get(position).getTitle();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
