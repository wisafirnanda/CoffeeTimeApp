package com.coffeetimeapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coffeetimeapp.R;
import com.coffeetimeapp.model.Pesanan;

import java.util.ArrayList;

public class PesananAdapter extends RecyclerView.Adapter<PesananAdapter.PesananViewHolder>  {

    private ArrayList<Pesanan> dataList;

    public PesananAdapter(ArrayList<Pesanan> dataList) {
        this.dataList = dataList;
    }

    @Override
    public PesananAdapter.PesananViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_list_pesanan, parent, false);
        return new PesananAdapter.PesananViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PesananAdapter.PesananViewHolder holder, int position) {
        //holder.id_kopi.setText(dataList.get(position).getId_kopi());
        holder.nama_user.setText(dataList.get(position).getNama_user());
        holder.nama_kopi.setText(dataList.get(position).getNama_kopi());
        holder.jenis_kopi.setText(dataList.get(position).getJenis_kopi());
        holder.jumlah_kopi.setText(dataList.get(position).getJumlah_kopi());
        holder.total_harga.setText(dataList.get(position).getTotal_harga());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class PesananViewHolder extends RecyclerView.ViewHolder{
        private TextView nama_user, nama_kopi, jenis_kopi, jumlah_kopi, total_harga;

        public PesananViewHolder(View itemView) {
            super(itemView);
            //id_kopi = itemView.findViewById(R.id.txt_nama_mahasiswa);
            nama_user = itemView.findViewById(R.id.nama_user);
            nama_kopi = itemView.findViewById(R.id.nama_kopi);
            jenis_kopi = itemView.findViewById(R.id.jenis_kopi);
            jumlah_kopi = itemView.findViewById(R.id.jumlah_kopi);
            total_harga = itemView.findViewById(R.id.total_harga);
        }
    }

}
