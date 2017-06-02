package com.infinite.chickypic.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.infinite.chickypic.ApplicationC;
import com.infinite.chickypic.R;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * ujwalv on 26-04-2017.
 */

public class Adapter_RvPictureSource extends RecyclerView.Adapter<Adapter_RvPictureSource.Viewholder> {

    private Context context;
    private PublishSubject<PictureDetails> publishSubject = PublishSubject.create();
    public Adapter_RvPictureSource(Context context){
        this.context = context;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_picturesource,parent,false);
        context = parent.getContext();
        final Viewholder holder = new Viewholder(v);
        /*holder.cvPicture.setTypeface(ApplicationC.getApplicationC().getFbPractica_Light(context), Typeface.BOLD);
        holder.tvStoreMainPriceSmall.setTypeface(ApplicationC.getApplicationC().getFbPractica_Light(context), Typeface.BOLD);
        holder.tvStoreMainProductName.setTypeface(ApplicationC.getApplicationC().getFbPractica_Light(context), Typeface.BOLD);*/
        return new Adapter_RvPictureSource.Viewholder(v);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {

        /*if(position==2 || position ==1){
            holder.tvStoreMainPrice.setText("₪ 23");
            holder.tvStoreMainPrice.setTextColor(Color.RED);
            holder.tvStoreMainPriceSmall.setVisibility(View.VISIBLE);
        }else if(position==3 || position==4 ||position==5){
            holder.tvStoreMainPrice.setText("₪ 23");
            holder.tvStoreMainPrice.setTextColor(context.getResources().getColor(R.color.grey_text));
            holder.tvStoreMainPriceSmall.setVisibility(View.GONE);
        }else{
            holder.tvStoreMainPriceSmall.setVisibility(View.GONE);
            holder.tvStoreMainPrice.setTextColor(context.getResources().getColor(R.color.grey_text));
            holder.tvStoreMainPrice.setText("תיקון דים - 23 ₪");
        }*/


        holder.cvPicture.setOnClickListener(v -> publishSubject.onNext(new PictureDetails()));

    }

    @Override
    public int getItemCount() {
        return 21;
    }

    public Observable<PictureDetails> getClickPosition() {
        return publishSubject.asObservable();
    }

    static class Viewholder extends RecyclerView.ViewHolder{
        //TextView tvStoreMainProductName,tvStoreMainPrice,tvStoreMainPriceSmall;
        ImageView ivPicSelector,ivPic;
        CardView cvPicture;

        Viewholder(View itemView) {
            super(itemView);
            /*tvStoreMainProductName = (TextView) itemView.findViewById(R.id.tvStoreMainProductName);
            tvStoreMainPrice = (TextView) itemView.findViewById(R.id.tvStoreMainPrice);
            tvStoreMainPriceSmall = (TextView) itemView.findViewById(R.id.tvStoreMainPriceSmall);*/
            cvPicture = (CardView) itemView.findViewById(R.id.cvPicture);
            ivPicSelector = (ImageView) itemView.findViewById(R.id.ivPicSelector);
            ivPic = (ImageView) itemView.findViewById(R.id.ivPic);
            //rlHomeScreenItem = (RelativeLayout) itemView.findViewById(R.id.rlHomeScreenItem);
        }
    }

    public class PictureDetails {
    }
}
