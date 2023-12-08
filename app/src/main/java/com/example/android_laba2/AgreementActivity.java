package com.example.android_laba2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AgreementActivity extends Activity implements View.OnClickListener {
    private Adapter adapter;
    Button yes, no;
    int id = -1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.agreement);
        yes = (Button) findViewById(R.id.yes_del);
        yes.setOnClickListener(this);
        no = (Button) findViewById(R.id.no_del);
        no.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.yes_del:
                Intent intent = getIntent();
                id = intent.getIntExtra("id", -1);
                if (id != -1) {
                    adapter.DeleteItem(id);
                } else {
                    Toast.makeText(getApplicationContext(), "The item cannot be deleted", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.no_del:
                finish();
        }
    }
}
