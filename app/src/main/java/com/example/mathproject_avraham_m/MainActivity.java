package com.example.mathproject_avraham_m;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Provider;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button bChallange;
    private Button bUntilTwenty;
    private Button bMulti;
    private TextView tFirstNum;
    private TextView tKaful;
    private TextView tSecondNum;
    private TextView tAnsower;
    private Button bIsTrue;
    private Button bSave;
    private Button bShowUsers;
    Intent intent;
    MainViewModel viewModelMain;
//private int num1;
    //private int num2;
    //private int num6;
private Exercise e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=new Exercise();
        initViews();
        Intent intent = getIntent();
        String userName=intent.getStringExtra("UserKey");
        viewModelMain =new ViewModelProvider(this).get(MainViewModel.class);
        viewModelMain.vnum1.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {

            }
        });
    }
MainViewModel mvc =new MainViewModel();
    protected void initViews() {
        bChallange = findViewById(R.id.bChallange);
        bUntilTwenty = findViewById(R.id.bUntilTwenty);
        bMulti = findViewById(R.id.bMulti);
        tFirstNum = findViewById(R.id.tFirstNum);
        tKaful = findViewById(R.id.tKaful);
        tSecondNum = findViewById(R.id.tSecondNum);
        tAnsower = findViewById(R.id.tAnsower);
        bIsTrue = findViewById(R.id.bIsTrue);
        bSave = findViewById(R.id.bSave);
        bShowUsers = findViewById(R.id.bShowUsers);

        bChallange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 //
//                e1.generateChallange();
//                uptadeView();
            }
        });
        bUntilTwenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                e1.generateUntilTwenty();
                uptadeView();

            }
        });
        bMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                e1.generateMulti();
                uptadeView();

            }
        });
        bIsTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check() == true) {
                    Toast.makeText(MainActivity.this, "succesful", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, e1.getNum4()*e1.getNum3() + "", Toast.LENGTH_SHORT).show();
                }

            }
        });
        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        bShowUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    /**
     * until twenty
     */

    public void uptadeView(){
        tFirstNum.setText(e1.getNum3() +"");
        tSecondNum.setText(e1.getNum4() +"");
    }
    public boolean check(){
        int  num6 = e1.getNum3()*e1.getNum4() ;
        String res =num6+"";
        if(res.equals(tAnsower.getText().toString()))
            return true;
        else
            return false;
    }
}