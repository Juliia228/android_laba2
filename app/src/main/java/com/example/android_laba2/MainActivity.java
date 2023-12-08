package com.example.android_laba2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {
    private Adapter adapter;
    ImageButton addItem;
    TextView emptyList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.main);
        adapter = new Adapter(new ArrayList<>());
        if (adapter.getItemCount() == 0) {
            emptyList = (TextView) findViewById(R.id.emptyList);
            emptyList.setText(R.string.empty_list);
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        addItem = (ImageButton) findViewById(R.id.button);
        addItem.setOnClickListener(this);
    }

    public void onResume() {
        super .onResume();
        emptyList = (TextView) findViewById(R.id.emptyList);
        if (adapter.getItemCount() == 0) {
            emptyList.setText(R.string.empty_list);
        } else {
            emptyList.setText("");
        }
    }

    public void onClick(View v) {
        Intent addItemIntent = new Intent(this, UpdateListActivity.class);
        startActivityForResult(addItemIntent, 111);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null || resultCode != -1) {
            if (resultCode != -2) {
                Toast.makeText(getApplicationContext(), "Error :(", Toast.LENGTH_LONG).show();
            }
        } else {
            String name = data.getStringExtra("name");
            String description = data.getStringExtra("description");
            switch (requestCode) {
                case 111: // add the item
                    adapter.CreateItem(name, description);
                    break;
                case 222: // update the item
                    int id = data.getIntExtra("id", 0);
                    adapter.UpdateList(id, name, description);
                    break;
            }
        }
    }
}
