package com.coffeetimeapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.coffeetimeapp.adapter.MenuKopiAdapter;
import com.coffeetimeapp.model.Kopi;

import java.util.ArrayList;

public class MenuFragment extends Fragment {

    private RecyclerView recyclerView;
    private MenuKopiAdapter adapter;
    private ArrayList<Kopi> kopiArrayList;

    private FloatingActionButton tambah_menu;

    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;
    EditText nama_kopi, jenis_kopi, harga_kopi;
    TextView txt_hasil;
    String namakopi, jeniskopi, hargakopi;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        //testambah = view.findViewById(R.id.testambah);
        tambah_menu = view.findViewById(R.id.tambah_menu);
        recyclerView = view.findViewById(R.id.recyclerview);

        addData();

        adapter = new MenuKopiAdapter(kopiArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        tambah_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //txt_hasil.setText(null);
                DialogForm();
            }
        });

        return view;

    }

    void addData(){
        kopiArrayList = new ArrayList<>();
        kopiArrayList.add(new Kopi("Sanger", "Kopi jadi", "Rp. 5.000"));
        kopiArrayList.add(new Kopi("Arabica Gayo", "Bubuk kopi", "Rp. 30.000"));
        kopiArrayList.add(new Kopi("Espresso", "Kopi jadi", "Rp. 10.000"));
        kopiArrayList.add(new Kopi("Sanger", "Kopi jadi", "Rp. 5.000"));
        kopiArrayList.add(new Kopi("Arabica Gayo", "Bubuk kopi", "Rp. 30.000"));
        kopiArrayList.add(new Kopi("Espresso", "Kopi jadi", "Rp. 10.000"));
    }

    private void DialogForm() {
        dialog = new AlertDialog.Builder(getActivity());
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.form_menu, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("Form Tambah Menu");

        nama_kopi = dialogView.findViewById(R.id.nama_kopi);
        jenis_kopi = dialogView.findViewById(R.id.jenis_kopi);
        harga_kopi = dialogView.findViewById(R.id.harga_kopi);

        kosong();

        dialog.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                /*nama    = txt_nama.getText().toString();
                usia    = txt_usia.getText().toString();
                alamat  = txt_alamat.getText().toString();
                status = txt_status.getText().toString();

                txt_hasil.setText("Nama : " + nama + "\n" + "Usia : " + usia + "\n" + "Alamat : " + alamat + "\n" + "Status : " + status);
                dialog.dismiss();*/
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

    // untuk mengosongi edittext
    private void kosong(){
        nama_kopi.setText(null);
        jenis_kopi.setText(null);
        harga_kopi.setText(null);
    }
}
