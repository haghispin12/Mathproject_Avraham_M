package com.example.mathproject_avraham_m;

public class Student {
    private String name;
    private boolean isPresent;
    private boolean isPhone;
    private boolean isLate;
    public Student(String name, boolean isLate , boolean isPresent , boolean isPhone){
        this.name=name;
        this.isLate=isLate;
        this.isPresent=isPresent;
        this.isPhone=isPhone;
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

    public void setPhone(boolean phone) {
        isPhone = phone;
    }
}
