package com.example.welcome.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.common.utils.StatusBarColorUtils;
import com.example.welcome.R;
import com.example.welcome.tabfragment.OneFragment;
import com.example.welcome.adapter.TabAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private View baseView;
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (baseView==null){
            baseView = inflater.inflate(R.layout.fragment_home,container,false);
        }
        tabLayout = baseView.findViewById(R.id.fg_welcome_tablayout);
        viewPager = baseView.findViewById(R.id.fg_welcome_viewpager);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new OneFragment());
        fragments.add(new OneFragment());
        fragments.add(new OneFragment());
        fragments.add(new OneFragment());
        fragments.add(new OneFragment());
        fragments.add(new OneFragment());
        fragments.add(new OneFragment());
        fragments.add(new OneFragment());
        List<String> strings = new ArrayList<>();
        strings.add("推荐");
        strings.add("推荐");
        strings.add("推荐");
        strings.add("推荐");
        strings.add("推荐");
        strings.add("推荐");
        strings.add("推荐");
        strings.add("推荐");
        TabAdapter tabAdapter = new TabAdapter(getActivity().getSupportFragmentManager(), TabAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments, strings);
        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);
        /**
         * 更改状态栏、字体颜色
         */
        StatusBarColorUtils.setStatusBarColor(getActivity(), Color.RED);
        StatusBarColorUtils.setAndroidNativeLightStatusBar(getActivity(),false);
        return baseView;
    }
}
