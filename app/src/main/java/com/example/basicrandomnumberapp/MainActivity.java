package com.example.basicrandomnumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button toRandBtn;
    Button toCalcBtn;
    Button toStatsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toRandBtn = findViewById(R.id.toRandBtn);
        toRandBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRandActivity();
            }
        });

        toCalcBtn = findViewById(R.id.toCalcBtn);
        toCalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalcActivity();
            }
        });

        toStatsBtn = findViewById(R.id.toStatsBtn);
        toStatsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStatsActivity();
            }
        });

    }

    /// code from https://www.youtube.com/watch?v=bgIUdb-7Rqo
    public void openRandActivity() {
        Intent intent = new Intent(this, randNumGen.class);
        startActivity(intent);
    }

    public void openCalcActivity() {
        Intent intent = new Intent(this, Calculator.class);
        startActivity(intent);
    }

    public void openStatsActivity() {
        Intent intent = new Intent(this, StatsActivity.class);
        startActivity(intent);
    }
}
