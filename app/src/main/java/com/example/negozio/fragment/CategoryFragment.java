package com.example.negozio.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.negozio.HomeModel;
import com.example.negozio.R;
import com.example.negozio.SectionAdapter;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    private int mPosition;

    public CategoryFragment( int position) {
        mPosition=position;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        ViewPager viewPager= view.findViewById(R.id.viewPager);
        TabLayout tabLayout= view.findViewById(R.id.tabLayout);
        SectionAdapter adapter = new SectionAdapter(getChildFragmentManager(),getContext());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(mPosition);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

}
