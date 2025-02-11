package com.example.mathproject_avraham_m;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.FirebaseAuthCredentialsProvider;

public class LoginActivity extends AppCompatActivity {
private EditText etname;
private EditText etpassword;
private Button bRegistration;
private Button bsubmit;
private FirebaseAuth auth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login2);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
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

                //auth.createUserWithEmailAndPassword("","").addOnCompleteListener()

auth.createUserWithEmailAndPassword( etname.getText().toString() , etpassword.getText().toString()).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()) {
            Toast.makeText(LoginActivity.this, "Authentication success", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(LoginActivity.this, "Authentication failed", Toast.LENGTH_LONG).show();

        }

    }
});
            }
        });
    }

}