package com.example.cityparcel_listpassed_method;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link farmfoodbutton#newInstance} factory method to
 * create an instance of this fragment.
 */
public class farmfoodbutton extends Fragment {
    EditText Name,Description,faverites,ReviewAverage,Image,Prize;
    Button farmfoodsummitbutton;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public farmfoodbutton() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment farmfoodbutton.
     */
    // TODO: Rename and change types and number of parameters
    public static farmfoodbutton newInstance(String param1, String param2) {
        farmfoodbutton fragment = new farmfoodbutton();
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

        View view = inflater.inflate(R.layout.fragment_farmfoodbutton, container, false);
        farmfoodsummitbutton = view.findViewById(R.id.summit);

        Name = view.findViewById(R.id.farmfoodname);
        Description = view.findViewById(R.id.Description);
        faverites = view.findViewById(R.id.faverites);
        ReviewAverage = view.findViewById(R.id.review);
        Image = view.findViewById(R.id.imageurl);
        Prize = view.findViewById(R.id.prize);

        DBhelper helper = new DBhelper(getContext());

        farmfoodsummitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = Name.getText().toString();
                String description = Description.getText().toString();
                String Faverites = faverites.getText().toString();
                String Review = ReviewAverage.getText().toString();
                String image = Image.getText().toString();
                String prize = Prize.getText().toString();

                helper.addfarmfood(null, name, description, Faverites, Review, image, prize);
            }
        });
        return view;


    }
}