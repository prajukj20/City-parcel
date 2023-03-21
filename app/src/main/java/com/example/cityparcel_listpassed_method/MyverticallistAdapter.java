package com.example.cityparcel_listpassed_method;

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

import com.bumptech.glide.Glide;

import java.util.List;

public class MyverticallistAdapter extends RecyclerView.Adapter<MyverticallistAdapter.Myviewholder> {
    List<menulist> total;
    Context context;
    mainactivitytabs.OnMenuAddListner addListner;

    public MyverticallistAdapter(List<menulist> total, Context context, mainactivitytabs.OnMenuAddListner addListner) {
        this.total = total;
        this.context = context;
        this.addListner = addListner;
    }

    @NonNull
    @Override
    public MyverticallistAdapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view2 = LayoutInflater.from(context).inflate(R.layout.fragment_menuverticalview_fragment, parent, false);
        Myviewholder holder = new Myviewholder(view2);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyverticallistAdapter.Myviewholder holder, int position) {
        holder.name.setText(total.get(position).getName());
        holder.Prize.setText(total.get(position).getPrize());
        Glide.with(context).load(total.get(position).getUrl()).into(holder.imageview);

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.ll_add.setVisibility(View.VISIBLE);
                holder.add.setVisibility(View.GONE);
                addListner.onItemAdded(total.get(position));

            }
        });
        holder.decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int no = Integer.parseInt(holder.number.getText().toString());
                if (no==1) {
                    holder.add.setVisibility(View.VISIBLE);
                    holder.ll_add.setVisibility(View.GONE);
                    addListner.onItemUpdate(total.get(position).getName(),"0");

                    return;
                }

                no--;
                holder.number.setText(String.valueOf(no));


                addListner.onItemUpdate(total.get(position).getName(),no+"");

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
                holder.number.setText(String.valueOf(no));
                addListner.onItemUpdate(total.get(position).getName(),no+"");

            }

        });


    }

    @Override
    public int getItemCount() {
        return total.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {
        TextView name,Prize,Contain,category,service_type;
        ImageView imageview;
        Button add;
        LinearLayout ll_add;
        TextView increment,decrement,number;


        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            imageview = itemView.findViewById(R.id.namepaneer);
            increment =itemView.findViewById(R.id.increment);
            decrement =itemView.findViewById(R.id.decrement);
            number =itemView.findViewById(R.id.number);
            add = itemView.findViewById(R.id.add_button);
            ll_add = itemView.findViewById(R.id.ll_add);
            name = itemView.findViewById(R.id.dishname1);
            Prize = itemView.findViewById(R.id.dishprize1);
            Contain = itemView.findViewById(R.id.dishcontain);
            category = itemView.findViewById(R.id.category);
            service_type = itemView.findViewById(R.id.Service_type);


        }
    }
}
