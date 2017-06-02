package com.infinite.chickypic.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import com.infinite.chickypic.R;
import com.infinite.chickypic.fragment.Fragment_Home;
import com.infinite.chickypic.fragment.Fragment_PictureSource;
import com.infinite.chickypic.fragment.Fragment_PictureSourceGrids;
import com.infinite.chickypic.fragment.Fragment_StoreMainGrids;

import java.util.ArrayList;

/**
 * ujwalv on 26-04-2017.
 */

public class Adapter_VpPictureSource extends FragmentStatePagerAdapter {

    private ArrayList<Fragment_PictureSource.PictureSourceObj> imgItem = new ArrayList<>();
    private int[] tabIcon = {R.drawable.facebook,R.drawable.google_drive,R.drawable.instagram,R.drawable.photos};
    private Context context;
    public Adapter_VpPictureSource(FragmentManager fm,Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        //for(int i=0;i<itemsHome.size();i++){
            Fragment frag = new Fragment_PictureSourceGrids();
            Bundle bundle = new Bundle();
            //bundle.putString("featured_img",itemsHome.get(position).getFeaturedUrl());
            //TODO pass the category name here, to fetch the related data based on this
            //bundle.putString("category_id",itemsHome.get(position).getFeaturedUrl());
            frag.setArguments(bundle);
            return frag;
       // }
       // return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //This will set title for the TAB
        Drawable drawable = context.getResources().getDrawable(tabIcon[position]);
        drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
        SpannableString ss = new SpannableString(" ");
        ImageSpan imageSpan = new ImageSpan(drawable,ImageSpan.ALIGN_BOTTOM);
        ss.setSpan(imageSpan,0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
       return ss;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
