package com.example.mayur.adgapp;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class Events extends Fragment {

    public int currentimageindex=0;
    ImageView event_top;
    ImageView event_middle;
    ImageView  event_bottomleft;
    ImageView event_bottomright;

    private int[] IMAGE_IDS = {R.drawable.event5,R.drawable.slider_image};

    private int[] IMAGE_IDS1 = {R.drawable.event2,R.drawable.slider_image};

    private int[] IMAGE_IDS2 = {R.drawable.event4,R.drawable.slider_image};

    private int[] IMAGE_IDS3 = {R.drawable.event3,R.drawable.slider_image};



    @Nullable
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            Activity a = getActivity();
            if(a != null) a.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_events, container, false);
        //add image slideshow
        final Handler mHandler = new Handler();

        // Create runnable for posting
        final Runnable mUpdateResults = new Runnable() {
            public void run() {

                AnimateandSlideShow(rootView);

            }
        };

        int delay = 4000;
        int period = 4000;

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {

                mHandler.post(mUpdateResults);
            }
        }, delay, period);


        return rootView;

    }

    private void AnimateandSlideShow(View rootView) {

        event_top = (ImageView) rootView.findViewById(R.id.event_image_top);
        event_top.setImageResource(IMAGE_IDS[currentimageindex%IMAGE_IDS.length]);
        event_middle= (ImageView) rootView.findViewById(R.id.event_image_middle);
        event_middle.setImageResource(IMAGE_IDS1[currentimageindex%IMAGE_IDS1.length]);
        event_bottomleft= (ImageView) rootView.findViewById(R.id.event_image_bottomleft);
        event_bottomleft.setImageResource(IMAGE_IDS2[currentimageindex%IMAGE_IDS2.length]);
        event_bottomright= (ImageView) rootView.findViewById(R.id.event_image_bottomright);
        event_bottomright.setImageResource(IMAGE_IDS3[currentimageindex%IMAGE_IDS3.length]);

        currentimageindex++;

        Animation rotateimage = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);

        event_top.startAnimation(rotateimage);
        event_middle.startAnimation(rotateimage);
        event_bottomleft.startAnimation(rotateimage);
        event_bottomright.startAnimation(rotateimage);

        event_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),IOSFusion.class);
                getActivity().startActivity(intent);
            }
        });

        event_middle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getActivity(),AppAThon.class);
                getActivity().startActivity(intent1);
            }
        });

        event_bottomleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getActivity(),MacAnApp.class);
                getActivity().startActivity(intent2);
            }
        });

        event_bottomright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getActivity(),UniDev.class);
                getActivity().startActivity(intent3);
            }
        });


    }




}



