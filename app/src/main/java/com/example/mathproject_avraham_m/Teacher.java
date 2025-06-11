package com.example.mathproject_avraham_m;

import java.util.ArrayList;

public class Teacher {
    private String name;

    private ArrayList<Student>students;
    public Teacher(String name ){

        this.name=name;
        this.students=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }


}
