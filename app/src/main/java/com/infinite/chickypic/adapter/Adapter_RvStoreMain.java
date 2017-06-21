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

public class Adapter_RvStoreMain extends RecyclerView.Adapter<Adapter_RvStoreMain.Viewholder> {

    private Context context;
    private PublishSubject<StoreProductDetails> publishSubject = PublishSubject.create();
    public Adapter_RvStoreMain(Context context){
        this.context = context;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_storemain,parent,false);
        context = parent.getContext();
        final Viewholder holder = new Viewholder(v);
        holder.tvStoreMainPrice.setTypeface(ApplicationC.getApplicationC().getFbPractica_Light(context), Typeface.BOLD);
        holder.tvStoreMainPriceSmall.setTypeface(ApplicationC.getApplicationC().getFbPractica_Light(context), Typeface.BOLD);
        holder.tvStoreMainProductName.setTypeface(ApplicationC.getApplicationC().getFbPractica_Light(context), Typeface.BOLD);
        return new Adapter_RvStoreMain.Viewholder(v);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        /**
         * Basically there r three types of texts
         */
        if(position==2 || position ==1){
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
        }


        holder.cvStoreProduct.setOnClickListener(v -> publishSubject.onNext(new StoreProductDetails()));

    }

    @Override
    public int getItemCount() {
        return 21;
    }

    public Observable<StoreProductDetails> getClickPosition() {
        return publishSubject.asObservable();
    }

    static class Viewholder extends RecyclerView.ViewHolder{
        TextView tvStoreMainProductName,tvStoreMainPrice,tvStoreMainPriceSmall;
        ImageView ivProfileBg;
        CardView cvStoreProduct;

        Viewholder(View itemView) {
            super(itemView);
            tvStoreMainProductName = (TextView) itemView.findViewById(R.id.tvStoreMainProductName);
            tvStoreMainPrice = (TextView) itemView.findViewById(R.id.tvStoreMainPrice);
            tvStoreMainPriceSmall = (TextView) itemView.findViewById(R.id.tvStoreMainPriceSmall);
            cvStoreProduct = (CardView) itemView.findViewById(R.id.cvStoreProduct);
            //tvPrice = (TextView) itemView.findViewById(R.id.tvName);
            //ivProfileBg = (ImageView) itemView.findViewById(R.id.ivProfileBg);
            //rlHomeScreenItem = (RelativeLayout) itemView.findViewById(R.id.rlHomeScreenItem);
        }
    }

    public class StoreProductDetails {
    }
}
