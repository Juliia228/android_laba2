package com.example.android_laba2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateListActivity extends Activity implements View.OnClickListener {
    Button addItem;
    EditText etName, etDescription;
    TextView act;
    int id = -1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.add_item);

        addItem = (Button) findViewById(R.id.btnAdd);
        Intent intent = getIntent();
        if (intent.getBooleanExtra("is_update", false)) {
            act = (TextView) findViewById(R.id.fillInfo);
            act.setText(R.string.update_info);
            addItem.setText(R.string.btn_edit);
            id = intent.getIntExtra("id", -1);
        }

        etName = (EditText) findViewById(R.id.enterName);
        etDescription = (EditText) findViewById(R.id.enterDescription);
        addItem.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (etName.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Fill in the name", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent();
            if (id != -1) {
                intent.putExtra("id", id);
            }
            intent.putExtra("name", etName.getText().toString());
            intent.putExtra("description", etDescription.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
