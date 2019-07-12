package com.coffeetimeapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coffeetimeapp.DetailWarkopActivity;
import com.coffeetimeapp.R;
import com.coffeetimeapp.model.Warkop;

import java.util.ArrayList;

public class ListWarkopAdapter extends RecyclerView.Adapter<ListWarkopAdapter.UserviewHolder>{

    private final ArrayList<Warkop> mWordList;
    private Context context;

    public ListWarkopAdapter(Context context,ArrayList<Warkop> mWordList) {
        this.mWordList = mWordList;
        this.context = context;
    }

    static class UserviewHolder extends RecyclerView.ViewHolder {
        View mView;
        RelativeLayout detailWarkopLayout;
        TextView namawarkop, alamatwarkop;

        public UserviewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            detailWarkopLayout = mView.findViewById(R.id.warkopDetailLayout);
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
    public void onBindViewHolder(@NonNull UserviewHolder holder, final int position) {
        //String id_warkop = getRef(position).getKey();
        holder.setnama_warkop(mWordList.get(position).getNama_warkop());
        holder.setalamat_warkop(mWordList.get(position).getAlamat_warkop());

        holder.detailWarkopLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailWarkopActivity.class);
                intent.putExtra("warkop_key", mWordList.get(position).getKey());

                context.startActivity(intent);
            }
        });

        Log.e("test","test");

        //final String uid = model.getId();
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}

