package com.example.android_laba2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Objects;

public class UpdateListActivity extends Activity implements View.OnClickListener {
    Button addItem;
    EditText etName, etDescription;
    TextView act;
    ImageView back;
    int id = -1;

    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.add_item);

        act = (TextView) findViewById(R.id.fillInfo);
        addItem = (Button) findViewById(R.id.btnAdd);
        etName = (EditText) findViewById(R.id.enterName);
        etDescription = (EditText) findViewById(R.id.enterDescription);
        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(this);
        Intent intent = getIntent();
        switch (Objects.requireNonNull(intent.getStringExtra("act"))) {
            case "update":
                act.setText(R.string.update_info);
                addItem.setText(R.string.btn_edit);
                id = intent.getIntExtra("id", -1);
                break;
            case "create":
                break;
            default:
                break;
        }
        addItem.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdd:
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
                break;
            case R.id.back:
                setResult(-2);
                finish();
                break;
        }
    }
}
