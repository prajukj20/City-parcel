package com.example.cityparcel_listpassed_method;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cityparcel_listpassed_method.model.Photosclass;

import java.util.List;

public class MyphotoAdapter extends RecyclerView.Adapter<MyphotoAdapter.Myviewholder> {
List<Photosclass>list;
Context context;

    public MyphotoAdapter(List<Photosclass> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyphotoAdapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.returantlist_2ndrecycler,parent,false);
        Myviewholder holder = new Myviewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyphotoAdapter.Myviewholder holder, int position) {
        Glide.with(context).load(list.get(position).getImageURl()).into(holder.imageview);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {
        ImageView imageview;

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            imageview =itemView.findViewById(R.id.dishimage1);

        }
    }
}
