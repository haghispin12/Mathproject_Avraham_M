package com.example.mathproject_avraham_m;

public class Student {
    private String name;
    private boolean isPresent;
    private boolean isPhone;
    private boolean isLate;
    private Long isInHome;
    private boolean isTeacher;
    private String id;
    public Student(String name , String id, boolean isLate , boolean isPresent , boolean isPhone, Long isInHome ,boolean isTeacher){

        this.name=name;
        this.id=id;
        this.isLate=isLate;
        this.isPresent=isPresent;
        this.isPhone=isPhone;
        this.isInHome= isInHome;
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

    public Long isHome() {
        return isInHome;
    }

    public void setIsInHome(Long isInHome) {
        this.isInHome = isInHome;
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }
}
