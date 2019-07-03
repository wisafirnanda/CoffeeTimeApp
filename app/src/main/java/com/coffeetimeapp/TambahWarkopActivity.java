package com.coffeetimeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.coffeetimeapp.model.Warkop;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

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

        ref = FirebaseDatabase.getInstance().getReference().child("warkop").child(id_warkop);
        HashMap<String,String> userMap = new HashMap<>();
        userMap.put("nama_warkop",nama_warkop);
        userMap.put("nama_pemilik",nama_pemilik);
        userMap.put("cp_warkop",cp_warkop);
        userMap.put("alamat_warkop",alamat_warkop);
        userMap.put("waktu_buka",waktu_buka);
        userMap.put("menu",menu);

        ref.setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    //data user succes save in database
                    //then Go to mainActivity
                    Toast.makeText(RegisterActivity.this, "Registrasi sukses", Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(RegisterActivity.this, "Registrasi Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /* ref.child("warkop").push().setValue(new Warkop(nama_warkopText,nama_pemilikText,cp_warkopText,alamat_warkopText,waktu_bukaText,menuText)).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Intent intent = new Intent(TambahWarkopActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }); */
    }
}