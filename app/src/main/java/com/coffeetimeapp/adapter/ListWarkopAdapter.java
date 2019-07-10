package com.coffeetimeapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coffeetimeapp.ListWarkopActivity;
import com.coffeetimeapp.R;
import com.coffeetimeapp.model.Warkop;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListWarkopAdapter extends RecyclerView.Adapter<ListWarkopAdapter.UserviewHolder>{
    public ListWarkopAdapter(Context context,ArrayList<Warkop> mWordList) {
        this.mWordList = mWordList;
        this.context = context;
    }

    private final ArrayList<Warkop> mWordList;
    private Context context;



    static class UserviewHolder extends RecyclerView.ViewHolder {
        View mView;
        TextView namawarkop, alamatwarkop;

        public UserviewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            namawarkop = mView.findViewById(R.id.nama_warkop);
            alamatwarkop = mView.findViewById(R.id.alamat_warkop);
        }

        public void setnama_warkop(String nama_warkop){
            namawarkop.setText(nama_warkop);
        }

        public void setalamat_warkop(String alamat_warkop) {
            alamatwarkop.setText(alamat_warkop);
        }

    }




    @NonNull
    @Override
    public UserviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_warkop, parent, false);
        return new UserviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserviewHolder holder, int position) {
        //String id_warkop = getRef(position).getKey();
        holder.setnama_warkop(mWordList.get(position).getNama_warkop());
        holder.setalamat_warkop(mWordList.get(position).getAlamat_warkop());



        Log.e("test","test");

        //final String uid = model.getId();
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}

