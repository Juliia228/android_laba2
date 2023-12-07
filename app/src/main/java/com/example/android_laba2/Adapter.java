package com.example.android_laba2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private final ArrayList<MainActivity.Item> Data;

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return Data.size();
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
//        Log.d("Adapter", "OnCreateViewHolder");
        return new MyViewHolder(view);
    }

    public void onBindViewHolder(MyViewHolder vh, int position) {
//        Log.d("Adapter", "OnBindViewHolder for position: " + position);
        MainActivity.Item item = Data.get(position);
        vh.name.setText(item.Name);
        vh.description.setText(item.Description);
        //vh.mTextView.setText(Data.get(position).Name);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public Adapter(ArrayList<MainActivity.Item> list) {
        Data = list;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView description;
        public MyViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.name);
            description = v.findViewById(R.id.description);
        }
    }
}
