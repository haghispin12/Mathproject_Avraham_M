package com.example.mathproject_avraham_m;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    MutableLiveData<Integer> vnum1;
    MutableLiveData<Integer> vnum2;
    Exercise e1;
    User user;

    public MainViewModel(){
         vnum1= new MutableLiveData<>();
      vnum2= new MutableLiveData<>();
 e1 =new Exercise();
    }
public void bChallange(){
e1.generateChallange();
vnum1.setValue(e1.getNum1());
vnum2.setValue(e1.getNum2());
// update vnum1,vnum2

}
public boolean check(String answer){
        boolean b1= e1.check(answer);
        return b1;
}
public int num1(){
        return num1();
}
    public int num2(){
        return num2();
    }


public void UntilTwenty(){
        e1.generateUntilTwenty();
        vnum1.setValue(e1.getNum1());
        vnum2.setValue(e1.getNum2());
}
public void bMulti(){
        e1.generateMulti();
    vnum1.setValue(e1.getNum1());
    vnum2.setValue(e1.getNum2());
}
    public void vUpdate(String username){
        user =new User();
        user.setUsername(username);
    }
}
