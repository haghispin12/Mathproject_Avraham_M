package com.example.mathproject_avraham_m;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
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
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
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
start();


        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
        //  Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        //v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        //return insets;
        // });
    }
protected void initViews(){
    rcShowStudents = findViewById(R.id.rcShowStudents);

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
                    boolean isPresent = documentSnapshot.getBoolean("isPresent");
                    Student st1 = new Student(name, id, isLeft, isPresent, isPhone);
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
             public void OnItemClick(Student student) {
                 int n=0;
//            Toast.makeText(GuideActivity.this, student.getName() , Toast.LENGTH_LONG).show();

             }
         });
    rcShowStudents.setLayoutManager(new LinearLayoutManager(this));
    rcShowStudents.setAdapter(studentsAdapter);
    rcShowStudents.setHasFixedSize(true);
}


    }

