package com.example.mathproject_avraham_m;

import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class Guide {
    private String name;
    private boolean isFinish;

    private ArrayList<Student> students;

    public Guide(String name ,  boolean isFinish ){

        this.name=name;
        this.isFinish=isFinish;
        this.students=new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public boolean isFinish() {
        return isFinish;
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

public void updateTheFirestore(){
        StudentsAdapter studentsAdapter = new StudentsAdapter(this.students, new StudentsAdapter.OnItemClickListener1() {
            @Override
            public void OnItemClick(Student student, int n, Long count) {
                if(n==1) {
                    FirebaseFirestore.getInstance().collection("students").document(student.getId()).update("isPresent", student.isPresent()).addOnSuccessListener(aVoid -> {
                        Toast.makeText()
                    }).addOnFailureListener(e -> {
                        Toast.makeText(GuideActivity.this, "Failed to update: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    });
                }
            }
        });
}
}
