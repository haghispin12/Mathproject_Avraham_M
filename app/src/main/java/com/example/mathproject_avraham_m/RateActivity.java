package com.example.mathproject_avraham_m;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class RateActivity extends AppCompatActivity {
private SeekBar sbSave;
private Button bSave2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        initView();
    }
    public void initView(){
        sbSave =findViewById(R.id.sbSave);
        bSave2 =findViewById(R.id.bSave2);
        bSave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inn =new Intent();
                inn.putExtra("rate", sbSave.getProgress());
                setResult(RESULT_OK, inn);
                finish();
            }
        });

    }
}