package com.example.android_laba2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {
    static class Item {
        String Name;
        String Description;
        Item() {
            Name = "";
            Description = "";
        }
        Item(String name, String description) {
            Name = name;
            Description = description;
        }
    }
    ArrayList<Item> shoppingList = new ArrayList<>();
    ImageButton addItem;
    TextView emptyList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.main);
        if (shoppingList.isEmpty()) {
            emptyList = (TextView) findViewById(R.id.emptyList);
            emptyList.setText(R.string.empty_list);
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter(shoppingList));

        addItem = (ImageButton) findViewById(R.id.button);
        addItem.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent addItemIntent = new Intent(this, AddItemActivity.class);
        startActivity(addItemIntent);
    }

    public void CreateItem(String name, String description) {
        shoppingList.add(new Item(name, description));
    }

    public void UpdateList(int id, String name, String description) {
        Item element = shoppingList.get(id);
        if (!(name.equals(""))) {
            element.Name = name;
            shoppingList.set(id, element);
        }
        if (!(description.equals(""))) {
            element.Description = description;
            shoppingList.set(id, element);
        }
    }
}
