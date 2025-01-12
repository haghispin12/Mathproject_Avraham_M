package com.example.mathproject_avraham_m;


import android.net.Uri;

public class User {
    private String username;
    private int score;
    private int rate;
    private Uri uri;
    long id;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public void setScore(int score) {
        this.score = score;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
 public int getscore(){
     return score;
 }
 public void setId(long id){
        this.id=id;
 }

    public Uri getUri() {
        return uri;
    }
}
