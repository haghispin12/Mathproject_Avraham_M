package com.example.mathproject_avraham_m;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
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
    private Button bRate;
    private Button bback;
    private String who;
    private ActivityResultLauncher<Intent>activityResultLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            int rate =result.getData().getIntExtra("rate", -1);
            viewModelMain.vUpdaterate(rate);

            Toast.makeText(MainActivity.this, "rate - " + rate, Toast.LENGTH_LONG).show();
        }});


    Uri uri;
    MainViewModel viewModelMain;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();
Intent intent =getIntent();
        String username = intent.getStringExtra("userkey");
        Toast.makeText(MainActivity.this,"hello " + username , Toast.LENGTH_LONG).show();
        viewModelMain =new ViewModelProvider(this).get(MainViewModel.class);
        viewModelMain.vUpdateusername(username);
        viewModelMain.vnum2.observe(this, new Observer<Integer>()
        {

            @Override

    public void onChanged(Integer num2) {
        tSecondNum.setText(num2+"");
    }
});
        viewModelMain.vnum1.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer num1) {
tFirstNum.setText(num1+"");
            }
        });

    }



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
        bback=findViewById(R.id.bback);
        bRate = findViewById(R.id.bRate);


        bRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(MainActivity.this, RateActivity.class);
                activityResultLauncher.launch(intent);
            }
        });




        bShowUsers.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                FragmentTransaction trans = getSupportFragmentManager().beginTransaction();

                trans.add(R.id.frameLayout, new ShowAllUsers1());
//
                trans.commit();
                //Intent intent = new Intent(MainActivity.this , ShowfruitsActivity1.class);
                //startActivity(intent);
            }
        });

bChallange.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        viewModelMain.bChallange();
        who = "challange";
    }
});

bMulti.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        viewModelMain.bMulti();
        who = "multi";
    }
});
bUntilTwenty.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        viewModelMain.bUntilTwenty();
        who = "untiltwenty";
    }
});

        bIsTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score;
                boolean b=viewModelMain.check(tAnsower.getText().toString());

                if (b == true) {


                    Toast.makeText(MainActivity.this, "succesful", Toast.LENGTH_LONG).show();
                    if (who.equals("multi")) {
                         score = viewModelMain.getuser().getscore() + 10;
                    }else if(who.equals("untiltwenty")) {
                         score = viewModelMain.getuser().getscore() + 15;
                    }else{
                               score = viewModelMain.getuser().getscore() + 20;


                    }
                    viewModelMain.getuser().setScore(score);
                }else Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();

            }
        });


    }



}