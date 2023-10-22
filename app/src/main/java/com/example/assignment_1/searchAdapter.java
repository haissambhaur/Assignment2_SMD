package com.example.assignment_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class searchAdapter extends RecyclerView.Adapter<searchAdapter.ViewHolder> implements Filterable {
    private List<Items> originalList;
    private List<Items> filteredList;

    public searchAdapter(ArrayList<Items> itemList) {
        this.originalList = new ArrayList<>(itemList); // Initialize originalList with a copy of the items
        this.filteredList = new ArrayList<>(itemList);
    }
    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemsearch, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Items item = filteredList.get(position);
        // Bind your data to the views in the ViewHolder
        holder.itemNameTextView.setText(item.getItemname());
        // Bind other item data here
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String query = constraint.toString().toLowerCase().trim();
                filteredList.clear();

                if (query.isEmpty()) {
                    filteredList.addAll(originalList);
                } else {
                    for (Items item : originalList) {
                        if (item.getItemname().toLowerCase().contains(query)) {
                            filteredList.add(item);
                        }
                    }
                }

                FilterResults results = new FilterResults();
                results.values = filteredList;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
//                originalList = (ArrayList<Items>) FilterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    // ViewHolder class

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemNameTextView;

        ViewHolder(View itemView) {
            super(itemView);
            itemNameTextView = itemView.findViewById(R.id.itemNameTextView);
            // Initialize other views here
        }
    }
}
