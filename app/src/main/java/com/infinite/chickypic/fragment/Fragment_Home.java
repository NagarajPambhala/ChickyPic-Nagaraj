package com.infinite.chickypic.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.infinite.chickypic.R;
import com.infinite.chickypic.activity.FullScreenFragmentActivity;
import com.infinite.chickypic.adapter.Adapter_RvHomeScreen;
import com.infinite.chickypic.http.BannersPojo;
import com.infinite.chickypic.http.HttpConstants;
import com.infinite.chickypic.httpPojos.HomeCategoryListPojo;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import rx.Observable;
import rx.Observer;

/**
 * ujwalv on 26-04-2017.
 */

public class Fragment_Home extends Fragment implements ViewPager.OnPageChangeListener,HttpConstants.BannersListCallback,HttpConstants.CategoriesListCallback{

    ViewPager vpHomeSCreen;
    CirclePageIndicator indicator;
    RecyclerView rvHomeScreen;
    LinearLayoutManager linearLayoutManager;
    Adapter_RvHomeScreen adapterRvHomeScreen;
    Adapter_VpHomeScreen adapterVpHomeScreen;
    RelativeLayout rlVpHomeScreenHolder;
    Timer timer;
    int page = 0;
    BannersPojo bannerObject;
    private ArrayList<HomeDisplayItems> itemsHome = new ArrayList<>();
    private static final String TAG = "Fragment_Home";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        vpHomeSCreen = (ViewPager) view.findViewById(R.id.vpHomeScreen);
        rlVpHomeScreenHolder = (RelativeLayout) view.findViewById(R.id.rlVpHomeScreenHolder);
        indicator = (CirclePageIndicator) view.findViewById(R.id.vpIndicatorMainScreen);
        adapterVpHomeScreen = new Adapter_VpHomeScreen(getChildFragmentManager());
        vpHomeSCreen.setAdapter(adapterVpHomeScreen);
        indicator.setViewPager(vpHomeSCreen);
        pageSwitcher(3);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        rvHomeScreen = (RecyclerView) view.findViewById(R.id.rvHomeScreen);
        //rlVpHomeScreenHolder.requestFocus();

        adapterRvHomeScreen = new Adapter_RvHomeScreen(getActivity(),itemsHome);
        rvHomeScreen.setLayoutManager(linearLayoutManager);
        rvHomeScreen.setAdapter(adapterRvHomeScreen);
        rvHomeScreen.setNestedScrollingEnabled(false);
        final float density = getResources().getDisplayMetrics().density;
        indicator.setRadius(6 * density);
        indicator.setPageColor(0xFFFFFFFF);
        indicator.setFillColor(0xFFFD2154);
        indicator.setStrokeWidth(0);
        HttpConstants.getInstance().bannersList(Fragment_Home.this,"title",0,"id",400);
        HttpConstants.getInstance().categoriesList(Fragment_Home.this,"title",0,"id",400);

        Observable<Adapter_RvHomeScreen.PublishObject> observer = adapterRvHomeScreen.getClickPosition();
        observer.subscribe(new Observer<Adapter_RvHomeScreen.PublishObject>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Adapter_RvHomeScreen.PublishObject publishObject) {
                Intent intent = new Intent(getActivity(), FullScreenFragmentActivity.class);
                intent.putExtra("fragment","storemain");
                intent.putExtra("clicked_id",publishObject.getId());
                intent.putParcelableArrayListExtra("home_categories",itemsHome);
                startActivity(intent);
            }
        });

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.grey_light));
        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        vpHomeSCreen.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        page = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void BannersList(BannersPojo bannersPojo) {
        if(bannersPojo!=null){
            bannerObject = bannersPojo;
        }
        adapterVpHomeScreen.notifyDataSetChanged();
    }

    @Override
    public void BannersList(String string) {

    }

    @Override
    public void CategoriesList(HomeCategoryListPojo bannersPojo) {
        List<HomeCategoryListPojo.Datum> items = bannersPojo.getData();
        List<HomeCategoryListPojo.Included> included = bannersPojo.getIncluded();
        if(items!=null && items.size()>0){
            for(int i=0;i<items.size();i++){
                HomeDisplayItems homeObj = new HomeDisplayItems(items.get(i).getId(),items.get(i).getAttributes().getDescription(),items.get(i).getAttributes().getTitle());

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
            adapterRvHomeScreen.notifyDataSetChanged();
        }else{
            Toast.makeText(getActivity(), "Empty response for Home screen category", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void CategoriesList(String string) {

    }

    private class Adapter_VpHomeScreen extends FragmentStatePagerAdapter {

        Adapter_VpHomeScreen(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragBanner = new Fragment_HomeScreenBanner();
            Bundle bund = new Bundle();
            if (bannerObject != null) {
                bund.putString(getString(R.string.key_imgurl), bannerObject.getIncluded().get(position).getAttributes().getFilename());
            }
            fragBanner.setArguments(bund);
            return fragBanner;
        }

        @Override
        public int getCount() {
            if(bannerObject==null){
                return 0;
            }
            if(bannerObject.getIncluded().size()<=5) {
                return bannerObject.getIncluded().size();
            }else{
                return 5;
            }
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
    }

    public void pageSwitcher(int seconds) {
        timer = new Timer(); // At this line a new Thread will be created
        timer.scheduleAtFixedRate(new RemindTask(), 0, seconds * 1000);
    }

    // this is an inner class...
    private class RemindTask extends TimerTask {

        @Override
        public void run() {

            // As the TimerTask run on a seprate thread from UI thread we have
            // to call runOnUiThread to do work on UI thread.
            if(getActivity()!=null) {
                getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        if (page > 4) { // In my case the number of pages are 5
                            //timer.cancel();
                            page = 0;
                            vpHomeSCreen.setCurrentItem(page);
                            // Showing a toast for just testing purpose
                            //Toast.makeText(getApplicationContext(), "Timer stoped",Toast.LENGTH_LONG).show();
                        } else {
                            vpHomeSCreen.setCurrentItem(page++);
                        }
                    }
                });
            }

        }
    }

    /*public class HomeDisplayItems {
        String name,title, mainUrl,featuredUrl;

        public HomeDisplayItems(String name,String title){
            this.name = name;
            this.title = title;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMainUrl() {
            return mainUrl;
        }

        public void setMainUrl(String mainUrl) {
            this.mainUrl = mainUrl;
        }

        public String getFeaturedUrl() {
            return featuredUrl;
        }

        public void setFeaturedUrl(String featuredUrl) {
            this.featuredUrl = featuredUrl;
        }
    }*/

    public static class HomeDisplayItems implements Parcelable {
        String id;
        String description;
        String title;
        String mainUrl;
        String featuredUrl;

        HomeDisplayItems(String id,String description, String title){
            this.id = id;
            this.description = description;
            this.title = title;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMainUrl() {
            return mainUrl;
        }

        void setMainUrl(String mainUrl) {
            this.mainUrl = mainUrl;
        }

        public String getFeaturedUrl() {
            return featuredUrl;
        }

        void setFeaturedUrl(String featuredUrl) {
            this.featuredUrl = featuredUrl;
        }

        HomeDisplayItems(Parcel in) {
            id = in.readString();
            description = in.readString();
            title = in.readString();
            mainUrl = in.readString();
            featuredUrl = in.readString();
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(description);
            dest.writeString(title);
            dest.writeString(mainUrl);
            dest.writeString(featuredUrl);
        }

        @SuppressWarnings("unused")
        public static final Parcelable.Creator<HomeDisplayItems> CREATOR = new Parcelable.Creator<HomeDisplayItems>() {
            @Override
            public HomeDisplayItems createFromParcel(Parcel in) {
                return new HomeDisplayItems(in);
            }

            @Override
            public HomeDisplayItems[] newArray(int size) {
                return new HomeDisplayItems[size];
            }
        };
    }

}
