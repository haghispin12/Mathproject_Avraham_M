package com.example.mathproject_avraham_m;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    MutableLiveData<Integer> vnum1;
    MutableLiveData<Integer> vnum2;
    Exercise e1;

    public MainViewModel(){
         vnum1= new MutableLiveData<>();
      vnum2= new MutableLiveData<>();
        e1=new Exercise();
    }
public void bChallange(){
e1.generateChallange();
vnum1.setValue(e1.getNum3());
// update vnum1,vnum2

}

}
