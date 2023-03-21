package com.example.cityparcel_listpassed_method.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cityparcel_listpassed_method.Adapters.MyfarmfoodAdpter;
import com.example.cityparcel_listpassed_method.Adapters.MygiftAdpter;
import com.example.cityparcel_listpassed_method.DBhelper;
import com.example.cityparcel_listpassed_method.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link farm_giftFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class farm_giftFragment extends Fragment {

    RecyclerView Farm_gift;
    DBhelper helper;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public farm_giftFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment farm_giftFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static farm_giftFragment newInstance(String param1, String param2) {
        farm_giftFragment fragment = new farm_giftFragment();
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
        View view = inflater.inflate(R.layout.fragment_farm_gift, container, false);
        Farm_gift = view.findViewById(R.id.homeoption1);
        helper = new DBhelper(getContext());
        Bundle bundle = getArguments();
        String Farmproduct = bundle.getString("Type");

        if (Farmproduct.equalsIgnoreCase("Farmfood")) {
            MyfarmfoodAdpter adapter = new MyfarmfoodAdpter(helper.getfarmfood(), getContext());
            Farm_gift.setLayoutManager(new GridLayoutManager(getContext(), 2));
            Farm_gift.setAdapter(adapter);

        } else {
            MygiftAdpter adapter = new MygiftAdpter(helper.getgift(), getContext());
            Farm_gift.setLayoutManager(new GridLayoutManager(getContext(), 2));
            Farm_gift.setAdapter(adapter);


        }
        return view;

    }
}