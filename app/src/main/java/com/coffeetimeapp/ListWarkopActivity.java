package com.coffeetimeapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coffeetimeapp.model.WarkopForList;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class ListWarkopActivity extends AppCompatActivity {

    private FirebaseDatabase checkindatabase;
    private FirebaseDatabase warkopdatabase;
    private FirebaseRecyclerAdapter<WarkopForList, UserviewHolder> adapter;
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

        Query query = FirebaseDatabase.getInstance().getReference().child("warkop").limitToLast(50);
        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<WarkopForList>()
                .setQuery(query, WarkopForList.class)
                .setLifecycleOwner(this)
                .build();
        adapter = new FirebaseRecyclerAdapter<WarkopForList, UserviewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull UserviewHolder holder, int position, @NonNull WarkopForList model) {

                String id_warkop = getRef(position).getKey();
                Log.e("id_warkop",""+id_warkop);
                holder.setnama_warkop(model.getNama_warkop());
                holder.setalamat_warkop(model.getAlamat_warkop());

                Log.e("test","test");

                //final String uid = model.getId();
            }

            @NonNull
            @Override
            public UserviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_warkop, parent, false);
                return new UserviewHolder(view);
            }
        };



        recyclerView.setAdapter(adapter);

        Log.e("adapter size",""+adapter.getItemCount());





    }


    public class UserviewHolder extends RecyclerView.ViewHolder {
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