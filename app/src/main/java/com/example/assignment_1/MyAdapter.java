package com.example.assignment_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<Items> items;
    private Context context;


    public MyAdapter(ArrayList<Items> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Items item = items.get(position);
        String imageUrl = item.getImageUrl(); // Replace with your image URL
        ImageView itemImage = holder.itemView.findViewById(R.id.item_image);

        Picasso.get().load(imageUrl).into(itemImage);

        holder.itemNameTextView.setText(item.getItemname());
        holder.priceTextView.setText(item.getPrice());
        holder.locationTextView.setText(item.getLocation());
        holder.dateTextView.setText(item.getDate());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemNameTextView;
        TextView priceTextView;
        TextView locationTextView;
        TextView dateTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            itemNameTextView = itemView.findViewById(R.id.itemname);
            priceTextView = itemView.findViewById(R.id.price);
            locationTextView = itemView.findViewById(R.id.location);
            dateTextView = itemView.findViewById(R.id.date);
        }
    }
}


