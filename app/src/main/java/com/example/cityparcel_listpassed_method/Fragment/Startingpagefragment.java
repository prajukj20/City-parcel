package com.example.cityparcel_listpassed_method.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cityparcel_listpassed_method.DBhelper;
import com.example.cityparcel_listpassed_method.menulist;
import com.example.cityparcel_listpassed_method.model.Homemadehotels;
import com.example.cityparcel_listpassed_method.Adapters.MyHomemadehotelsAdapter;
import com.example.cityparcel_listpassed_method.Adapters.MyHotelrestorantAdapter;
import com.example.cityparcel_listpassed_method.Adapters.MyfarmfoodAdpter;
import com.example.cityparcel_listpassed_method.Adapters.MygiftAdpter;
import com.example.cityparcel_listpassed_method.Adapters.MytoplistAdapter;
import com.example.cityparcel_listpassed_method.R;
import com.example.cityparcel_listpassed_method.model.restorant;
import com.example.cityparcel_listpassed_method.model.toplist;
import com.example.cityparcel_listpassed_method.restro_farmfoodfragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Startingpagefragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Startingpagefragment extends Fragment {
    RecyclerView Restourant_food,Hoteldish,Restourantlist,Homemadelist,farmfoodlist,giftlist;
    TextView view1,view2,view3,view4;
    DBhelper helper;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Startingpagefragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Startingpagefragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Startingpagefragment newInstance(String param1, String param2) {
        Startingpagefragment fragment = new Startingpagefragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_startingpagefragment, container, false);
        Restourant_food = view.findViewById(R.id.horizontalview1);
        Hoteldish = view.findViewById(R.id.horizontalview2);
        Restourantlist = view.findViewById(R.id.horizontalview3);
        Homemadelist = view.findViewById(R.id.horizontalview4);
        farmfoodlist = view.findViewById(R.id.horizontalview5);
        giftlist = view.findViewById(R.id.horizontalview6);
        view1 = view.findViewById(R.id.view1);
        view2 = view.findViewById(R.id.view2);
        view3 = view.findViewById(R.id.view3);
        view4 = view.findViewById(R.id.view4);
        helper = new DBhelper(getContext());

//        helper.getReadableDatabase().execSQL("SELECT * FROM Hotellist");


        Restourant_food.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        Hoteldish.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        Restourantlist.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        Homemadelist.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        farmfoodlist.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        giftlist.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));

        List<toplist>list =new ArrayList<>();
        list.add(new toplist("Restourant",R.mipmap.restorant_food));
        list.add(new toplist("Homemade",R.mipmap.hotel));
        list.add(new toplist("Farmfo0d",R.mipmap.farm));
        list.add(new toplist("Gift",R.mipmap.gift3));
        MytoplistAdapter adapter = new MytoplistAdapter(list,getContext());
        Restourant_food.setAdapter(adapter);



//        List<restorant> list2 = new ArrayList<>();
//        list2.add(new restorant(R.mipmap.icecreame,"Ananth Palace","Veg,chiness","Chiness"));
//        list2.add(new restorant(R.mipmap.icecreame,"Star Hotel","Veg-NonVeg,Chiness","Chiness"));
//        list2.add(new restorant(R.mipmap.icecreame,"Five Palace","All Veg-NonVeg","Chiness"));
//        list2.add(new restorant(R.mipmap.icecreame,"Foody Palace","Veg-NonVeg","Chiness"));

//        MyrestorantAdapter adapter1  = new MyrestorantAdapter(list2,getContext());
//        Hoteldish.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
//        Hoteldish.setVisibility(View.VISIBLE);
//        Hoteldish.setAdapter(adapter1);


//        List<restorant> list3 = new ArrayList<>();
//               helper.getWritableDatabase().execSQL("DELETE FROM Photos WHERE id='1'");

//        helper.getWritableDatabase().execSQL(" DELETE FROM Photos WHERE id='2'");
//        helper.getWritableDatabase().execSQL(" DELETE FROM Photos WHERE id='3'");
//        helper.getWritableDatabase().execSQL(" DELETE FROM Photos WHERE id='4'");helper.getWritableDatabase().execSQL(" DELETE FROM Photos WHERE id='5'");


        helper = new DBhelper(getContext());
        List<restorant> retrolist = helper.getrestro();

//        list3.add(new restorant(R.mipmap.hotel1,"Ananth Palace","Veg,chiness","Chiness"));
//        list3.add(new restorant(R.mipmap.hotel2,"Star Hotel","Veg-NonVeg,Chiness","Chiness"));
//        list3.add(new restorant(R.mipmap.hotel3,"Five Palace","All Veg-NonVeg","Chiness"));
//        list3.add(new restorant(R.mipmap.hotel1,"Foody Palace","Veg-NonVeg","Chiness"));
//        MyHotelrestorantAdapter adapter2 = new MyHotelrestorantAdapter(list3,getContext());
//        Restourantlist.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
//        Restourantlist.setVisibility(View.VISIBLE);
//        Restourantlist.setAdapter(adapter2);

        MyHotelrestorantAdapter adapter2 = new MyHotelrestorantAdapter(retrolist,getContext());
        Restourantlist.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        Restourantlist.setVisibility(View.VISIBLE);
        Restourantlist.setAdapter(adapter2);


//        List<Homemadehotels> list4 = new ArrayList<>();
//        list4.add(new Homemadehotels(R.mipmap.homemade1,"Vanita Tiffn Service","ALl type foods avaible","Sapicy foods"));
//        list4.add(new Homemadehotels(R.mipmap.homemade2,"Yeshoda Tiffn Service","ALl type foods avaible","Sapicy foods"));
        List<Homemadehotels> homeservice = helper.gethomemade();

        MyHomemadehotelsAdapter adapter3 = new MyHomemadehotelsAdapter (homeservice,getContext());
        Homemadelist.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        Homemadelist.setVisibility(View.VISIBLE);
        Homemadelist.setAdapter(adapter3);

//        List<gift> list5 = new ArrayList<>();
//        list5.add(new gift(R.mipmap.farmfood1,"Fresh_stoberry","ALl type gicts avaible","teedy Gifts","200"));
//        list5.add(new gift(R.mipmap.farmfood2,"Fresh_graps,","ALl type gicts avaible","teedy Gifts","150"));
//        list5.add(new gift(R.mipmap.farmfood3,"fresh_graps","ALl type gicts avaible","teedy Gifts","200"));
        List<gift> farmfood = helper.getfarmfood();
        MyfarmfoodAdpter adpter4 = new MyfarmfoodAdpter(farmfood,getContext());
        farmfoodlist.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        farmfoodlist.setVisibility(View.VISIBLE);
        farmfoodlist.setAdapter(adpter4);


//        List<gift> list6 = new ArrayList<>();
//        list6.add(new gift(R.mipmap.gift3,"Taddy shop,","ALl type gicts avaible","teedy Gifts","200"));
//        list6.add(new gift(R.mipmap.gift2,"Kitchen shop,","ALl type gicts avaible","teedy Gifts","150"));
//        list6.add(new gift(R.mipmap.gift2,"Kitchen shop,","ALl type gicts avaible","teedy Gifts","150"));
        List<gift> giftproduct = helper.getgift();
        MygiftAdpter adpter5 = new MygiftAdpter(giftproduct,getContext());
        giftlist.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        giftlist.setVisibility(View.VISIBLE);
        giftlist.setAdapter(adpter5);






        view1.setOnClickListener(new View.OnClickListener() {
          @Override
             public void onClick(View view) {
        FragmentTransaction transaction =getActivity().getSupportFragmentManager().beginTransaction();
        Fragment fragment= new restro_farmfoodfragment();
        Bundle bundle =new Bundle();
        bundle.putString("Type","Restorant");
        fragment.setArguments(bundle);
        transaction.add(R.id.frame, fragment);
        transaction.commit();

            }
        });

        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction =getActivity().getSupportFragmentManager().beginTransaction();
                Fragment fragment= new restro_farmfoodfragment();
                Bundle bundle =new Bundle();
                bundle.putString("Type","Homemade");
                fragment.setArguments(bundle);
                transaction.add(R.id.frame, fragment);
                transaction.commit();

            }
        });
        view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction =getActivity().getSupportFragmentManager().beginTransaction();
                Fragment fragment= new farm_giftFragment();
                Bundle bundle =new Bundle();
                bundle.putString("Type","Farmfood");
                fragment.setArguments(bundle);
                transaction.add(R.id.frame, fragment);
                transaction.commit();

            }
        });

        view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction =getActivity().getSupportFragmentManager().beginTransaction();
                Fragment fragment= new farm_giftFragment ();
                Bundle bundle =new Bundle();
                bundle.putString("Type","Gifts");
                fragment.setArguments(bundle);
                transaction.add(R.id.frame, fragment);
                transaction.commit();

            }
        });



        return view;
    }
}