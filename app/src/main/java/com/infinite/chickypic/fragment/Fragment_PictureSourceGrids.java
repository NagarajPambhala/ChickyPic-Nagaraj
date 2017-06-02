package com.infinite.chickypic.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.infinite.chickypic.R;
import com.infinite.chickypic.adapter.Adapter_RvPictureSource;
import com.infinite.chickypic.adapter.Adapter_RvStoreMain;
import com.squareup.picasso.Picasso;

import rx.Observable;
import rx.Observer;

/**
 * ujwalv on 26-04-2017.
 */

public class Fragment_PictureSourceGrids extends Fragment{

    RecyclerView rvStoreMainGrid;
    GridLayoutManager gridLayoutManager;
    Adapter_RvPictureSource adapterRvPictureSource ;
    ImageView ivStoreMainFeaturedImage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_picturesource_grids,container,false);
        rvStoreMainGrid = (RecyclerView) view.findViewById(R.id.rvStoreMainGrid);
        ivStoreMainFeaturedImage = (ImageView) view.findViewById(R.id.ivStoreMainFeaturedImage);
        gridLayoutManager = new GridLayoutManager(getActivity(),3);
        adapterRvPictureSource = new Adapter_RvPictureSource(getContext());
        rvStoreMainGrid.setLayoutManager(gridLayoutManager);
        rvStoreMainGrid.setAdapter(adapterRvPictureSource);
        //Picasso.with(getContext()).load(getArguments().getString("featured_img")).into(ivStoreMainFeaturedImage);

        /*Observable<Adapter_RvStoreMain.StoreProductDetails> observer = adapterRvPictureSource.getClickPosition();
        observer.subscribe(new Observer<Adapter_RvStoreMain.StoreProductDetails>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Adapter_RvStoreMain.StoreProductDetails publishObject) {
                Fragment fragment = new ProductDetailsFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.addToBackStack(null);
                transaction.replace(R.id.fl_fullscreen_fragment_holder,fragment,"tag_productdetails");
                transaction.commit();
            }
        });*/

        return view;
    }
}
