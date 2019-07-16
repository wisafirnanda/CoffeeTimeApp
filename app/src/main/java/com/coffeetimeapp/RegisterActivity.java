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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends Activity {
    Button btndaftar;
    EditText namaText, emailText, phoneText, passwordText;
    TextView masuk;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();

    String nama, email, phone, password ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        btndaftar = findViewById(R.id.btndaftarwarkop);
        masuk = findViewById(R.id.masuk);

        namaText = findViewById(R.id.nama);
        emailText = findViewById(R.id.email);
        phoneText = findViewById(R.id.phone);
        passwordText = findViewById(R.id.password);
    }

    public void validasi (){
        nama = namaText.getText().toString();
        email = emailText.getText().toString();
        phone = phoneText.getText().toString();
        password = passwordText.getText().toString();

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

        if (password.length() < 8){
            //firebase auth cant create user with password < 8 character
            //firebase auth cant create user with same email, so if you wanna re-create user with exiest email,
            //please delete user data in firebase auth
            Toast.makeText(this, "Password tidak boleh kurang dari 8 character", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public void daftarwarkop(View view){

        validasi();

        //dismis dialog
        progressDialog.setMessage("Register User..");
        progressDialog.show();

        //call method for create user in firebase auth
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            //if succes, then save data user in firebase database
                            registerSaveToDatabase(firebaseAuth.getCurrentUser().getUid(),0);
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(RegisterActivity.this, "Registrasi gagal",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void daftarclient(View view) {
        validasi();

        //dismis dialog
        progressDialog.setMessage("Register User..");
        progressDialog.show();

        //call method for create user in firebase auth
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            //if succes, then save data user in firebase database
                            registerSaveToDatabase(firebaseAuth.getCurrentUser().getUid(),1);
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(RegisterActivity.this, "Registrasi gagal",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void registerSaveToDatabase(String userID, int tipeUser) {

        String nama = namaText.getText().toString();
        String email = emailText.getText().toString();
        String phone = phoneText.getText().toString();
        String password = passwordText.getText().toString();

        ref = FirebaseDatabase.getInstance().getReference().child("user").child(userID);
        HashMap<String,String> userMap = new HashMap<>();
        userMap.put("nama",nama);
        userMap.put("email",email);
        userMap.put("phone",phone);
        userMap.put("password",password);
        userMap.put("uid",userID);
        userMap.put("tipe_user",String.valueOf(tipeUser));

        ref.setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    //data user succes save in database
                    //then Go to mainActivity
                    Toast.makeText(RegisterActivity.this, "Registrasi sukses", Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(RegisterActivity.this, "Registrasi Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*ref.child("user").push().setValue(new User(nama,email,phone,password)).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(RegisterActivity.this, "Registrasi sukses", Toast.LENGTH_SHORT).show();
                finish();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });*/
    }

    public void masuk(View view) {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }


}