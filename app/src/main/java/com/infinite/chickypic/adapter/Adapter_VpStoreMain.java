package com.infinite.chickypic.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.infinite.chickypic.fragment.Fragment_StoreMainGrids;

/**
 * ujwalv on 26-04-2017.
 */

public class Adapter_VpStoreMain extends FragmentStatePagerAdapter {

    public Adapter_VpStoreMain(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = new Fragment_StoreMainGrids();
        return frag;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "תיקון";
            case 1:
                return "תיקון";
            case 2:
                return "תיקון";
            case 3:
                return "תיקון";
            case 4:
                return "תיקון";
        }
        return "";
    }
}
