package com.example.cityparcel_listpassed_method;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.cityparcel_listpassed_method.model.Homemadehotels;
import com.example.cityparcel_listpassed_method.model.restorant;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link aboutbutton#newInstance} factory method to
 * create an instance of this fragment.
 */
public class aboutbutton extends Fragment {
    Button cusin,facilities;
    Spinner spinner1,spinner2;
    EditText cusinedit,facilitiesedit;
    List<String> typelist;
    DBhelper helper;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public aboutbutton() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment aboutbutton.
     */
    // TODO: Rename and change types and number of parameters
    public static aboutbutton newInstance(String param1, String param2) {
        aboutbutton fragment = new aboutbutton();
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
        View view =inflater.inflate(R.layout.fragment_aboutbutton, container, false);
        cusin = view.findViewById(R.id.Cusinbutton);
        facilities = view.findViewById(R.id.Facilitiesbutton);
        spinner1 =view.findViewById(R.id.restrophoto);
        spinner2 = view.findViewById(R.id.pic);
        cusinedit = view.findViewById(R.id.cusin);
        facilitiesedit = view.findViewById(R.id.Facilities);
        helper = new DBhelper(getContext());
        typelist = new ArrayList<>();
        typelist.add("Restorant");
        typelist.add("Homemade");
        spinner1.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,typelist));
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spinner1.getSelectedItem().toString().equalsIgnoreCase("Restorant")) {
                    List<restorant> retrolist = helper.getrestro();
                    List<String> spinerlist = new ArrayList<>();
                    for (int j = 0; j < retrolist.size(); j++) {
                        spinerlist.add(retrolist.get(j).getId(j) + "-" + retrolist.get(j).getName());
                    }
                    spinner2.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, spinerlist));
                } else if (spinner1.getSelectedItem().toString().equalsIgnoreCase("Homemade")) {
                    List<Homemadehotels> homemadelist = helper.gethomemade();
                    List<String> spinerlist = new ArrayList<>();
                    for (int j = 0; j < homemadelist.size(); j++) {
                        spinerlist.add(homemadelist.get(j).getId() + "-" + homemadelist.get(j).getName());
                    }

                    spinner2.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, spinerlist));

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        cusin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Cusinedit = cusinedit.getText().toString();

                helper.addaboutinfo1(spinner2.getSelectedItem().toString().split("-")[0],spinner1.getSelectedItem().toString(),Cusinedit);
            }
        });

        facilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String facilities = facilitiesedit.getText().toString();

                helper.addaboutinfo2(spinner2.getSelectedItem().toString().split("-")[0],spinner1.getSelectedItem().toString(),facilities);
            }
        });


            return view;
    }
}