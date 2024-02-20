package com.example.mathproject_avraham_m;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText etname;
    private Button bSubmit;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        startActivity(intent);
        initview();
    }

    protected void initview(){
        etname=findViewById(R.id.etname);
        bSubmit=findViewById(R.id.bSubmit);
        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                intent.putExtra("Userkey",etname.getText().toString());
            }
        });
    }
}