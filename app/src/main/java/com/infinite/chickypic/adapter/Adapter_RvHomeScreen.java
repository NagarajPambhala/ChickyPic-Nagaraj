package com.infinite.chickypic.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.infinite.chickypic.R;
import com.infinite.chickypic.fragment.Fragment_Home;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * ujwalv on 13-04-2017.
 */

public class Adapter_RvHomeScreen extends RecyclerView.Adapter<Adapter_RvHomeScreen.Viewholder>{

    private Context context;
    private PublishSubject<PublishObject> publishSubject = PublishSubject.create();
    private List<Fragment_Home.HomeDisplayItems> itemsHome = new ArrayList<>();

    public Adapter_RvHomeScreen(Context context, List<Fragment_Home.HomeDisplayItems> itemsHome) {
        this.itemsHome = itemsHome;
        this.context = context;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_mainscreen,parent,false);
        context = parent.getContext();
        Typeface custom_font = Typeface.createFromAsset(context.getAssets(),  "fonts/fbpractica_light.otf");
        final Viewholder holder = new Viewholder(v);
        holder.tvTitle.setTypeface(custom_font,Typeface.BOLD);
        holder.tvName.setTypeface(custom_font,Typeface.BOLD);
        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(final Viewholder holder, int position) {
        holder.tvName.setText(itemsHome.get(holder.getAdapterPosition()).getDescription());
        holder.tvTitle.setText(itemsHome.get(holder.getAdapterPosition()).getTitle());
        Picasso.with(context).load(itemsHome.get(holder.getAdapterPosition()).getMainUrl()).placeholder(R.drawable.test).into(holder.ivHomeMainImage);
        holder.cvHomeScreenItem.setOnClickListener(v -> {
            PublishObject po = new PublishObject();
            po.setId(itemsHome.get(holder.getAdapterPosition()).getId());
            publishSubject.onNext(po);
        });
    }

    @Override
    public int getItemCount() {
        return itemsHome.size();
    }

    public Observable<PublishObject> getClickPosition(){
        return publishSubject.asObservable();
    }

    static class Viewholder extends RecyclerView.ViewHolder{
        TextView tvName,tvTitle;
        ImageView ivHomeMainImage;
        CardView cvHomeScreenItem;

        Viewholder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvHomeScreenDesc);
            tvTitle = (TextView) itemView.findViewById(R.id.tvHomeTitle);
            ivHomeMainImage = (ImageView) itemView.findViewById(R.id.ivHomeMainImage);
            cvHomeScreenItem = (CardView) itemView.findViewById(R.id.cvHomeScreenItem);


        }
    }

    public class PublishObject {
        String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
