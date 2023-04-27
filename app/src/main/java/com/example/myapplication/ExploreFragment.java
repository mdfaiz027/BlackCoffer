package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.adapter.MyPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class ExploreFragment extends Fragment {

    // Initialize variables
    View myFragment;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_explore, container, false);

        // assign variable
        tabLayout=view.findViewById(R.id.tabLayout);
        viewPager=view.findViewById(R.id.viewPager);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tabLayout.setupWithViewPager(viewPager);

        // Set up the ViewPager with a FragmentPagerAdapter
        MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);

        // Set the icons for each tab
        tabLayout.getTabAt(0).setIcon(R.drawable.group);
        tabLayout.getTabAt(1).setIcon(R.drawable.briefcase);
        tabLayout.getTabAt(2).setIcon(R.drawable.market);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}