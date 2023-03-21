package com.example.cityparcel_listpassed_method;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cityparcel_listpassed_method.model.Photosclass;

import java.util.List;

public class MyreviewAdapter extends RecyclerView.Adapter<MyreviewAdapter.Myviewholder> {
    List<reviewlist> list;
    Context context;

    public MyreviewAdapter(List<reviewlist> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyreviewAdapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.review,parent,false);
        MyreviewAdapter.Myviewholder holder = new MyreviewAdapter.Myviewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyreviewAdapter.Myviewholder holder, int position) {
        Glide.with(context).load(list.get(position).getImage()).into(holder.image);
        holder.Name.setText((list.get(position).getName()));
        holder.Comment.setText((list.get(position).getName()));
        holder.date.setText((list.get(position).getDate()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView Name,Comment,date;
        RatingBar reviewaverage;
        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.profilepic);
            Name = itemView.findViewById(R.id.profilename);
            Comment = itemView.findViewById(R.id.comment);
            date = itemView.findViewById(R.id.date);
            reviewaverage = itemView.findViewById(R.id.starrating);

        }
    }
}
