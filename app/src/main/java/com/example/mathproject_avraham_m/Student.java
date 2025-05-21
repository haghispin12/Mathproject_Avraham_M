package com.example.mathproject_avraham_m;

public class Student {
    private String name;
    private boolean isPresent;
    private boolean isPhone;
    private boolean isLate;
    private boolean isHome;
    private boolean isTeacher;
    private String id;
    public Student(String name , String id, boolean isLate , boolean isPresent , boolean isPhone, boolean isHome ,boolean isTeacher){

        this.name=name;
        this.id=id;
        this.isLate=isLate;
        this.isPresent=isPresent;
        this.isPhone=isPhone;
        this.isHome= isHome;
        this.isTeacher=isTeacher;
    }

    public boolean isLate() {
        return isLate;
    }

    public void setLate(boolean late) {
        isLate = late;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    public boolean isPhone() {
        return isPhone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPhone(boolean phone) {
        isPhone = phone;
    }

    public boolean isHome() {
        return isHome;
    }

    public void setHome(boolean home) {
        isHome = home;
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }
}
