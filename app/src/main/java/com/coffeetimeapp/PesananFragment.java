package com.coffeetimeapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coffeetimeapp.adapter.PesananAdapter;
import com.coffeetimeapp.model.Pesanan;

import java.util.ArrayList;

public class PesananFragment extends Fragment {

    private RecyclerView recyclerView;
    private PesananAdapter adapter;
    private ArrayList<Pesanan> pesananArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pesanan, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);

        addData();

        adapter = new PesananAdapter(pesananArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }

    void addData(){
        pesananArrayList = new ArrayList<>();
        pesananArrayList.add(new Pesanan("Wisa", "Sanger", "Kopi jadi", "x 2", "10.000"));
        pesananArrayList.add(new Pesanan("Nanda", "Arabica Gayo", "Bubuk", "x 1", "30.000"));
    }
}
