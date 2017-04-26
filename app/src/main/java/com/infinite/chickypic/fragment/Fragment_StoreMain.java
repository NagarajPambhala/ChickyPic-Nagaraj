package com.infinite.chickypic.fragment;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infinite.chickypic.R;
import com.infinite.chickypic.adapter.Adapter_VpStoreMain;
import com.infinite.chickypic.view.SlidingTabLayout;

/**
 * ujwalv on 26-04-2017.
 */

public class Fragment_StoreMain extends Fragment {

    Adapter_VpStoreMain vpStoreMainAdapter ;
    TabLayout tlStoreMain;
    SlidingTabLayout slidingTabs;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_storemain,container,false);
        ViewPager vpStoreMain = (ViewPager) view.findViewById(R.id.vpStoreMain);
        slidingTabs = (SlidingTabLayout) view.findViewById(R.id.slidingTabs);
        vpStoreMainAdapter = new Adapter_VpStoreMain(getChildFragmentManager());
        vpStoreMain.setAdapter(vpStoreMainAdapter);
        slidingTabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return 0xFFFF205C;
            }


        });
        slidingTabs.setDistributeEvenly(true);
        slidingTabs.setViewPager(vpStoreMain);
        /*tlStoreMain = (TabLayout) view.findViewById(R.id.tlStoreMain);
        tlStoreMain.setupWithViewPager(vpStoreMain);*/
        /*final ActionBar actionBar = getActivity().getActionBar();

        // Specify that tabs should be displayed in the action bar.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create a tab listener that is called when the user changes tabs.
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

            }
        };

        // Add 3 tabs, specifying the tab's text and TabListener
        for (int i = 0; i < 3; i++) {
            actionBar.addTab(
                    actionBar.newTab()
                            .setText("Tab " + (i + 1))
                            .setTabListener(tabListener));
        }*/

        return view;
    }
}
