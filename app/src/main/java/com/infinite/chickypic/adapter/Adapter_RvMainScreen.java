package com.infinite.chickypic.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.infinite.chickypic.R;

/**
 * ujwalv on 13-04-2017.
 */

public class Adapter_RvMainScreen extends RecyclerView.Adapter{

    Context context;
    public Adapter_RvMainScreen(Context context){
        this.context = context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_mainscreen_row,parent,false);
        context = parent.getContext();
        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    private static class Viewholder extends RecyclerView.ViewHolder{
        TextView tvName;
        ImageView ivProfileBg;
        RelativeLayout rlMainScreenRvItems;

        Viewholder(View itemView) {
            super(itemView);
            //tvName = (TextView) itemView.findViewById(R.id.tvName);
            //ivProfileBg = (ImageView) itemView.findViewById(R.id.ivProfileBg);
            //rlMainScreenRvItems = (RelativeLayout) itemView.findViewById(R.id.rlMainScreenRvItems);
        }
    }
}
