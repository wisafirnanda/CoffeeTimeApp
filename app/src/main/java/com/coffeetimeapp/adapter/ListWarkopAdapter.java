package com.coffeetimeapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.coffeetimeapp.ListWarkopClickListener;
import com.coffeetimeapp.R;
import com.coffeetimeapp.model.ListWarkopModel;

import java.util.ArrayList;

public class ListWarkopAdapter extends RecyclerView.Adapter<ListWarkopAdapter.ItemViewHolder> {
    private static ArrayList<ListWarkopModel> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private ListWarkopClickListener clicklistener = null;

    public ListWarkopAdapter(Context ctx, ArrayList<ListWarkopModel> data) {
        context = ctx;
        dataList = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView image;
        private TextView title;
        private CardView butttonShoppingCart,butttonLove;

        public ItemViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            image = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
            butttonShoppingCart = (CardView) itemView.findViewById(R.id.butttonShoppingCart);
            butttonShoppingCart.setOnClickListener(this);
            butttonLove = (CardView) itemView.findViewById(R.id.butttonLove);
            butttonLove.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.butttonShoppingCart:
                    int pos = getAdapterPosition() + 1;
                    Toast.makeText(context, "Button Shopping Cart " + pos + " clicked!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.butttonLove:
                    int pos2 = getAdapterPosition() + 1;
                    Toast.makeText(context, "Button Love " + pos2 + " clicked!", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    if (clicklistener != null) {
                        clicklistener.itemClicked(view, getAdapterPosition());
                    }
                    break;
            }

        }
    }

    public void setClickListener(ListWarkopClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_warkop, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

    }

    /* @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Glide.with(context)
                .load(BuildConfig.IMAGE_URL + dataList.get(position).getImageUrl())
                .thumbnail(0.01f)
                .centerCrop()
                .into(holder.image);
        holder.title.setText(dataList.get(position).getTitle());
    } */

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
