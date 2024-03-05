package com.example.mathproject_avraham_m;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
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
    private Button bRate;

    private ActivityResultLauncher<Intent>activityResultLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            int rate =result.getData().getIntExtra("rate", -1);
        }});

    Intent intent;

    MainViewModel viewModelMain;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent =new Intent(this, RateActivity.class);

        initViews();

        String username = intent.getStringExtra("userkey");
        Toast.makeText(MainActivity.this,"hello " + username, Toast.LENGTH_LONG).show();
        viewModelMain =new ViewModelProvider(this).get(MainViewModel.class);
        viewModelMain.vnum2.observe(this, new Observer<Integer>() {

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
        viewModelMain.vUpdate(username);
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
        bRate = findViewById(R.id.bRate);


        bRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
activityResultLauncher.launch(intent);
            }
        });
bChallange.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        viewModelMain.bChallange();
    }
});
bMulti.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        viewModelMain.bMulti();
    }
});
bUntilTwenty.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        viewModelMain.UntilTwenty();
    }
});

        bIsTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean b=viewModelMain.check(tAnsower.getText().toString());
                if (b == true) {
                    Toast.makeText(MainActivity.this, "succesful", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, viewModelMain.num1()*viewModelMain.num2() + "", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }



}