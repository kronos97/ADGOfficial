package com.example.mayur.adgapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class IOSFusion extends AppCompatActivity {

    TextView title, message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iosfusion);

        title = (TextView) findViewById(R.id.IOSFusion);
        message = (TextView) findViewById(R.id.about_iosfusion);

        Firebase.setAndroidContext(this);

        final Firebase ref = new Firebase("https://adgvit-cb43c.firebaseio.com/");

        ref.child("Events/iOS Fusion").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println(snapshot.getValue());

                String title1=snapshot.getKey();
                String msg1= (String) snapshot.getValue();
                title.setText(title1);
                message.setText(msg1);

            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });

    }

}
