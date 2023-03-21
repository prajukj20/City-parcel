package com.example.cityparcel_listpassed_method;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Addressupdate#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Addressupdate extends Fragment {

    List<paymentlist> payment;
    RecyclerView recy1;
    EditText hotelid,email,Name,Address,landmark,state,city;
    LinearLayout linear;
    DBhelper helper;
    MycheckoutAdapter adapter1;
    Button addaddressbutton,summit,Pay_Now;
    menupaymenttab_fragment.OnshoppingListener shoppinglistener;
    mainactivitytabs activity;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Addressupdate() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Addressupdate.
     */
    // TODO: Rename and change types and number of parameters
    public static Addressupdate newInstance(String param1, String param2) {
        Addressupdate fragment = new Addressupdate();
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


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_addressupdate, container, false);
        recy1 = view.findViewById(R.id.recycle1);
        addaddressbutton = view.findViewById(R.id.buttonadd);
        summit = view.findViewById(R.id.summitbutton);
        hotelid = view.findViewById(R.id.hotelid2);
        email = view.findViewById(R.id.email);
        Name = view.findViewById(R.id.nameaddress);
        Address = view.findViewById(R.id.locationaddress);
        landmark = view.findViewById(R.id.landmark);
        state = view.findViewById(R.id.state);
        city = view.findViewById(R.id.city);
        linear = view.findViewById(R.id.linerpay);
        Pay_Now = view.findViewById(R.id.Continuebutton1);
        helper = new DBhelper(getContext());
        shoppinglistener = activity.shoplistener;


        summit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  Hotelid  = hotelid.getText().toString();
                String  name  = Name.getText().toString();
                String  address  = Address.getText().toString();
                String  Landmark  = landmark.getText().toString();
                String  State  = state.getText().toString();
                String  City  = city.getText().toString();
                recy1.setVisibility(View.VISIBLE);
                addaddressbutton.setVisibility(View.VISIBLE);
                linear.setVisibility(View.GONE);

                helper.addpaymentinfo(Hotelid,name,address,Landmark,State,City);
            }
        });



        MycheckoutAdapter adapter1 = new MycheckoutAdapter(helper.getpaymentinfo(),getContext());
        recy1.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        recy1.setVisibility(View.VISIBLE);
        recy1.setAdapter(adapter1);




        addaddressbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear.setVisibility(View.VISIBLE);
                addaddressbutton.setVisibility(View.GONE);
                recy1.setVisibility(View.GONE);
            }
        });

       Pay_Now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FragmentTransaction transaction =getActivity().getSupportFragmentManager().beginTransaction();
//                transaction.add(R.id.shopfrem,new paymenttab());
//                transaction.commit();
                shoppinglistener.OnNextClick(0);



            }
        });



        return view;
    }
}