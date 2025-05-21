package com.example.mathproject_avraham_m;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathproject_avraham_m.R;
import com.example.mathproject_avraham_m.mathprog.MainActivity;
import com.example.mathproject_avraham_m.mathprog.RateActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

public class GuideActivity extends AppCompatActivity{
    private RecyclerView rcShowStudents;
    private String id;

    private ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.guide_activity);
        initViews();
start1();


        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
        //  Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        //v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        //return insets;
        // });
    }
protected void initViews(){
    rcShowStudents = findViewById(R.id.rcShowStudents);

    }

public void start1(){
    CollectionReference reference = FirebaseFirestore.getInstance().collection("students");
    reference.addSnapshotListener(new EventListener<QuerySnapshot>() {
        @Override
        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
            ArrayList<Student>students1 = new ArrayList<>();
            for (DocumentSnapshot documentSnapshot : value){
                if (documentSnapshot.exists()){
                    String id = documentSnapshot.getId();
                    String name = documentSnapshot.getString("name");
                    boolean isPhone = documentSnapshot.getBoolean("isPhone");
                    boolean isLeft = documentSnapshot.getBoolean("isLate");
                   boolean isHome = documentSnapshot.getBoolean("isHome");
                   boolean isPresent = documentSnapshot.getBoolean("isPresent");
                    boolean isTeacher = documentSnapshot.getBoolean("isTeacher");
                    Student st1 = new Student(name, id, isLeft, isPresent, isPhone, isHome , isTeacher);
                    students1.add(st1);
                }
            }
            createList(students1);
        }
    });
}



public void start( ) {
    FirebaseFirestore.getInstance().collection("students").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {



        @Override
        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
            ArrayList<Student> students = new ArrayList<>();
            for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                if (documentSnapshot.exists()) {
                    String id = documentSnapshot.getId();
                    String name = documentSnapshot.getString("name");
                    boolean isPhone = documentSnapshot.getBoolean("isPhone");
                    boolean isLeft = documentSnapshot.getBoolean("isLate");
                   boolean isHome = documentSnapshot.getBoolean("isHome");
                    boolean isPresent = documentSnapshot.getBoolean("isPresent");
                    boolean isTeacher = documentSnapshot.getBoolean("isTeacher");
                    Student st1 = new Student(name, id, isLeft, isPresent, isPhone, isHome , isTeacher);
                    students.add(st1);
//createList(students);

                }
            }
            createList(students);
        }

    }).addOnFailureListener(new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception e) {
            int n=0;
        }
    });

}


     public void createList(ArrayList<Student>students){
         StudentsAdapter studentsAdapter = new StudentsAdapter(students, new StudentsAdapter.OnItemClickListener1() {
             @Override
             public void OnItemClick(Student student, int n) {
                 if(n==1) {
                     FirebaseFirestore.getInstance().collection("students").document(student.getId()).update("isPresent", student.isPresent()).addOnSuccessListener(aVoid -> {
                         Toast.makeText(GuideActivity.this, student.getName() + " marked Present", Toast.LENGTH_SHORT).show();
                     }).addOnFailureListener(e -> {
                         Toast.makeText(GuideActivity.this, "Failed to update: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                     });
                 }
                 else if (n==2){
                     FirebaseFirestore.getInstance().collection("students").document(student.getId()).update("isLate", student.isLate()).addOnSuccessListener(aVoid -> {
                         Toast.makeText(GuideActivity.this, student.getName() + " marked Late", Toast.LENGTH_SHORT).show();
                     }).addOnFailureListener(e -> {
                         Toast.makeText(GuideActivity.this, "Failed to update: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                     });
                 }
                 else if(n==3){
                     FirebaseFirestore.getInstance().collection("students").document(student.getId()).update("isPhone", student.isPhone()).addOnSuccessListener(aVoid -> {
                         Toast.makeText(GuideActivity.this, student.getName() + " marked Phone", Toast.LENGTH_SHORT).show();
                     }).addOnFailureListener(e -> {
                         Toast.makeText(GuideActivity.this, "Failed to update: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                     });
                 }
                 else if(n==4){
                     FirebaseFirestore.getInstance().collection("students").document(student.getId()).update("isHome", student.isHome()).addOnSuccessListener(aVoid -> {
                         Toast.makeText(GuideActivity.this, student.getName() + " marked Home", Toast.LENGTH_SHORT).show();
                     }).addOnFailureListener(e -> {
                         Toast.makeText(GuideActivity.this, "Failed to update: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                     });
                 }
//            Toast.makeText(GuideActivity.this, student.getName() , Toast.LENGTH_LONG).show();

             }
         });
    rcShowStudents.setLayoutManager(new LinearLayoutManager(this));
    rcShowStudents.setAdapter(studentsAdapter);
    rcShowStudents.setHasFixedSize(true);
}


    }

