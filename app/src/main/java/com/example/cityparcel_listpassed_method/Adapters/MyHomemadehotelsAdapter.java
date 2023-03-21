package com.example.cityparcel_listpassed_method.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cityparcel_listpassed_method.model.Homemadehotels;
import com.example.cityparcel_listpassed_method.R;

import java.util.List;

public class MyHomemadehotelsAdapter extends RecyclerView.Adapter<MyHomemadehotelsAdapter.Myviewholder> {
    List<Homemadehotels> list4;
    Context context;

    public MyHomemadehotelsAdapter(List<Homemadehotels> list4, Context context) {
        this.list4 = list4;
        Log.e("TAG", String.valueOf(list4.size()));
        this.context = context;
    }


    @NonNull
    @Override
    public MyHomemadehotelsAdapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pagerliststart,parent,false);
        MyHomemadehotelsAdapter.Myviewholder holder = new MyHomemadehotelsAdapter.Myviewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHomemadehotelsAdapter.Myviewholder holder, int position) {
        Glide.with(context).load(list4.get(position).getImage()).into(holder.image);
//        holder.image.setImageResource(list4.get(position).getImage());
        holder.Name.setText((list4.get(position).getName()));
        holder.Prize.setText((list4.get(position).getName()));
        holder.Description.setText((list4.get(position).getDescription()));

    }

    @Override
    public int getItemCount() {
        return list4.size();
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
