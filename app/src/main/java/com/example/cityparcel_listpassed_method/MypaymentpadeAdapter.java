package com.example.cityparcel_listpassed_method;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MypaymentpadeAdapter extends FragmentPagerAdapter {
    menupaymenttab_fragment context;

    public MypaymentpadeAdapter(@NonNull FragmentManager fm, menupaymenttab_fragment context) {
        super(fm);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Addressupdate();
            case 1:
                return new paymenttab();
            case 2:
                return new complete();

            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
