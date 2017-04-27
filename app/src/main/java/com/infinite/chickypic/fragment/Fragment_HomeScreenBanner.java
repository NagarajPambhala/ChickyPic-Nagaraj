package com.infinite.chickypic.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.infinite.chickypic.R;
import com.squareup.picasso.Picasso;

/**
 * ujwalv on 13-04-2017.
 */

public class Fragment_HomeScreenBanner extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mainscreen_vp,container,false);
        ImageView ivHomeScreen = (ImageView) v.findViewById(R.id.ivHomeScreen);

        String url_banner = getArguments().getString(getString(R.string.key_imgurl));
        Picasso.with(getContext()).load(url_banner).into(ivHomeScreen);

        return v;
    }
}
