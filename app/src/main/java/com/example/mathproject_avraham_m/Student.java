package com.example.mathproject_avraham_m;

public class Student {
    private String name;
    private boolean isPresent;
    private boolean isPhone;
    private boolean isLate;

    private Long home;

    private boolean viewType;
    private String id;
    private Long count;
    public Student(String name , String id, boolean isLate , boolean isPresent , boolean isPhone , Long home ,boolean viewType , Long count){

        this.name=name;
        this.id=id;
        this.isLate=isLate;
        this.isPresent=isPresent;
        this.isPhone=isPhone;
        this.home=home;
        this.viewType=viewType;
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

    public Long gethome() {
        return home;
    }

    public void sethome(Long home) {
        this.home = home;
    }

    public boolean getViewType() {
        return viewType;
    }

    public void setViewType(boolean teacher) {
        viewType = teacher;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
    public void incNum(){
        count++;

    }


}
