package com.example.mathproject_avraham_m;

import android.widget.TextView;

import java.util.Random;

public class Exercise {
    private int num4;
    private int num3;

    public void generateUntilTwenty() {
        Random r = new Random();
        num3 = r.nextInt(10);
      num4 = r.nextInt(10) + 10;

    }
    public void generateMulti() {
        Random r = new Random();
        num3 = r.nextInt(10);
        num4= r.nextInt(10);
    }
    public void generateChallange() {
        Random r = new Random();
        num3 = r.nextInt(10);
        num4 = r.nextInt(90) + 10;
    }
    public boolean check(String answer){
        int  num5 = num3*num4 ;
        String res =num5+"";
        if(res.equals(answer))
            return true;
        else
            return false;

    }

    public int getNum3() {
        return num3;
    }

    public int getNum4() {
        return num4;
    }

    public void setNum3(int num3) {
        this.num3 = num3;
    }

    public void setNum4(int num4) {
        this.num4 = num4;
    }
}
