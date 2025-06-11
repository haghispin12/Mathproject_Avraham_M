package com.example.mathproject_avraham_m;

import java.util.ArrayList;

public class Guide {
    private String name;
    private boolean isFinish;

    private ArrayList<Student> students;

    public Guide(String name ,  boolean isFinish,  ArrayList<Student>students ){

        this.name=name;
        this.isFinish=isFinish;
        this.students=students;

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


}
