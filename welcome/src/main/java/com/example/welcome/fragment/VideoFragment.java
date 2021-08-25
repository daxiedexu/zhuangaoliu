package com.example.welcome.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.welcome.R;

public class VideoFragment extends Fragment {
    private View baseView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (baseView==null){
            baseView = inflater.inflate(R.layout.fragment_message,container,false);
        }
        return baseView;
    }
}
