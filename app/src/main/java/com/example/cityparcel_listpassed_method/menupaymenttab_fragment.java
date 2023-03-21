package com.example.cityparcel_listpassed_method;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link menupaymenttab_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class menupaymenttab_fragment extends Fragment {
    ViewPager pager;
    TabLayout tab;
    Button continueb1;
    List<shopinglist>list;
    public OnshoppingListener shoplistener;
    mainactivitytabs activity  ;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public menupaymenttab_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment menupaymenttab_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static menupaymenttab_fragment newInstance(String param1, String param2) {
        menupaymenttab_fragment fragment = new menupaymenttab_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<shopinglist>();
        activity= (mainactivitytabs)getActivity();
        activity.shoplistener = new OnshoppingListener() {
            @Override
            public void OnNextClick(int position) {

               int pagerposition = pager.getCurrentItem();
               if (pagerposition==0){
                   pager.setCurrentItem(1);

               }
               if (pagerposition==1){
                   pager.setCurrentItem(2);
               }

            }
        };

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
        View view = inflater.inflate(R.layout.fragment_menupaymenttab_fragment, container, false);

        pager = view.findViewById(R.id.paymentpage);
        tab = view.findViewById(R.id.paymenttab);
//        continueb1 = view.findViewById(R.id.continuebutton);

//        continueb1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (pager.getCurrentItem()==0){
//                    pager.setCurrentItem(1);
//                } else if (pager.getCurrentItem()==1){
//                    pager.setCurrentItem(2);
//                }
//            }
//        });

        MypaymentpadeAdapter adapter = new MypaymentpadeAdapter(getChildFragmentManager(),menupaymenttab_fragment.this);
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(3);
        tab.setupWithViewPager(pager);
        tab.getTabAt(0).setText("Address");
        tab.getTabAt(1).setText("Payment");
        tab.getTabAt(2).setText("Complete");

        return view;
    }

    interface OnshoppingListener{
        void OnNextClick (int position);

    }
    }

