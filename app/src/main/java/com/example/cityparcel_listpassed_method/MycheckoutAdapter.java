package com.example.cityparcel_listpassed_method;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MycheckoutAdapter extends RecyclerView.Adapter<MycheckoutAdapter.Myviewholder> {
    List<paymentlist> payment;
    Context context;

    public MycheckoutAdapter(List<paymentlist> payment, Context context) {
        this.payment = payment;
        this.context = context;
    }

    @NonNull
    @Override
    public MycheckoutAdapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.addressdetails,parent,false);
        MycheckoutAdapter.Myviewholder holder = new MycheckoutAdapter.Myviewholder(view1);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MycheckoutAdapter.Myviewholder holder, int position) {
    holder.Name.setText(payment.get(position).getHotelid());
    holder.Address.setText(payment.get(position).getHotelid());

    }



    @Override
    public int getItemCount() {
        return payment.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder{
        TextView Name,Address,Email;

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.username);
            Address = itemView.findViewById(R.id.use_add);
            Email = itemView.findViewById(R.id.emailid);

        }
    }
}
