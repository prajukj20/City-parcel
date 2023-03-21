package com.example.cityparcel_listpassed_method;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.cityparcel_listpassed_method.Fragment.Startingpagefragment;

public class MypagerAdapter2 extends FragmentPagerAdapter {
    Context context;

    public MypagerAdapter2(@NonNull FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Menu();
            case 1:
                return new Photos();
            case 2:
                return new Review();
            case 3:
                return new About();
            default:
                return new Menu();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
