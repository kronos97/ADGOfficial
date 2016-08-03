package com.example.mayur.adgapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Home extends Fragment {

    String items[]={"Wow!Random tech news","Google buys it back!","Microsoft buys Nexus!","Google buys Apple","Steve Jobs plays football","Jobs buys Chelsea","Chelsea wins the premier league","Jobs NOT Dead", "Larry Page secret project", "Resurrection!!", "India wins 71 golds in Rio","Yahoo! goes BANKRUPT!","RAM! the new tech super power in the park!!"};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_home, container, false);

        return rootView;


    }


}


