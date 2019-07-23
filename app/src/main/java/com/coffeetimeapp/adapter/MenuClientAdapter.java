package com.coffeetimeapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coffeetimeapp.R;
import com.coffeetimeapp.model.Menu;

import java.util.ArrayList;

public class MenuClientAdapter extends RecyclerView.Adapter<MenuClientAdapter.MenuClientViewHolder> {

    private ArrayList<Menu> dataList;

    public MenuClientAdapter(ArrayList<Menu> dataList) {
        this.dataList = dataList;
    }

    @Override
    public MenuClientAdapter.MenuClientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_list_menu_client, parent, false);
        return new MenuClientAdapter.MenuClientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuClientAdapter.MenuClientViewHolder holder, int position) {
        //holder.id_kopi.setText(dataList.get(position).getId_kopi());
        holder.nama_kopi.setText(dataList.get(position).getNama_kopi());
        holder.jenis_kopi.setText(dataList.get(position).getJenis_kopi());
        holder.harga_kopi.setText(dataList.get(position).getHarga_kopi());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class MenuClientViewHolder extends RecyclerView.ViewHolder{
        private TextView id_kopi, nama_kopi, jenis_kopi, harga_kopi;

        public MenuClientViewHolder(View itemView) {
            super(itemView);
            //id_kopi = itemView.findViewById(R.id.id_kopi);
            nama_kopi = itemView.findViewById(R.id.nama_kopi);
            jenis_kopi = itemView.findViewById(R.id.jenis_kopi);
            harga_kopi = itemView.findViewById(R.id.harga_kopi);
        }
    }
}
