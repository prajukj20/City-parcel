package com.example.cityparcel_listpassed_method;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MyhorizaontalistAdapter extends RecyclerView.Adapter<MyhorizaontalistAdapter.Myviewholder>{
    List<String> category;
    Context context;
    View.OnClickListener onClickListener;

    public MyhorizaontalistAdapter(Set<String> category, Context context, View.OnClickListener onClickListener) {
        this.category = new ArrayList<>(category);
        this.context = context;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public MyhorizaontalistAdapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.fragment_menuhorizontal_fragment, parent, false);
        Myviewholder holder = new Myviewholder(view1);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyhorizaontalistAdapter.Myviewholder holder, int position) {
        holder.name.setText(category.get(position));
        holder.name.setOnClickListener(onClickListener);

    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {
        TextView name;

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.pagemenuhorz);

        }
    }
}
