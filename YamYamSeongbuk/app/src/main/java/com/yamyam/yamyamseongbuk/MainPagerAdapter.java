package com.yamyam.yamyamseongbuk;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

class MainPagerAdapter extends FragmentPagerAdapter {

        // 필수 생성자
        MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public MainPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Override
        public Fragment getItem ( int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new TrendFragment();
            case 2:
                return new CourseFragment();
            default:
                return new MyFragment();
        }
    }

        @Override
        public int getCount () {
        return 4;
    }

}