package com.example.cityparcel_listpassed_method;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.cityparcel_listpassed_method.Fragment.Startingpagefragment;

public class MypagerAdapter extends FragmentPagerAdapter {
    Context context;

    public MypagerAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Startingpagefragment();
            case 1:
                return new shopping();
            case 2:
                return new fineding_fragment();
            case 3:
                return new Accunt();
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return 4;
    }
}
