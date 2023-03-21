package com.example.cityparcel_listpassed_method.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cityparcel_listpassed_method.R;
import com.example.cityparcel_listpassed_method.model.restorant;
import com.example.cityparcel_listpassed_method.startingpage2ndpager;

import java.util.List;

public class MyHotelrestorantAdapter  extends RecyclerView.Adapter<MyHotelrestorantAdapter.Myviewholder>{
        List<restorant> list3;
        Context context;
        RelativeLayout relative;

    public MyHotelrestorantAdapter(List<restorant> list3, Context context) {
        this.list3 = list3;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHotelrestorantAdapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pagerliststart,parent,false);
        MyHotelrestorantAdapter.Myviewholder holder = new MyHotelrestorantAdapter.Myviewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHotelrestorantAdapter.Myviewholder holder, int position) {
        Glide.with(context).load(list3.get(position).getImage()).into(holder.image);
        Log.e("TAG",list3.get(position).getImage());
//        holder.image.setImageResource((list3.get(position).getImage()));
        holder.Name.setText((list3.get(position).getName()));
        holder.description.setText((list3.get(position).getName()));
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
         @Override
            public void onClick(View view) {

             FragmentTransaction transaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
             Fragment fragment = new startingpage2ndpager();
             transaction.add(R.id.frame,fragment);
             transaction.commit();


         }
});

    }

    @Override
    public int getItemCount() {
        return list3.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView Name,description,Prize;
        RelativeLayout relativeLayout;

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.dishimage1);
            Name =  itemView.findViewById(R.id.dishnametiffin);
            description =  itemView.findViewById(R.id.hotelname1);
            Prize =  itemView.findViewById(R.id.prize);
            relativeLayout =  itemView.findViewById(R.id.relative1);

        }
    }
}
