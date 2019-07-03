package com.coffeetimeapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.coffeetimeapp.adapter.ListWarkopAdapter;
import com.coffeetimeapp.model.ListWarkopModel;

import java.util.ArrayList;

/**
 * Created by wahyu on 15/11/16.
 */

@SuppressLint("ValidFragment")
public class ListWarkopFragment extends Fragment implements ListWarkopClickListener{
    int wizard_page_position;

    public ListWarkopFragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.fragmen_list_warkop;
        View view = inflater.inflate(layout_id, container, false);

        ArrayList<ListWarkopModel> rowListItem = getAllItemList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        RecyclerView rView = (RecyclerView)view.findViewById(R.id.recyclerView);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(layoutManager);
        rView.setNestedScrollingEnabled(false);
        rView.setHasFixedSize(false);

        ListWarkopAdapter rcAdapter = new ListWarkopAdapter(getActivity(), rowListItem);
        rView.setAdapter(rcAdapter);
        rcAdapter.setClickListener(this);
        return view;
    }

    private ArrayList<ListWarkopModel> getAllItemList(){
        ArrayList<ListWarkopModel> allItems = new ArrayList<ListWarkopModel>();
        ListWarkopModel dt;

        dt = new ListWarkopModel("Sky Blue Dress","192","ecommerce/style-9/Ecommerce-9-img-1.jpg");
        allItems.add(dt);
        dt = new ListWarkopModel("Velcro Sneaker White","225","ecommerce/style-9/Ecommerce-9-img-2.jpg");
        allItems.add(dt);

        dt = new ListWarkopModel("Sky Blue Dress","192","ecommerce/style-9/Ecommerce-9-img-1.jpg");
        allItems.add(dt);
        dt = new ListWarkopModel("Velcro Sneaker White","225","ecommerce/style-9/Ecommerce-9-img-2.jpg");
        allItems.add(dt);

        return  allItems;
    }

    @Override
    public void itemClicked(View view, int position) {
        int num = position + 1;
        Toast.makeText(getActivity(), "Position " + num + " clicked!", Toast.LENGTH_SHORT).show();
    }
}
