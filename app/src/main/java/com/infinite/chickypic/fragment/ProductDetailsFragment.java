package com.infinite.chickypic.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.infinite.chickypic.R;
import com.infinite.chickypic.activity.FullScreenFragmentActivity;

/**
 * ujwalv on 24-05-2017.
 */

public class ProductDetailsFragment extends Fragment implements View.OnClickListener {

    ImageView ivProductDetailsImageInfo;
    RelativeLayout rlProductDetailsImageSelect;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_productdetails,container,false);
        ivProductDetailsImageInfo = (ImageView) view.findViewById(R.id.ivProductDetailsImageInfo);
        rlProductDetailsImageSelect = (RelativeLayout) view.findViewById(R.id.rlProductDetailsImageSelect);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        ivProductDetailsImageInfo.setOnClickListener(this);
        rlProductDetailsImageSelect.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivProductDetailsImageInfo: {
                Fragment fragmentProductInfo = new ProductInfoScreen();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fl_fullscreen_fragment_holder, fragmentProductInfo, "fragment_productinfo");
                transaction.addToBackStack(null);
                transaction.commit();
            }
                break;

            case R.id.rlProductDetailsImageSelect: {
                Intent intFullScreen = new Intent(getActivity(), FullScreenFragmentActivity.class);
                intFullScreen.putExtra("fragment","pictures_source");
                startActivity(intFullScreen);
            }
                break;
        }
    }
}
