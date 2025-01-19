package com.example.mathproject_avraham_m;


import android.graphics.Bitmap;
import android.net.Uri;

public class User {
    private String username;
    private int score;
    private int rate;
    private Bitmap bitmap;
    private Uri uri;
    long id;
public User(long id , String username , int score , int rate , Bitmap bitmap){
    this.id=id;
    this.rate=rate;
    this.score=score;
    this.username = username;
    this.bitmap=bitmap;
}
public User(){

}
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

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setId(long id){
        this.id=id;
 }

    public Uri getUri() {
        return uri;
    }
    public void setUri(Uri uri){
        this.uri=uri;
    }
}
