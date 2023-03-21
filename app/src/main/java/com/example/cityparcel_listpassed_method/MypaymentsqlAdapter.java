package com.example.cityparcel_listpassed_method;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MypaymentsqlAdapter extends RecyclerView.Adapter<MypaymentsqlAdapter.Myviewholder>{
    List<carddetail> payment;
    Context context;

    public MypaymentsqlAdapter(List<carddetail> payment, Context context) {
        this.payment = payment;
        this.context = context;
    }

    @NonNull
    @Override
    public MypaymentsqlAdapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view1 = LayoutInflater.from(context).inflate(R.layout.paymentcartxml,parent,false);
        MypaymentsqlAdapter.Myviewholder holder = new MypaymentsqlAdapter.Myviewholder(view1);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull MypaymentsqlAdapter.Myviewholder holder, int position) {
        holder.cardno.setText(payment.get(position).getCardno());
    }



    @Override
    public int getItemCount() {
        return payment.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder{
        TextView cardno;

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            cardno = itemView.findViewById(R.id.crditno);


        }
    }
    }


