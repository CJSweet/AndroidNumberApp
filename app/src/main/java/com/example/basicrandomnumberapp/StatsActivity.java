package com.example.basicrandomnumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.VibrationEffect;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class StatsActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Button> arrayBtn = new ArrayList<Button>();

    ImageButton enterBtn;
    ImageButton backBtn;

    TextView statsScreen;

    StatsBackend backend = new StatsBackend();

    TextView dataSet, meanNum, medNum, modNum, rangNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        /// initialize button arrayList
        arrayBtn.add((Button) findViewById(R.id.zerStatBtn));
        arrayBtn.add((Button) findViewById(R.id.oneStatBtn));
        arrayBtn.add((Button) findViewById(R.id.twoStatBtn));
        arrayBtn.add((Button) findViewById(R.id.thrStatBtn));
        arrayBtn.add((Button) findViewById(R.id.fourStatBtn));
        arrayBtn.add((Button) findViewById(R.id.fivStatBtn));
        arrayBtn.add((Button) findViewById(R.id.sixStatBtn));
        arrayBtn.add((Button) findViewById(R.id.sevStatBtn));
        arrayBtn.add((Button) findViewById(R.id.eiStatBtn));
        arrayBtn.add((Button) findViewById(R.id.ninStatBtn));
        arrayBtn.add((Button) findViewById(R.id.decStatBtn));
        arrayBtn.add((Button) findViewById(R.id.submitBtn));

        //ImageButton is not child of Button, must initialize separately
        enterBtn = findViewById(R.id.enterBtn);
        backBtn = findViewById(R.id.backBtn);

        // set all buttons to onClickListener
        arrayBtn.get(0).setOnClickListener(this);
        arrayBtn.get(1).setOnClickListener(this);
        arrayBtn.get(2).setOnClickListener(this);
        arrayBtn.get(3).setOnClickListener(this);
        arrayBtn.get(4).setOnClickListener(this);
        arrayBtn.get(5).setOnClickListener(this);
        arrayBtn.get(6).setOnClickListener(this);
        arrayBtn.get(7).setOnClickListener(this);
        arrayBtn.get(8).setOnClickListener(this);
        arrayBtn.get(9).setOnClickListener(this);
        arrayBtn.get(10).setOnClickListener(this);
        arrayBtn.get(11).setOnClickListener(this);

        enterBtn.setOnClickListener(this);
        backBtn.setOnClickListener(this);

        //initialize number Screen where users see the number they type
        statsScreen = findViewById(R.id.statsScreen);

        //initialize TextViews for data set, mean, med, mod, range
        dataSet = findViewById(R.id.dataNum);
        meanNum = findViewById(R.id.meanNum);
        medNum = findViewById(R.id.medianNum);
        modNum = findViewById(R.id.modeNum);
        rangNum = findViewById(R.id.rangeNum);
    }

    @Override
    public void onClick(View v){

        switch(v.getId()) {
            case R.id.zerStatBtn:
                statsScreen.append(getResources().getString(R.string.zeroBtn));
                break;
            case R.id.oneStatBtn:
                statsScreen.append(getResources().getString(R.string.oneBtn));
                break;
            case R.id.twoStatBtn:
                statsScreen.append(getResources().getString(R.string.twoBtn));
                break;
            case R.id.thrStatBtn:
                statsScreen.append(getResources().getString(R.string.threeBtn));
                break;
            case R.id.fourStatBtn:
                statsScreen.append(getResources().getString(R.string.fourBtn));
                break;
            case R.id.fivStatBtn:
                statsScreen.append(getResources().getString(R.string.fiveBtn));
                break;
            case R.id.sixStatBtn:
                statsScreen.append(getResources().getString(R.string.sixBtn));
                break;
            case R.id.sevStatBtn:
                statsScreen.append(getResources().getString(R.string.sevBtn));
                break;
            case R.id.eiStatBtn:
                statsScreen.append(getResources().getString(R.string.eightBtn));
                break;
            case R.id.ninStatBtn:
                statsScreen.append(getResources().getString(R.string.nineBtn));
                break;
            case R.id.decStatBtn:
                if(!statsScreen.getText().toString().contains(".")){
                    statsScreen.append(getResources().getString(R.string.deciBtn));
                }
                break;
            case R.id.enterBtn:
                if(!statsScreen.getText().toString().isEmpty()) {
                    backend.addToMap(statsScreen.getText().toString());
                    statsScreen.setText("");
                }
                break;
            case R.id.submitBtn:
                // TODO: send list of numbers to be manipulated
                if(!backend.numset.isEmpty()){
                    backend.calculate();

                    dataSet.setText(backend.dataSet);
                    meanNum.setText(backend.mean);
                    medNum.setText(backend.median);
                    modNum.setText(backend.mode);
                    rangNum.setText(backend.range);

                    backend.clear();
                }
                break;
            case R.id.backBtn:
                if(!statsScreen.getText().toString().isEmpty()) {
                    String temp = statsScreen.getText().toString().substring(0, statsScreen.length() - 1);
                    statsScreen.setText(temp);
                }
                break;
        }

    }
}