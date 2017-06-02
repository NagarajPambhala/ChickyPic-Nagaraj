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
import android.widget.Toast;

import com.infinite.chickypic.ApplicationC;
import com.infinite.chickypic.R;
import com.infinite.chickypic.adapter.Adapter_VpStoreMain;
import com.infinite.chickypic.http.HttpConstants;
import com.infinite.chickypic.httpPojos.HomeCategoryListPojo;
import com.infinite.chickypic.view.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * ujwalv on 26-04-2017.
 */

public class Fragment_Sales extends Fragment implements View.OnClickListener,HttpConstants.CategoriesListCallback {

    Adapter_VpStoreMain vpStoreMainAdapter ;
    TabLayout tlStoreMain;
    SlidingTabLayout slidingTabs;
    String clicked_id;
    ViewPager vpStoreMain;
    TextView tvStoreMainTitle,tvStoreMainBack;
    ArrayList<Fragment_Home.HomeDisplayItems> itemsHome = new ArrayList<>();
    private static final String TAG = "Fragment_StoreMain";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_storemain,container,false);
        vpStoreMain = (ViewPager) view.findViewById(R.id.vpStoreMain);
        slidingTabs = (SlidingTabLayout) view.findViewById(R.id.slidingTabs);
        tvStoreMainTitle = (TextView) view.findViewById(R.id.tvStoreMainTitle);
        tvStoreMainBack = (TextView) view.findViewById(R.id.tvStoreMainBack);
        //items = getArguments().getParcelableArrayList("home_categories");
        //clicked_id = getArguments().getString("clicked_id");
        vpStoreMainAdapter = new Adapter_VpStoreMain(getChildFragmentManager(),itemsHome);
        vpStoreMain.setAdapter(vpStoreMainAdapter);
        tvStoreMainTitle.setTypeface(ApplicationC.getApplicationC().getFbPractica_Bold(getContext()), Typeface.BOLD);
        slidingTabs.setCustomTabColorizer(position -> 0xFFFF205C);
        slidingTabs.setDistributeEvenly(true);
        slidingTabs.setViewPager(vpStoreMain);

        HttpConstants.getInstance().categoriesList(this,"title",0,"id",400);
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

    @Override
    public void CategoriesList(HomeCategoryListPojo bannersPojo) {
        List<HomeCategoryListPojo.Datum> items = bannersPojo.getData();
        List<HomeCategoryListPojo.Included> included = bannersPojo.getIncluded();
        if(items!=null && items.size()>0){
            for(int i=0;i<items.size();i++){
                Fragment_Home.HomeDisplayItems homeObj = new Fragment_Home.HomeDisplayItems(items.get(i).getId(),items.get(i).getAttributes().getDescription(),items.get(i).getAttributes().getTitle());

                //TODO it will be nice if we can avoid this loop all together by changing server response
                for(int j=0;j<included.size();j++){
                    if(included.get(j).getId().equalsIgnoreCase(items.get(i).getRelationships().getFeaturedImage().getData().getId())){
                        homeObj.setFeaturedUrl(included.get(j).getAttributes().getFilename());
                    }
                    if(included.get(j).getId().equalsIgnoreCase(items.get(i).getRelationships().getMainImage().getData().getId())){
                        homeObj.setMainUrl(included.get(j).getAttributes().getFilename());
                    }
                }
                itemsHome.add(homeObj);
            }
            vpStoreMainAdapter.notifyDataSetChanged();
            slidingTabs.setViewPager(vpStoreMain);
        }else{
            Toast.makeText(getActivity(), "Empty response for Home screen category", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void CategoriesList(String string) {

    }
}
