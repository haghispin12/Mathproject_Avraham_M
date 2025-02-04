package com.example.mathproject_avraham_m;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
private EditText etname;
private EditText etpassword;
private Button bRegistration;
private Button bsubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login2);
       initView();
    }
    protected void initView(){
        bsubmit = findViewById(R.id.bSubmit);
        bRegistration = findViewById(R.id.bRegistration);
        etname = findViewById(R.id.etname);
        etpassword = findViewById(R.id.etpassword);
        bsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i=10;
            }
        });
        bRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i=10;
            }
        });
    }
}