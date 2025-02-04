package com.example.mathproject_avraham_m.mathprog;

public class Fruit {
    private String name;
    private int image;
    public Fruit(int image, String name){
        this.image= image;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
