package com.coffeetimeapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.coffeetimeapp.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends Activity {
    Button btndaftar;
    EditText namaText, emailText, phoneText, passwordText;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        btndaftar = findViewById(R.id.btndaftar);

        namaText = findViewById(R.id.nama);
        emailText = findViewById(R.id.email);
        phoneText = findViewById(R.id.phone);
        passwordText = findViewById(R.id.password);
    }

    private void registerUser(){
        String nama = namaText.getText().toString();
        String email = emailText.getText().toString();
        String phone = phoneText.getText().toString();
        String password = passwordText.getText().toString();

        if (TextUtils.isEmpty(nama)){
            Toast.makeText(this, "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(phone)){
            Toast.makeText(this, "Nomor tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Email tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Register User..");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "Registrasi sukses", Toast.LENGTH_SHORT).show();
                            finish();
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(RegisterActivity.this, "Registrasi gagal",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void register(View view) {

        registerUser();

        String nama = namaText.getText().toString();
        String email = emailText.getText().toString();
        String phone = phoneText.getText().toString();
        String password = passwordText.getText().toString();

        ref.child("user").push().setValue(new User(nama,email,phone,password)).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

            }
        });
    }
}