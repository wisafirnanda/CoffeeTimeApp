package com.coffeetimeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.coffeetimeapp.model.Warkop;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TambahWarkopActivity extends Activity {
    Button btndaftarwarkop;
    EditText nama_warkop, nama_pemilik, cp_warkop, alamat_warkop, waktu_buka, menu;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_warkop);

        btndaftarwarkop = findViewById(R.id.btndaftarwarkop);

        nama_warkop = findViewById(R.id.nama_warkop);
        nama_pemilik = findViewById(R.id.nama_pemilik);
        cp_warkop = findViewById(R.id.cp_warkop);
        alamat_warkop = findViewById(R.id.alamat_warkop);
        waktu_buka = findViewById(R.id.waktu_buka);
        menu = findViewById(R.id.menu);
    }

    public void tambahWarkop(View view) {
        String nama_warkopText = nama_warkop.getText().toString();
        String nama_pemilikText = nama_pemilik.getText().toString();
        String cp_warkopText = cp_warkop.getText().toString();
        String alamat_warkopText = alamat_warkop.getText().toString();
        String waktu_bukaText = waktu_buka.getText().toString();
        String menuText = menu.getText().toString();

        ref.child("warkop").push().setValue(new Warkop(nama_warkopText,nama_pemilikText,cp_warkopText,alamat_warkopText,waktu_bukaText,menuText)).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Intent intent = new Intent(TambahWarkopActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}