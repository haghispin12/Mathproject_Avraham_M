package com.example.mathproject_avraham_m.mathprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mathproject_avraham_m.R;

public class LoginActivity extends AppCompatActivity {

    private EditText etname;
    private Button bSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initview();
    }

    protected void initview(){
        etname=findViewById(R.id.etname);
        bSubmit=findViewById(R.id.bSubmit);
        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( LoginActivity.this, MainActivity.class);
intent.putExtra("userkey", etname.getText().toString());
startActivity(intent);

            }
        });
    }
}