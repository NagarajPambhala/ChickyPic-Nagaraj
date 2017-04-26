package com.infinite.chickypic.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.infinite.chickypic.R;
import com.infinite.chickypic.adapter.Adapter_RvStoreMain;

/**
 * ujwalv on 26-04-2017.
 */

public class Fragment_StoreMainGrids extends Fragment{

    RecyclerView rvStoreMainGrid;
    GridLayoutManager gridLayoutManager;
    Adapter_RvStoreMain rvStoreMainAdapter ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_storemain_grids,container,false);
        rvStoreMainGrid = (RecyclerView) view.findViewById(R.id.rvStoreMainGrid);
        gridLayoutManager = new GridLayoutManager(getActivity(),2);
        rvStoreMainAdapter = new Adapter_RvStoreMain(getContext());
        rvStoreMainGrid.setLayoutManager(gridLayoutManager);
        rvStoreMainGrid.setAdapter(rvStoreMainAdapter);
        return view;
    }
}
