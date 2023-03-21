package com.example.cityparcel_listpassed_method;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Menu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Menu extends Fragment {

    RecyclerView horizontal, vertical;
    List<menulist> All;
    List<menulist> Stater;
    List<menulist> Maincourse;
    List<menulist> Breckfast;
    List<menulist> Deseert;
    List<menulist> total;
    Context context;
    DBhelper helper;
    mainactivitytabs activity;
    MyhorizaontalistAdapter adapter;
    MyverticallistAdapter adapter1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Menu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Menu.
     */
    // TODO: Rename and change types and number of parameters
    public static Menu newInstance(String param1, String param2) {
        Menu fragment = new Menu();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activity = (mainactivitytabs) getActivity();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView text = (TextView) view;
            if (text.getText().toString().equalsIgnoreCase("All")) {
                adapter1 = new MyverticallistAdapter(total, getContext(), activity.

                        addListner);
                vertical.setAdapter(adapter1);
            }
            if (text.getText().toString().equalsIgnoreCase("Stater")) {
                adapter1 = new MyverticallistAdapter(total, getContext(), activity.addListner);
                vertical.setAdapter(adapter1);
            }
            if (text.getText().toString().equalsIgnoreCase("<Maincourse>")) {
                adapter1 = new MyverticallistAdapter(total, getContext(), activity.addListner);
                vertical.setAdapter(adapter1);
            }
            if (text.getText().toString().equalsIgnoreCase("Breckfast")) {
                adapter1 = new MyverticallistAdapter(total, getContext(), activity.addListner);
                vertical.setAdapter(adapter1);
            }
            if (text.getText().toString().equalsIgnoreCase("Deseert")) {
                adapter1 = new MyverticallistAdapter(total, getContext(), activity.addListner);
                vertical.setAdapter(adapter1);
            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceStatecc) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        horizontal = view.findViewById(R.id.horizontalview);
        vertical = view.findViewById(R.id.verticalview);
        helper = new DBhelper(getContext());
        Set<String> category = new LinkedHashSet<>();
        category.add("All");
//        category.add("Stater");
//        category.add("Maincourse");
//        category.add("Breckfast");
//        category.add("Deseert");


        total = helper.getmenuinfo();
        MyverticallistAdapter adapter6 = new MyverticallistAdapter(total,getContext(), activity.addListner);
        vertical.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        vertical.setVisibility(View.VISIBLE);
        vertical.setAdapter(adapter6);



//        total = new ArrayList<>();
//        total.add(new menulist("1","Paneer Masala","200","paneer with gravey","Maincourse","1","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS-9sQztXiRmvCgyoK-CRM9ETHGi8HgKC4geYP7li29fGPQVQcW1FTj5RLECEtyxMKAEe0&usqp=CAU","2"));




        All = new ArrayList<>();
        Stater = new ArrayList<menulist>();
        Maincourse = new ArrayList<menulist>();
        Breckfast = new ArrayList<menulist>();
        Deseert = new ArrayList<menulist>();

        for (menulist item : total) {

            if (item.category.equalsIgnoreCase("Stater")) ;
            {
                Stater.add(item);
            }
            if (item.category.equalsIgnoreCase("Maincourse")) ;
            {
                Maincourse.add(item);
            }
            if (item.category.equalsIgnoreCase("Breckfast")) ;
            {
                Breckfast.add(item);
            }
            if (item.category.equalsIgnoreCase("Deseert")) ;
            {
                Deseert.add(item);
            }
            category.add(item.getCategory());
        }
        adapter = new MyhorizaontalistAdapter(category, getContext(),onClickListener);
        horizontal.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        horizontal.setAdapter(adapter);
        adapter1 = new MyverticallistAdapter(total, getContext(), activity.addListner);


        vertical.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        vertical.setAdapter(adapter1);
        return view;
    }
}