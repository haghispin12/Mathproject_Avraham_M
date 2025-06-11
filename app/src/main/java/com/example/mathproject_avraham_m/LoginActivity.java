package com.example.mathproject_avraham_m;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mathproject_avraham_m.mathprog.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
private EditText etname;
private EditText etpassword;

private Button bRegistration;
private Button bsubmit;
private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login2);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
//        push();
       initView();
    }


    protected void initView(){

        bsubmit = findViewById(R.id.bSubmit);
        bRegistration = findViewById(R.id.bRegistration);
        etname = findViewById(R.id.etname);
        etpassword = findViewById(R.id.etpassword);

        bRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = auth.getCurrentUser().getEmail();

                //auth.createUserWithEmailAndPassword("","").addOnCompleteListener()
                //הרשמה
                registration();
            }
        });
        bsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               sign();
            }
        });
    }

    /**
     * registration user
     */
    private void registration() {
        auth.createUserWithEmailAndPassword( etname.getText().toString() , etpassword.getText().toString()).addOnCompleteListener
                (LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "registered Successfully", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "Error Registration", Toast.LENGTH_LONG).show();

                        }

                    }

                });
    }
    /**
     * sign in user
     */
    private void sign(){
        auth.signInWithEmailAndPassword(etname.getText().toString() , etpassword.getText().toString()).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent intent = new Intent(LoginActivity.this , GuideActivity.class);
                    intent.putExtra("userkey" , etname.getText().toString());
                    startActivity(intent);

//                            Toast.makeText(LoginActivity.this, "Authentication success", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
//public static void push(){
//    ArrayList<Student>students =new ArrayList<>();
//    FirebaseFirestore.getInstance().collection("studentes").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//        @Override
//        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//for (DocumentSnapshot documentSnapshot: queryDocumentSnapshots){
//    if (documentSnapshot.exists()){
//        String name = documentSnapshot.getString("name");
//        String id = documentSnapshot.getId();
//        boolean isPhone = documentSnapshot.getBoolean("isPhone");
//boolean isLeft = documentSnapshot.getBoolean("isLate");
//   Long isInHome = documentSnapshot.getLong("isInHome");
//   boolean isPresent = documentSnapshot.getBoolean("isPresent");
//        boolean viewType = documentSnapshot.getBoolean("isTeacherView");
//        Long count =documentSnapshot.getLong("count");
//        Student st1 = new Student(name, id , isLeft, isPresent , isPhone , isInHome , viewType , count );
//        students.add(st1);
//
//
//
//    }
//}
//        }
//    });
}
//public static void add(){
//    Student student = new Student("shlomo" , true, true);
//    FirebaseFirestore.getInstance().collection("students").document().set(student).addOnSuccessListener(new OnSuccessListener<Void>() {
//        @Override
//        public void onSuccess(Void unused) {
//            Toast.makeText(this , "add student has been success", Toast.LENGTH_SHORT).show();
//
//        }
//    }).addOnFailureListener(new OnFailureListener() {
//        @Override
//        public void onFailure(@NonNull Exception e) {
//            Toast.makeText(LoginActivity.this, "", Toast.LENGTH_SHORT).show();
//        }
//    });
//}
//

