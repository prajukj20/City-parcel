package com.example.cityparcel_listpassed_method;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fineding_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fineding_fragment extends Fragment {

    Button restrobutton, homemadebutton, farmfoodbutton, giftbutton,menubutton,photosbutton,reviewbutton,aboutbutton;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fineding_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fineding_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static fineding_fragment newInstance(String param1, String param2) {
        fineding_fragment fragment = new fineding_fragment();
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
        View view =inflater.inflate(R.layout.fragment_findining, container, false);
        restrobutton = view.findViewById(R.id.button2);
        homemadebutton = view.findViewById(R.id.button3);
        farmfoodbutton = view.findViewById(R.id.button4);
        giftbutton = view.findViewById(R.id.button5);
        menubutton = view.findViewById(R.id.button6);
        photosbutton = view.findViewById(R.id.button7);
        reviewbutton = view.findViewById(R.id.button8);
        aboutbutton = view.findViewById(R.id.button9);

        DBhelper helper = new DBhelper(getContext());
        restrobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frame1, new restrobutton_fragmnet());
                transaction.commit();
            }
        });

        homemadebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frame1,new homemadebutton_fragment());
                transaction.commit();
            }
        });
        farmfoodbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frame1,new farmfoodbutton());
                transaction.commit();
            }
        });
        giftbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frame1,new giftbutton());
                transaction.commit();
            }
        });
        menubutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frame1,new menulistbutton());
                transaction.commit();
            }
        });
        photosbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frame1,new photosbutton());
                transaction.commit();
            }
        });
        reviewbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frame1,new reviewbutton());
                transaction.commit();
            }
        });
        aboutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frame1,new aboutbutton());
                transaction.commit();
            }
        });






        return view;
    }
}