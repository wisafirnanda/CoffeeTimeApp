package com.coffeetimeapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.coffeetimeapp.model.Warkop;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TambahWarkopActivity extends Activity {
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;
    TextView txt_hasil, menudialog;
    String menu1text, menu2text, menu3text, menu4text;
    Button btndaftarwarkop;
    EditText nama_warkopText, nama_pemilikText, cp_warkopText, alamat_warkopText, waktu_bukaText, menuText, menu1, menu2, menu3, menu4;

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
        menuText   = findViewById(R.id.menu);
        menudialog = findViewById(R.id.menudialog);
    }

    public void tambahWarkop(View view) {
        String nama_warkop = nama_warkopText.getText().toString();
        String nama_pemilik = nama_pemilikText.getText().toString();
        String cp_warkop = cp_warkopText.getText().toString();
        String alamat_warkop = alamat_warkopText.getText().toString();
        String waktu_buka = waktu_bukaText.getText().toString();
        String menu = menuText.getText().toString();
        String key =  ref.child("warkop").push().getKey();

        ref.child("warkop").child(key).setValue(new Warkop(nama_warkop, nama_pemilik, cp_warkop,alamat_warkop, waktu_buka, menu, key)).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Intent intent = new Intent(TambahWarkopActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void menuDialog(View view) {
        menuText.setText(null);
        DialogForm();
    }

    // untuk mengosongi edittext
    private void kosong(){
        menu1.setText(null);
        menu2.setText(null);
        menu3.setText(null);
        menu4.setText(null);
    }

    private void DialogForm() {
        dialog = new AlertDialog.Builder(TambahWarkopActivity.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.form_menu, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("Form Menu");

        menu1 = dialogView.findViewById(R.id.menu1);
        menu2 = dialogView.findViewById(R.id.menu2);
        menu3 = dialogView.findViewById(R.id.menu3);
        menu4 = dialogView.findViewById(R.id.menu4);

        kosong();

        dialog.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                     menu1text = menu1.getText().toString();
                     menu2text = menu2.getText().toString();
                     menu3text = menu3.getText().toString();
                     menu4text = menu4.getText().toString();

                     dialog.dismiss();
                 }
             });


        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}