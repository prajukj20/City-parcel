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

import com.example.cityparcel_listpassed_method.model.Homemadehotels;
import com.example.cityparcel_listpassed_method.model.restorant;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link menulistbutton#newInstance} factory method to
 * create an instance of this fragment.
 */
public class menulistbutton extends Fragment {

    EditText Hotelname,menu,contain,review,image,Service_type,prize;
    Spinner spinner,spinner2;
    Button menubutton;
    List<String> typelist;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public menulistbutton() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment menulistbutton.
     */
    // TODO: Rename and change types and number of parameters
    public static menulistbutton newInstance(String param1, String param2) {
        menulistbutton fragment = new menulistbutton();
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
        View view = inflater.inflate(R.layout.fragment_menulistbutton, container, false);
        menubutton = view.findViewById(R.id.summit1);
        Hotelname = view.findViewById(R.id.Hotelname1);
        menu = view.findViewById(R.id.menu1);
        contain = view.findViewById(R.id.Hotel_contain);
        review = view.findViewById(R.id.review1);
        image = view.findViewById(R.id.imageurl1);
        Service_type = view.findViewById(R.id.prize1);
        prize = view.findViewById(R.id.prize1);
        spinner =view.findViewById(R.id.spinner);
        spinner2 = view.findViewById(R.id.spinner2);
        DBhelper helper = new DBhelper(getContext());
        typelist = new ArrayList<>();
        typelist.add("Restaurant");
        typelist.add("Homemade");
        spinner.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,typelist));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spinner.getSelectedItem().toString().equalsIgnoreCase("Restaurant")) {
                    // helper.getRestro().add();
                    List<restorant> retrolist = helper.getrestro();
                    List<String> spinerlist = new ArrayList<>();
                    for (int j = 0; j < retrolist.size(); j++) {
                        spinerlist.add(retrolist.get(j).getId(j) + "-" + retrolist.get(j).getName());
                    }
                    spinner2.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, spinerlist));
                } else if (spinner.getSelectedItem().toString().equalsIgnoreCase("Homemade")) {
                    // helper.getHomemade().add();
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
        menubutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hotel = Hotelname.getText().toString();
                String menuname = menu.getText().toString();
                String Contain = contain.getText().toString();
                String Review = review.getText().toString();
                String Image = image.getText().toString();
                String Prize = prize.getText().toString();
                String Service = Service_type.getText().toString();


                helper.addmenuinfo(spinner2.getSelectedItem().toString().split("-")[0],menuname,Contain,"main course",Prize,Service,Image,"1");
            }

        });

            return view;
    }
}