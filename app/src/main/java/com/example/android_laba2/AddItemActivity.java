package com.example.android_laba2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AddItemActivity extends Activity implements View.OnClickListener {
    Button addItem;
    EditText etName, etDescription;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.add_item);

        etName = (EditText) findViewById(R.id.enterName);
        etDescription = (EditText) findViewById(R.id.enterDescription);
        addItem = (Button) findViewById(R.id.btnAdd);
        addItem.setOnClickListener(this);
    }

    public void onClick(View v) {
//        MainActivity.CreateItem();
    }
}
