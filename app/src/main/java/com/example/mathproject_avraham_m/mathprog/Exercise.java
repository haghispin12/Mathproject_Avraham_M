package com.example.mathproject_avraham_m.mathprog;

import android.widget.TextView;

import java.util.Random;

public class Exercise {
    private int num1;
    private int num2;

    public void generateUntilTwenty() {
        Random r = new Random();
        num1 = r.nextInt(10);
      num2 = r.nextInt(10) + 10;

    }
    public void generateMulti() {
        Random r = new Random();
        num1 = r.nextInt(10);
        num2= r.nextInt(10);
    }
    public void generateChallange() {
        Random r = new Random();
        num1 = r.nextInt(10);
        num2 = r.nextInt(90) + 10;
    }
    public boolean check(String answer){
        int  result = num1*num2 ;
        String res =result+"";
        if(res.equals(answer))
            return true;
        else
            return false;

    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum3(int num3) {
        this.num1 = num3;
    }

    public void setNum4(int num4) {
        this.num2 = num4;
    }

}
