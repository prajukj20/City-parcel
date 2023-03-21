package com.example.cityparcel_listpassed_method.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityparcel_listpassed_method.Fragment.gift;
import com.example.cityparcel_listpassed_method.R;

import java.util.List;

public class MygiftAdpter extends RecyclerView.Adapter<MygiftAdpter.Myviewholder>  {
    List<gift>list6;
    Context context;

    public MygiftAdpter(List<gift> list6, Context context) {
        this.list6 = list6;
        this.context = context;
    }

    @NonNull
    @Override
    public MygiftAdpter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pagerliststart,parent,false);
        MygiftAdpter.Myviewholder holder = new MygiftAdpter.Myviewholder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MygiftAdpter.Myviewholder holder, int position) {
//        holder.image.setImageResource(list5.get(position).getImage());
        holder.Name.setText((list6.get(position).getName()));
        holder.Prize.setText((list6.get(position).getPrize()));
        holder.Description.setText((list6.get(position).getDescription()));

    }

    @Override
    public int getItemCount() {
        return list6.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {
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
