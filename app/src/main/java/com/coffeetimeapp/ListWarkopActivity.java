package com.coffeetimeapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coffeetimeapp.model.Warkop;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class ListWarkopActivity extends AppCompatActivity {

    private FirebaseDatabase checkindatabase;
    private FirebaseDatabase warkopdatabase;
    private FirebaseRecyclerAdapter<Warkop, UserviewHolder> adapter;
    private TextView Notifnull;
    private RecyclerView recyclerView;

    public ListWarkopActivity() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_warkop);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

        Query query = FirebaseDatabase.getInstance().getReference().child("warkop");
        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Warkop>()
                .setQuery(query, Warkop.class)
                .setLifecycleOwner(this)
                .build();
        if (this != null) {
            adapter = new FirebaseRecyclerAdapter<Warkop, UserviewHolder>(options) {
                @NonNull
                @Override
                public UserviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_warkop, parent, false);
                    return new UserviewHolder(view);
                }

                @Override
                protected void onBindViewHolder(@NonNull final UserviewHolder holder, int position, @NonNull Warkop model) {
                    holder.setnama_warkop(model.getnama_warkop());
                    holder.setnama_pemilik(model.getnama_pemilik());
                    holder.setcp_warkop(model.getcp_warkop());
                    holder.setwaktu_buka(model.getwaktu_buka());
                    holder.setalamat_warkop(model.getalamat_warkop());

                    final String uid = model.getId();
                }
            };

            recyclerView.setAdapter(adapter);
        }


    }

    /* @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_list_warkop, container, false);
        recyclerView = rootView.findViewById(R.id.listview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        Query query = FirebaseDatabase.getInstance().getReference().child("warkop");
        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Warkop>()
                .setQuery(query, Warkop.class)
                .setLifecycleOwner(getActivity())
                .build();
        if (getActivity() != null) {
            adapter = new FirebaseRecyclerAdapter<Warkop, UserviewHolder>(options) {
                @NonNull
                @Override
                public UserviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail_warkop, parent, false);
                    return new UserviewHolder(view);
                }

                @Override
                protected void onBindViewHolder(@NonNull final UserviewHolder holder, int position, @NonNull Warkop model) {
                    holder.setnama_warkop(model.getnama_warkop());
                    holder.setnama_pemilik(model.getnama_pemilik());
                    holder.setcp_warkop(model.getcp_warkop());
                    holder.setwaktu_buka(model.getwaktu_buka());
                    holder.setalamat_warkop(model.getalamat_warkop());

                    final String uid = model.getId();
                }
            };
        }

        return rootView;
    }*/


    public class UserviewHolder extends RecyclerView.ViewHolder {
        View mView;
        TextView namawarkop, namapemilik, cpwarkop, waktubuka, alamatwarkop;

        public UserviewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            namawarkop = mView.findViewById(R.id.nama_warkop);
            namapemilik = mView.findViewById(R.id.nama_pemilik);
            cpwarkop = mView.findViewById(R.id.cp_warkop);
            waktubuka = mView.findViewById(R.id.waktu_buka);
            alamatwarkop = mView.findViewById(R.id.alamat_warkop);
        }

        public void setnama_warkop(String nama_warkop){
            namawarkop.setText(nama_warkop);
        }

        public void setnama_pemilik(String nama_pemilik) {
            namapemilik.setText(nama_pemilik);
        }

        public void setcp_warkop(String cp_warkop){
            cpwarkop.setText(cp_warkop);
        }

        public void setwaktu_buka(String waktu_buka) {
            waktubuka.setText(waktu_buka);
        }

        public void setalamat_warkop(String alamat_warkop) {
            alamatwarkop.setText(alamat_warkop);
        }


    }
    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}