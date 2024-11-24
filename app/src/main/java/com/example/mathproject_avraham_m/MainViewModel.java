package com.example.mathproject_avraham_m;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    MutableLiveData<Integer> vnum1;
    MutableLiveData<Integer> vnum2;
    Exercise e1;
    User user;

    public MainViewModel() {
        vnum1 = new MutableLiveData<>();
        vnum2 = new MutableLiveData<>();
        e1 = new Exercise();

    }

    public void bChallange() {
        e1.generateChallange();
        vnum1.setValue(e1.getNum1());
        vnum2.setValue(e1.getNum2());

// update vnum1,vnum2

    }

    public boolean check(String answer) {
        boolean b1 = e1.check(answer);
        return b1;

    }

    public int getnum1() {
        return e1.getNum1();
    }

    public int getnum2() {
        return e1.getNum2();
    }
public User getuser(){
        return user ;
}

    public void bUntilTwenty() {
        e1.generateUntilTwenty();
        vnum1.setValue(e1.getNum1());
        vnum2.setValue(e1.getNum2());
    }

    public void bMulti() {
        e1.generateMulti();
        vnum1.setValue(e1.getNum1());
        vnum2.setValue(e1.getNum2());

    }

    public void vUpdateusername(String username) {

        user.setUsername(username);
    }

    public int getrate() {
        return user.getRate();
    }

    public String getUser() {
        return user.getUsername();
    }

    public int getscore() {
        return user.getscore();
    }

    public void vUpdatescore(int score) {
        user.setScore(score);

    }

    public void vUpdaterate(int rate) {

        user.setRate(rate);
    }
}
