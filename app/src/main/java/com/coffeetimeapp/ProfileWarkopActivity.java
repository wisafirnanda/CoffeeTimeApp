package com.coffeetimeapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileWarkopActivity extends Activity {

    private Bundle bundle;
    private DatabaseReference reference;
    TextView nama, email, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_warkop);

        nama = findViewById(R.id.nama);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);

        bundle = getIntent().getExtras();
        reference = FirebaseDatabase.getInstance().getReference().child("user");

        if(bundle!=null)
        {
            String key = bundle.getString("uid");

            reference.orderByKey().equalTo(key).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot)
                {
                    for (DataSnapshot data : dataSnapshot.getChildren())
                    {
                        nama.setText(data.child("nama").getValue().toString());
                        email.setText(data.child("email").getValue().toString());
                        phone.setText(data.child("phone").getValue().toString());
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
}
