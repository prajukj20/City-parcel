package com.example.cityparcel_listpassed_method;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyShoppingcardApdater extends RecyclerView.Adapter<MyShoppingcardApdater.Myviewholder> {
 List<menulist> list;
 Context context;
 mainactivitytabs.OnMenuAddListner shoplistner;

 public MyShoppingcardApdater(List<menulist> list, Context context, mainactivitytabs.OnMenuAddListner shoplistner) {
  this.list = list;
  this.context = context;
  this.shoplistner = shoplistner;
 }

 @NonNull
 @Override
 public MyShoppingcardApdater.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
  View view1 = LayoutInflater.from(context).inflate(R.layout.shoppingcart,parent,false);
  Myviewholder holder = new Myviewholder(view1);
  return holder;
 }

 @Override
 public void onBindViewHolder(@NonNull MyShoppingcardApdater.Myviewholder holder, @SuppressLint("RecyclerView") int position) {

//  Glide.with(context).load(list.get(position).()).into(holder.image);

  holder.Hotelname.setText(list.get(position).getName());
  holder.prize.setText(list.get(position).getPrize());
//  holder.number.setText(list.get(position).getCount());

     holder.decrement.setOnClickListener(new View.OnClickListener() {
   @Override
    public void onClick(View view) {
      int no = Integer.parseInt(holder.number.getText().toString());
      no--;
      shoplistner.onItemUpdate(list.get(position).getCount(),no+"");
           }
       });
   holder.increment.setOnClickListener(new View.OnClickListener() {
   @Override
    public void onClick(View view) {
       int no = Integer.parseInt(holder.number.getText().toString());
       if (no==15){
       Toast.makeText(context, "You reached max limit of this product.", Toast.LENGTH_SHORT).show();
       return;
       }
           no++;
         shoplistner.onItemUpdate(list.get(position).getName(),no+"");

      }

    });
   holder.add_ons.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
            Dialog dialog = new Dialog(view.getContext());
            dialog.setContentView(R.layout.orderbox);
            dialog.show();
         }
     });


 }

 @Override
 public int getItemCount() {
  return list.size();
 }

 public class Myviewholder extends RecyclerView.ViewHolder {
  ImageView image;
  TextView Hotelname,prize,add_ons;
  TextView increment,decrement,number;
  LinearLayout shop;


  public Myviewholder(@NonNull View itemView) {
   super(itemView);
   image =itemView.findViewById(R.id.namepaneer);
   Hotelname = itemView.findViewById(R.id.hotelnmaeadd);
   prize = itemView.findViewById(R.id.dishprize1);
   increment = itemView.findViewById(R.id.incre);
   decrement = itemView.findViewById(R.id.decre);
   number = itemView.findViewById(R.id.count);
   add_ons = itemView.findViewById(R.id.addons);


  }
 }
}
