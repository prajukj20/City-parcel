package com.example.cityparcel_listpassed_method;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.cityparcel_listpassed_method.Fragment.farm_giftFragment;
import com.google.android.material.tabs.TabLayout;

public class mainactivitytabs extends AppCompatActivity {

//    public OnMenuAddListner shoplistner;
    ViewPager pager;
    TabLayout tab;
    public OnMenuAddListner addListner;
    public menupaymenttab_fragment.OnshoppingListener shoplistener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainactivitytabs);
        pager = findViewById(R.id.pager2);
        tab = findViewById(R.id.tab2);
        MypagerAdapter adapter = new MypagerAdapter(getSupportFragmentManager(), mainactivitytabs.this);
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(4);
        tab.setupWithViewPager(pager);
            long order_id = System.currentTimeMillis();

        tab.getTabAt(0).setText("Home");
        tab.getTabAt(1).setText("Shopping");
        tab.getTabAt(2).setText("finedining");
        tab.getTabAt(3).setText("Account");

        tab.getTabAt(0).setIcon(getResources().getDrawable(R.drawable.home));
        tab.getTabAt(1).setIcon(getResources().getDrawable(R.drawable.shopping));
        tab.getTabAt(2).setIcon(getResources().getDrawable(R.drawable.dining));
        tab.getTabAt(3).setIcon(getResources().getDrawable(R.drawable.account));
    }



    public void onBackPressed() {

        for (Fragment fragment5 : getSupportFragmentManager().getFragments()) {
            if (fragment5 instanceof menupaymenttab_fragment) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                for (Fragment fragment6 : getSupportFragmentManager().getFragments()) {
                    if (fragment6 instanceof menupaymenttab_fragment||fragment6 instanceof Addressupdate||fragment6 instanceof paymenttab||fragment6 instanceof complete){
                        transaction.remove(fragment6);
                    }
                }
                transaction.commit();
                return;
            }

        }



        for (Fragment fragment4 : getSupportFragmentManager().getFragments()) {
            if (fragment4 instanceof startingpage2ndpager) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                for (Fragment fragment5 : getSupportFragmentManager().getFragments()) {
                    if (fragment5 instanceof startingpage2ndpager||fragment5 instanceof Menu||fragment5 instanceof Photos||fragment5 instanceof Review||fragment5 instanceof About){
                        transaction.remove(fragment5);
                    }
                }
                transaction.commit();
                return;
            }

        }


        for (Fragment fragment4 : getSupportFragmentManager().getFragments()) {
            if (fragment4 instanceof giftbutton) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.remove(fragment4);
                transaction.commit();
                return;
            }

        }


        for (Fragment fragment3 : getSupportFragmentManager().getFragments()) {
            if (fragment3 instanceof farmfoodbutton) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.remove(fragment3);
                transaction.commit();
                return;
            }

        }


        for (Fragment fragment2 : getSupportFragmentManager().getFragments()) {
            if (fragment2 instanceof homemadebutton_fragment) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.remove(fragment2);
                transaction.commit();
                return;
            }

        }
        for (Fragment fragment1 : getSupportFragmentManager().getFragments()) {
            if (fragment1 instanceof restrobutton_fragmnet) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.remove(fragment1);
                transaction.commit();
                return;
            }

        }
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            if (fragment instanceof restro_farmfoodfragment) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.remove(fragment);
                transaction.commit();
                return;
            }
            for (Fragment fragmentnew : getSupportFragmentManager().getFragments()) {
                if (fragmentnew instanceof farm_giftFragment) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.remove(fragmentnew);
                    transaction.commit();
                    return;
                }

            }

        }


    }

    interface OnMenuAddListner {
        void onItemAdded(menulist data);
        void onItemUpdate(String name, String count);

    }

}

