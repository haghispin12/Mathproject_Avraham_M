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

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

public class GuideActivity extends AppCompatActivity{
    private RecyclerView rcShowStudents;

    private FirebaseAuth auth;
    private Teacher t1;
    private Guide g1;
    private ArrayList<Student> students;

    private Button bclear;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.guide_activity);
        initViews();
        auth = FirebaseAuth.getInstance();

        String email = auth.getCurrentUser().getEmail();
if(email.startsWith("t")){
     t1 = new Teacher(email);
}else{
     g1 = new Guide(email , false );
}

    createListOfStudents();

        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
        //  Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        //v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        //return insets;
        // });
    }

protected void initViews(){
    rcShowStudents = findViewById(R.id.rcShowStudents);
bclear = findViewById(R.id.bclear);
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
bclear.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        builder.setTitle("מחיקת נתונים").setMessage("בטוח? הנתונים לא יישמרו");
        builder.setPositiveButton("אישור", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                for (int i = 0; i < g1.getStudents().size(); i++) {
                    Student s1 = g1.getStudents().get(i);
                    clearAllTheFiles(s1);
                }
            }
        }).setNegativeButton("ביטול", null).show();
    }
                });



    }

public void createListOfStudents(){
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
int grade = documentSnapshot.getLong("grade").intValue();
boolean isHome = documentSnapshot.getBoolean("isHome");
boolean isPresent = documentSnapshot.getBoolean("isPresent");
                    boolean viewType;
if(auth.getCurrentUser().getEmail().startsWith("t")) {
    viewType = true;
}else {
    viewType = false;
}
Long count = documentSnapshot.getLong("count");
                    Student st1 = new Student(name, id, isLeft, isPresent, isPhone, isHome, grade , viewType , count);
                    students1.add(st1);
                }
            }
            updateTheFirestore(students1);
        }
    });
}

public void clearAllTheFiles(Student student){
    StudentsAdapter studentsAdapter = new StudentsAdapter(students, new StudentsAdapter.OnItemClickListener1() {
        @Override
        public void OnItemClick(Student student, int n, Long count) {

                student.setLate(false);
                student.setPhone(false);
                student.sethome(false);
                student.setPresent(false);
                FirebaseFirestore.getInstance().collection("students").document(student.getId()).update("isPresent", student.isPresent());
                FirebaseFirestore.getInstance().collection("students").document(  student.getId()).update("isLate", student.isLate());
                FirebaseFirestore.getInstance().collection("students").document ( student.getId()).update("isPhone", student.isPhone());
                FirebaseFirestore.getInstance().collection("students").document(  student.getId()).update("isHome", student.gethome());


        }
    });
    rcShowStudents.setLayoutManager(new LinearLayoutManager(this));
    rcShowStudents.setAdapter(studentsAdapter);
    rcShowStudents.setHasFixedSize(true);
}



     public void updateTheFirestore(ArrayList<Student>students){
         StudentsAdapter studentsAdapter = new StudentsAdapter(students, new StudentsAdapter.OnItemClickListener1() {
             @Override
             public void OnItemClick(Student student, int n , Long count) {
                 if(n==1) {
                     FirebaseFirestore.getInstance().collection("students").document(student.getId()).update("isPresent", student.isPresent()).addOnSuccessListener(aVoid -> {
                         Toast.makeText(GuideActivity.this, student.getName() + " marked Present", Toast.LENGTH_SHORT).show();
                     }).addOnFailureListener(e -> {
                         Toast.makeText(GuideActivity.this, "Failed to update: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                     });
                 }
                 else if (n==2) {
                     if (student.isLate() == true){
                         FirebaseFirestore.getInstance().collection("students").document(student.getId()).update("count", count);
                 }
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
                     FirebaseFirestore.getInstance().collection("students").document(student.getId()).update("isHome", student.gethome()).addOnSuccessListener(aVoid -> {
                         Toast.makeText(GuideActivity.this, student.getName() + " marked Home", Toast.LENGTH_SHORT).show();
                     }).addOnFailureListener(e -> {
                         Toast.makeText(GuideActivity.this, "Failed to update: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                     });
                 }
//            Toast.makeText(GuideActivity.this, student.getName() , Toast.LENGTH_Long).show();

             }
         });
    rcShowStudents.setLayoutManager(new LinearLayoutManager(this));
    rcShowStudents.setAdapter(studentsAdapter);
    rcShowStudents.setHasFixedSize(true);
}


    }

//public void start( ) {
//    FirebaseFirestore.getInstance().collection("students").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//
//
//
//        @Override
//        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//            ArrayList<Student> students = new ArrayList<>();
//            for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
//                if (documentSnapshot.exists()) {
//                    String id = documentSnapshot.getId();
//                    String name = documentSnapshot.getString("name");
//                    boolean isPhone = documentSnapshot.getBoolean("isPhone");
//                    boolean isLeft = documentSnapshot.getBoolean("isLate");
//                   Long isInHome = documentSnapshot.getLong("isInHome");
//                    boolean isPresent = documentSnapshot.getBoolean("isPresent");
//                    boolean viewType = documentSnapshot.getBoolean("viewType");
//                    Long count = documentSnapshot.getLong("count");
//
//                    Student st1 = new Student(name, id, isLeft, isPresent, isPhone, isInHome , viewType , count);
//                    students.add(st1);
////createList(students);
//
//                }
//            }
//            createList(students);
//        }
//
//    }).addOnFailureListener(new OnFailureListener() {
//        @Override
//        public void onFailure(@NonNull Exception e) {
//            int n=0;
//        }
//    });
//
//}

