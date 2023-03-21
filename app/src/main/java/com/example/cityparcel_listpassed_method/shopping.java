package com.example.cityparcel_listpassed_method;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link shopping#newInstance} factory method to
 * create an instance of this fragment.
 */
public class shopping extends Fragment {
    mainactivitytabs activity;
    List<menulist> list;
    RecyclerView cart;
    MyShoppingcardApdater adapter1;
    DBhelper helper;
    TextView tvtotal;
    Button checkout;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public shopping() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment shopping.
     */
    // TODO: Rename and change types and number of parameters
    public static shopping newInstance(String param1, String param2) {
        shopping fragment = new shopping();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<menulist>();
        activity =(mainactivitytabs)getActivity();

        activity.addListner = new mainactivitytabs.OnMenuAddListner() {

            @Override
            public void onItemAdded(menulist data) {
                helper.addshoppingcartinfo(data.hotelid, data.Name, data.Contain, data.category, data.Prize, data.service_type,data.Url,data.count);
                list.add(data);
                adapter1.notifyDataSetChanged();
                updateTotal();
            }

            @Override
            public void onItemUpdate(String name, String count) {
                for (int i=0;i<list.size();i++){
                    if (list.get(i).getName().equals(name)){
                        list.get(i).getPrize();
                        if (count.equals("0")){
                            list.remove(i);
                        }

                        adapter1.notifyDataSetChanged();
                    }
                }
                updateTotal();
            }
        };


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_shopping, container, false);
        cart= view.findViewById(R.id.shoppingcard);
        tvtotal= view.findViewById(R.id.prise);
        checkout = view.findViewById(R.id.checkbutton);
        helper = new DBhelper(getContext());
        list = helper.getcartinfo();
        adapter1 = new MyShoppingcardApdater(list,getContext(),activity.addListner);
        cart.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        cart.setVisibility(View.VISIBLE);
        cart.setAdapter(adapter1);

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction transaction =getActivity().getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.shopfrem,new menupaymenttab_fragment());
                transaction.commit();


            }

        });


        return view;
    }


    void updateTotal() {

    int total = 0;
    for(int i = 0;i<list.size();i++){

        total= total+  Integer.parseInt( list.get(i).getPrize()) * Integer.parseInt(list.get(i).getCount());
    }
        tvtotal.setText(total+"");
}


}