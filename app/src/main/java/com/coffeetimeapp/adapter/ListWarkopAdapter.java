package com.coffeetimeapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coffeetimeapp.ListWarkopActivity;
import com.coffeetimeapp.R;

import java.util.LinkedList;

public class ListWarkopAdapter extends RecyclerView.Adapter<ListWarkopAdapter.ItemViewHolder>{

    private final LinkedList<String> mWordList;
    private final LayoutInflater mInflater;

    public void setClickListener(ListWarkopActivity listWarkopActivity) {
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView wordItemView;
        final ListWarkopAdapter mAdapter;

        public ItemViewHolder(View itemView, ListWarkopAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.name);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
    
    public ListWarkopAdapter (Context context, LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate an item view.
        View mItemView = mInflater.inflate(R.layout.activity_list_warkop, parent, false);
        return new ItemViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        // Retrieve the data for that position.
        String mCurrent = mWordList.get(position);

        // Add the data to the view holder.
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}

