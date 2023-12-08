package com.example.android_laba2;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import android.annotation.SuppressLint;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private final ArrayList<Product> Data;
    public Adapter(ArrayList<Product> list) {
        Data = list;
    }

    static class Product {
        String Name;
        String Description;
        Product() {
            Name = "";
            Description = "";
        }
        Product(String name, String description) {
            Name = name;
            Description = description;
        }
    }

    @Override
    public int getItemCount() {
        return Data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, description;
        public ImageView edit, delete;
        public MyViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.name);
            description = v.findViewById(R.id.description);
            edit = v.findViewById(R.id.edit);
            delete = v.findViewById(R.id.delete);
        }
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(view);
    }

    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Product item = Data.get(position);
        holder.name.setText(item.Name);
        holder.description.setText(item.Description);
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addItemIntent = new Intent(v.getContext(), UpdateListActivity.class);
                addItemIntent.putExtra("is_update", true);
                addItemIntent.putExtra("id", position);
                ((Activity) v.getContext()).startActivityForResult(addItemIntent, 222);
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent delItemIntent = new Intent(v.getContext(), AgreementActivity.class);
                delItemIntent.putExtra("id", position);
                v.getContext().startActivity(delItemIntent);
                //((Activity) v.getContext()).startActivityForResult(delItemIntent, 333);
            }
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    public void CreateItem(String name, String description) {
        Data.add(new Product(name, description));
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void UpdateList(int id, String name, String description) {
        Product product = Data.get(id);
        if (!(name.equals(""))) {
            product.Name = name;
            Data.set(id, product);
        }
        if (!(description.equals(""))) {
            product.Description = description;
            Data.set(id, product);
        }
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void DeleteItem(int id) {
        Data.remove(id);
        notifyDataSetChanged();
    }
}
