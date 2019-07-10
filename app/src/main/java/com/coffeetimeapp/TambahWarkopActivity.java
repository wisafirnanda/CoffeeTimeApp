package com.coffeetimeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.coffeetimeapp.model.WarkopTest;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TambahWarkopActivity extends Activity {
    Button btndaftarwarkop;
    EditText nama_warkopText, nama_pemilikText, cp_warkopText, alamat_warkopText, waktu_bukaText, menuText;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_warkop);

        btndaftarwarkop = findViewById(R.id.btndaftarwarkop);

        nama_warkopText = findViewById(R.id.nama_warkop);
        nama_pemilikText = findViewById(R.id.nama_pemilik);
        cp_warkopText = findViewById(R.id.cp_warkop);
        alamat_warkopText = findViewById(R.id.alamat_warkop);
        waktu_bukaText = findViewById(R.id.waktu_buka);
        menuText = findViewById(R.id.menu);
    }

    public void tambahWarkop(View view) {
        String nama_warkop = nama_warkopText.getText().toString();
        String nama_pemilik = nama_pemilikText.getText().toString();
        String cp_warkop = cp_warkopText.getText().toString();
        String alamat_warkop = alamat_warkopText.getText().toString();
        String waktu_buka = waktu_bukaText.getText().toString();
        String menu = menuText.getText().toString();

        ref.child("warkop").push().setValue(new WarkopTest(nama_warkop, nama_pemilik, cp_warkop,alamat_warkop, waktu_buka, menu)).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Intent intent = new Intent(TambahWarkopActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}