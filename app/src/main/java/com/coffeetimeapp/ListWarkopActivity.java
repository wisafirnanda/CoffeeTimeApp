package com.coffeetimeapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.coffeetimeapp.adapter.ListWarkopAdapter;
import com.coffeetimeapp.model.Warkop;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListWarkopActivity extends AppCompatActivity {

    private FirebaseDatabase checkindatabase;
    private FirebaseDatabase warkopdatabase;
    private ListWarkopAdapter adapter;
    private TextView Notifnull;
    private RecyclerView recyclerView;
    private ArrayList<Warkop> listwarkop = new ArrayList<>();
    private Warkop warkopmodel;

    public ListWarkopActivity() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_warkop);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        //recyclerView.setAdapter(adapter);

        getListWarkop();
    }

    private void getListWarkop() {
        if (listwarkop != null){
            listwarkop.clear();
        }
        final ArrayList<String> children_listwarkop = new ArrayList<>();
            FirebaseDatabase.getInstance().getReference().child("warkop").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (final DataSnapshot snapshot : dataSnapshot.getChildren()){
                        String test = snapshot.getKey();
                        FirebaseDatabase.getInstance().getReference().child("warkop").child(test).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                Log.d("snapshow value",""+snapshot.getValue());
                                warkopmodel = new Warkop(snapshot.child("nama_warkop").getValue().toString(),
                                        snapshot.child("nama_pemilik").getValue().toString(),
                                        snapshot.child("cp_warkop").getValue().toString(),
                                        snapshot.child("alamat_warkop").getValue().toString(),
                                        snapshot.child("waktu_buka").getValue().toString(),
                                        snapshot.getKey());

                                listwarkop.add(warkopmodel);

                                //set to adapter
                                adapter = new ListWarkopAdapter(ListWarkopActivity.this,listwarkop);
                                recyclerView.setAdapter(adapter);
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

}