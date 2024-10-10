package com.example.bt6.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.bt6.fragment.viewPager_frag.fragment_viewpager_1;
import com.example.bt6.fragment.viewPager_frag.fragment_viewpager_2;
import com.example.bt6.fragment.viewPager_frag.fragment_viewpager_3;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new fragment_viewpager_1();
            case 1:
                return new fragment_viewpager_2();
            case 2:
                return new fragment_viewpager_3();
            default:
                return new fragment_viewpager_1();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Tab 1";
            case 1:
                return "Tab 2";
            case 2:
                return "Tab 3";
            default:
                return "Tab 1";
        }
    }
}
