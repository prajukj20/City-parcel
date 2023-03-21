package com.example.cityparcel_listpassed_method.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cityparcel_listpassed_method.Fragment.gift;
import com.example.cityparcel_listpassed_method.R;

import java.util.List;

public class MyfarmfoodAdpter extends RecyclerView.Adapter<MyfarmfoodAdpter.Myviewholder> {
    List<gift> list5;
    Context context;

    public MyfarmfoodAdpter(List<gift> list5, Context context) {
        this.list5 = list5;
        this.context = context;
    }

    @NonNull
    @Override
    public MyfarmfoodAdpter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pagerliststart,parent,false);
        MyfarmfoodAdpter.Myviewholder holder = new MyfarmfoodAdpter.Myviewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyfarmfoodAdpter.Myviewholder holder, int position) {
        Glide.with(context).load(list5.get(position).getImage()).into(holder.image);

//        holder.image.setImageResource(list5.get(position).getImage());
        holder.Name.setText(list5.get(position).getName());
        holder.Prize.setText(list5.get(position).getPrize());
        holder.Description.setText(list5.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return list5.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView Name,Prize,Description;


        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.dishimage1);
            Name =  itemView.findViewById(R.id.dishnametiffin);
            Prize =  itemView.findViewById(R.id.prize);
            Description =  itemView.findViewById(R.id.hotelname1);

        }
    }
}
