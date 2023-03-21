package com.example.cityparcel_listpassed_method;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cityparcel_listpassed_method.Adapters.MyHomemadehotelsAdapter;
import com.example.cityparcel_listpassed_method.Adapters.MyHotelrestorantAdapter;
import com.example.cityparcel_listpassed_method.Adapters.MyrestorantAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link restro_farmfoodfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class restro_farmfoodfragment extends Fragment {
    RecyclerView hotel;
    DBhelper helper;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public restro_farmfoodfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment restro_farmfoodfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static restro_farmfoodfragment newInstance(String param1, String param2) {
        restro_farmfoodfragment fragment = new restro_farmfoodfragment();
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
        View view = inflater.inflate(R.layout.fragment_restro_farmfoodfragment, container, false);
        hotel = view.findViewById(R.id.homeoption);
        helper = new DBhelper(getContext());
        Bundle bundle = getArguments();
        String Restorant = bundle.getString("Type");

        if (Restorant.equalsIgnoreCase("Restorant")) {
            MyHotelrestorantAdapter adapter = new MyHotelrestorantAdapter(helper.getrestro(), getContext());
            hotel.setLayoutManager(new GridLayoutManager(getContext(), 2));
            hotel.setAdapter(adapter);

        } else {
            MyHomemadehotelsAdapter adapter = new MyHomemadehotelsAdapter(helper.gethomemade(), getContext());
            hotel.setLayoutManager(new GridLayoutManager(getContext(), 2));
            hotel.setAdapter(adapter);


        }
        return view;
    }
}