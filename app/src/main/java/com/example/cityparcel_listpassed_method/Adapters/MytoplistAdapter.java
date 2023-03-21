package com.example.cityparcel_listpassed_method.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityparcel_listpassed_method.R;
import com.example.cityparcel_listpassed_method.model.toplist;

import java.util.List;

public class MytoplistAdapter extends RecyclerView.Adapter<MytoplistAdapter.MyviewHolder> {
List<toplist>list;
Context context;

    public MytoplistAdapter(List<toplist> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MytoplistAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listpage,parent,false);
        MyviewHolder holder =new MyviewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MytoplistAdapter.MyviewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.image.setImageDrawable(context.getResources().getDrawable(list.get(position).getImage()));;

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView image;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.foodname);
            image = itemView.findViewById(R.id.foodimage1);

        }
    }
}


