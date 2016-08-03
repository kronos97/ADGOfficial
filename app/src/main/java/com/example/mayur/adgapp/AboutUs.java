package com.example.mayur.adgapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class AboutUs extends Fragment {

    ListView listView;
    //int image[]=new int[] {R.drawable.adg,R.drawable.apple_cover,R.drawable.apple_cover2,R.drawable.apple_cover3,R.drawable.apple_cover4,R.drawable.apple_cover5};
        int image[] = new int[]{R.drawable.adg};
   /* String title[]=new String[]{"Random title","Random title","Random title","Random title","Random title","Random title"};
    String msg[]=new String[]{"Cool messages","Cool messages","Cool messages","Cool messages","Cool messages","Cool messages"};
*/
    String title[]=new String[6];
    String message[]=new String[6];
    int r=0;
    AboutUsAdapter aboutUsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_about_us, container, false);

        Firebase.setAndroidContext(getContext());

        final Firebase ref = new Firebase("https://adgvit-cb43c.firebaseio.com/");

        ref.child("About Us").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println(snapshot.getValue());
                    /*String x= (String) snapshot.getKey();
                    title[r]=x;
                    String y= (String) snapshot.getValue();
                    message[r]=y;
                    r++;*/
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });



        listView= (ListView) rootView.findViewById(R.id.about_us_list);
        int i=0;
        aboutUsAdapter = new AboutUsAdapter(getActivity(),R.layout.home_row_layout);
        listView.setAdapter(aboutUsAdapter);
        for(String flag : title)
        {
            AboutUsModel model = new AboutUsModel(title[i],message[i],image[0]);
            aboutUsAdapter.add(model);
            i++;
        }


        return rootView;

        }

    }