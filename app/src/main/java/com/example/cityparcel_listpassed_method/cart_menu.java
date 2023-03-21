package com.example.cityparcel_listpassed_method;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link cart_menu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class cart_menu extends Fragment {
    Button add;
    LinearLayout dish,ll_add;
    TextView increment,decrement,number;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public cart_menu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment cart_menu.
     */
    // TODO: Rename and change types and number of parameters
    public static cart_menu newInstance(String param1, String param2) {
        cart_menu fragment = new cart_menu();
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
        View view = inflater.inflate(R.layout.fragment_cart_menu, container, false);
        dish = view.findViewById(R.id.dish);
        decrement= view.findViewById(R.id.decrement);
        ll_add= view.findViewById(R.id.ll_add);
        number =view.findViewById(R.id.number);
        add = view.findViewById(R.id.add_button);
        increment = view.findViewById(R.id.increment);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll_add.setVisibility(View.VISIBLE);
                add.setVisibility(View.GONE);

            }
        });
        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int no = Integer.parseInt(number.getText().toString());
                no--;
                number.setText(String.valueOf(no));
            }

        });

        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int no = Integer.parseInt(number.getText().toString());
                no++;
                number.setText(String.valueOf(no));

            }
        });

        return view;
    }
}