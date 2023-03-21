package com.example.cityparcel_listpassed_method;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyaboutAdapter extends RecyclerView.Adapter<MyaboutAdapter.Myviewholder>{
    List<aboutlist> list;
    Context context;

    public MyaboutAdapter(List<aboutlist> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyaboutAdapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.aboutlistxml,parent,false);
        MyaboutAdapter.Myviewholder holder = new MyaboutAdapter.Myviewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyaboutAdapter.Myviewholder holder, int position) {
        holder.Name.setText((list.get(position).getCusine()));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder{
        TextView Name;

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.checkboxidname);


        }
    }
}
