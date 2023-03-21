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
import com.example.cityparcel_listpassed_method.R;
import com.example.cityparcel_listpassed_method.model.restorant;

import java.util.List;

public class MyrestorantAdapter extends RecyclerView.Adapter<MyrestorantAdapter.Myviewholder> {
    List<restorant>list2;
    Context context;

    public MyrestorantAdapter(List<restorant> list2, Context context) {
        this.list2 = list2;
        this.context = context;
    }

    @NonNull
    @Override
    public MyrestorantAdapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.returantlist_2ndrecycler,parent,false);
        MyrestorantAdapter.Myviewholder holder = new MyrestorantAdapter.Myviewholder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyrestorantAdapter.Myviewholder holder, int position) {
           Glide.with(context).load(list2.get(position).getImage()).into(holder.image);
//           holder.image.setImageResource((list2.get(position).getImage()));
//        holder.Name.setText((list2.get(position).getImage()));
//        holder.description.setText((list2.get(position).getImage()));

    }

    @Override
    public int getItemCount() {
        return list2.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder{
        ImageView image;
//        TextView Name,description;

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.dishimage1);
//            Name =  itemView.findViewById(R.id.dishnametiffin);
//            description =  itemView.findViewById(R.id.hotelname1);

        }
    }
}
