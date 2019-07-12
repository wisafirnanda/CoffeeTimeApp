package com.coffeetimeapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailWarkopActivity extends Activity {

    private Bundle bundle;
    private DatabaseReference reference;
    TextView namawarkop, namapemilik, cpwarkop, alamatwarkop, waktubuka, menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_warkop);

        namawarkop = findViewById(R.id.nama_warkop);
        namapemilik = findViewById(R.id.nama_pemilik);
        cpwarkop = findViewById(R.id.cp_warkop);
        alamatwarkop = findViewById(R.id.alamat_warkop);
        waktubuka = findViewById(R.id.waktu_buka);
        menu = findViewById(R.id.menu);

        bundle = getIntent().getExtras();
        reference = FirebaseDatabase.getInstance().getReference().child("warkop");

        if(bundle!=null)
        {
            String key = bundle.getString("warkop_key");

            reference.orderByKey().equalTo(key).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot)
                {
                    for (DataSnapshot data : dataSnapshot.getChildren())
                    {
                        namawarkop.setText(data.child("nama_warkop").getValue().toString());
                        namapemilik.setText(data.child("nama_pemilik").getValue().toString());
                        cpwarkop.setText(data.child("cp_warkop").getValue().toString());
                        alamatwarkop.setText(data.child("alamat_warkop").getValue().toString());
                        waktubuka.setText(data.child("waktu_buka").getValue().toString());
                        menu.setText(data.child("menu").getValue().toString());
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
}
