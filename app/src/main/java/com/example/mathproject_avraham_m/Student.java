package com.example.mathproject_avraham_m;

public class Student {
    private String name;
    private boolean isPresent;
    private boolean isPhone;
    private boolean isLate;
    private Long isInHome;

    private boolean isTeacherView;
    private String id;
    private Long count;
    public Student(String name , String id, boolean isLate , boolean isPresent , boolean isPhone, Long isInHome ,boolean isTeacherView , Long count){

        this.name=name;
        this.id=id;
        this.isLate=isLate;
        this.isPresent=isPresent;
        this.isPhone=isPhone;
        this.isInHome= isInHome;
        this.isTeacherView=isTeacherView();
        this.count=count;
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

    public boolean isTeacherView() {
        return isTeacherView;
    }

    public void setTeacherView(boolean teacher) {
        isTeacherView = teacher;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
    public Long addCount(Long num){
        num= num +1;
        return num;
    }
}
