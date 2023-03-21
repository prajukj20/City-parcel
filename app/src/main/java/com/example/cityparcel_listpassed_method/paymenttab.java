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
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link paymenttab#newInstance} factory method to
 * create an instance of this fragment.
 */
public class paymenttab extends Fragment {
    TextView credit,UPI,cardpayment_delevery;
    RecyclerView paymentrecy;
    EditText Number,Nameofcard,exiperydate,cvv_no;
    DBhelper helper;
    Button Save,addbutton,paybutton;
    LinearLayout linerpay1;
    menupaymenttab_fragment.OnshoppingListene;
    mainactivitytabs activity;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public paymenttab() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment paymenttab.
     */
    // TODO: Rename and change types and number of parameters
    public static paymenttab newInstance(String param1, String param2) {
        paymenttab fragment = new paymenttab();
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
        shoppinglistener = activity.shoplistener;


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
        View view= inflater.inflate(R.layout.fragment_paymenttabsqlite, container, false);
        credit = view.findViewById(R.id.credit);
        UPI = view.findViewById(R.id.UPI);
        Number = view.findViewById(R.id.cardno);
        Nameofcard = view.findViewById(R.id.cardholder);
        exiperydate = view.findViewById(R.id.datepay);
        cvv_no = view.findViewById(R.id.cvvnopay);
        cardpayment_delevery = view.findViewById(R.id.cashondelevery);
        paymentrecy = view.findViewById(R.id.paymentrecy);
        Save = view.findViewById(R.id.addcard);
        addbutton = view.findViewById(R.id.addbutton);
        linerpay1 = view.findViewById(R.id.linerpay1);
        helper = new DBhelper(getContext());
        paybutton=view.findViewById(R.id.paybutton);

       credit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               paymentrecy.setVisibility(View.VISIBLE);
                addbutton.setVisibility(View.VISIBLE);
           }
       });

       addbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               linerpay1.setVisibility(View.VISIBLE);
               paymentrecy.setVisibility(View.GONE);

           }
       });



        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = Number.getText().toString();
                String nameofcard = Nameofcard.getText().toString();
                String Exiperydate = exiperydate.getText().toString();
                String Cvv_no = cvv_no.getText().toString();
                paymentrecy.setVisibility(View.VISIBLE);
                addbutton.setVisibility(View.VISIBLE);
                linerpay1.setVisibility(View.GONE);
                helper.addcardpayinfo(number,nameofcard,Exiperydate,Cvv_no);
            }
        });

        paybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                shoppinglistener.OnNextClick(1);
                long order_id = System.currentTimeMillis();
                String strorder_id = String.valueOf(order_id);
                helper.Updtaecard(strorder_id,"delevery");
                FragmentTransaction transaction =getActivity().getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frmepay,new complete());
                transaction.commit();

            }
        });

        MypaymentsqlAdapter adapter = new MypaymentsqlAdapter(helper.getcardinfo(),getContext());
        paymentrecy.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        paymentrecy.setVisibility(View.VISIBLE);
        paymentrecy.setAdapter(adapter);



        return view;
    }

}