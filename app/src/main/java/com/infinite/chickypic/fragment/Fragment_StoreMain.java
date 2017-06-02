package com.infinite.chickypic.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.infinite.chickypic.ApplicationC;
import com.infinite.chickypic.R;
import com.infinite.chickypic.adapter.Adapter_VpStoreMain;
import com.infinite.chickypic.view.SlidingTabLayout;

import java.util.ArrayList;

/**
 * ujwalv on 26-04-2017.
 */

public class Fragment_StoreMain extends Fragment implements View.OnClickListener {

    Adapter_VpStoreMain vpStoreMainAdapter ;
    TabLayout tlStoreMain;
    ViewPager vpStoreMain;
    SlidingTabLayout slidingTabs;
    String clicked_id;
    TextView tvStoreMainTitle,tvStoreMainBack;
    ArrayList<Fragment_Home.HomeDisplayItems> items = new ArrayList<>();
    private static final String TAG = "Fragment_StoreMain";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_storemain,container,false);
        vpStoreMain = (ViewPager) view.findViewById(R.id.vpStoreMain);
        slidingTabs = (SlidingTabLayout) view.findViewById(R.id.slidingTabs);
        tvStoreMainTitle = (TextView) view.findViewById(R.id.tvStoreMainTitle);
        tvStoreMainBack = (TextView) view.findViewById(R.id.tvStoreMainBack);
        items = getArguments().getParcelableArrayList("home_categories");
        clicked_id = getArguments().getString("clicked_id");
        vpStoreMainAdapter = new Adapter_VpStoreMain(getChildFragmentManager(),items);
        vpStoreMain.setAdapter(vpStoreMainAdapter);
        tvStoreMainTitle.setTypeface(ApplicationC.getApplicationC().getFbPractica_Bold(getContext()), Typeface.BOLD);
        slidingTabs.setCustomTabColorizer(position -> 0xFFFF205C);
        slidingTabs.setDistributeEvenly(true);
        slidingTabs.setViewPager(vpStoreMain);

        for(int i=0;i<items.size();i++){
            if(clicked_id.equalsIgnoreCase(items.get(i).getId()))
                vpStoreMain.setCurrentItem(i);
        }

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        tvStoreMainBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvStoreMainBack:
                Log.d(TAG, "onClick: ");
                getActivity().onBackPressed();
                break;
        }
    }
}
