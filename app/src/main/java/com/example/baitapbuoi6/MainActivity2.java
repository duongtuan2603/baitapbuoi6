package com.example.baitapbuoi6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText edtfoldername;
    EditText edtfolderdescription;
    Button btnconfirmedit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edtfoldername = findViewById(R.id.edtfoldername);
        edtfolderdescription = findViewById(R.id.edtfolderdescription);
        btnconfirmedit = findViewById(R.id.btnconfirmedit);
        edtfoldername.setText(getIntent().getExtras().getString("folder name"));
        edtfolderdescription.setText(getIntent().getExtras().getString("folder description"));
        btnconfirmedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultintent = new Intent();
                Bundle bundleresult = new Bundle();
                bundleresult.putString("Edited Folder Name",edtfoldername.getText().toString());
                bundleresult.putString("Edited Folder Description",edtfolderdescription.getText().toString());
                resultintent.putExtras(bundleresult);
                setResult(RESULT_OK,resultintent);
                finish();
            }
        });

    }
}