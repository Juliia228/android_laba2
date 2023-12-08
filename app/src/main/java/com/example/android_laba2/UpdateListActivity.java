package com.example.android_laba2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateListActivity extends Activity implements View.OnClickListener {
    Button addItem;
    EditText etName, etDescription;
    TextView act;
    int id = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.add_item);
        Log.d("mymy", "add OR update activity (updateActivity)");
        //Toast.makeText(getApplicationContext(), "created addORupdate_activity", Toast.LENGTH_LONG).show();

        addItem = (Button) findViewById(R.id.btnAdd);
        Intent intent = getIntent();
        if (intent.getBooleanExtra("is_update", false)) {
            //Toast.makeText(getApplicationContext(), "created update_activity", Toast.LENGTH_LONG).show();
            Log.d("mymy", "update activity (updateActivity)");
            act = (TextView) findViewById(R.id.fillInfo);
            act.setText(R.string.update_info);
            addItem.setText(R.string.btn_edit);
            id = intent.getIntExtra("id", 0);
        }

        etName = (EditText) findViewById(R.id.enterName);
        etDescription = (EditText) findViewById(R.id.enterDescription);
        addItem.setOnClickListener(this);
    }

    public void onClick(View v) {
        Log.d("mymy", "send ready intent to adapter");
        Intent intent = new Intent();
        if (id != 0) { intent.putExtra("id", id); }
        intent.putExtra("name", etName.getText().toString());
        intent.putExtra("description", etDescription.getText().toString());
        setResult(RESULT_OK, intent);
        //Toast.makeText(getApplicationContext(), "Send intent", Toast.LENGTH_LONG).show();
        finish();
    }
}
