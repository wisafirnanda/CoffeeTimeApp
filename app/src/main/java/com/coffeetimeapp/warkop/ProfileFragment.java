package com.coffeetimeapp.warkop;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.coffeetimeapp.LoginActivity;
import com.coffeetimeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment {

    private Bundle bundle;
    private DatabaseReference reference;
    TextView namawarkop, namapemilik, cpwarkop, alamatwarkop, waktubuka, menu;
    Button btnlogout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        namawarkop = view.findViewById(R.id.nama_warkop);
        namapemilik = view.findViewById(R.id.nama_pemilik);
        cpwarkop = view.findViewById(R.id.cp_warkop);
        alamatwarkop = view.findViewById(R.id.alamat_warkop);
        waktubuka = view.findViewById(R.id.waktu_buka);
        btnlogout = view.findViewById(R.id.btn_logout);
        //menu = view.findViewById(R.id.menu);

        bundle = getActivity().getIntent().getExtras();
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

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
