package com.example.basicrandomnumberapp;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

///This is the front end of the calculator. Where all the views are located

public class Calculator extends AppCompatActivity implements View.OnClickListener {

    /// the screen textview
    TextView CalcScreen;

    /// the arraylist for the buttons
    ArrayList<Button> arrayBtn = new ArrayList<Button>();

    /// the array to save the history of the calculator as a string
    ArrayList<String> history = new ArrayList<String>();

    /// TextView arraylist to show the history of the calculator
    ArrayList<TextView> viewHistory = new ArrayList<TextView>();

    /// initialize the backend of the calculator
    CalcBackend backend = new CalcBackend();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        // initialize screen and number buttons
        CalcScreen = findViewById(R.id.calcScreen);

        arrayBtn.add((Button) findViewById(R.id.zeroBtn));
        arrayBtn.add((Button) findViewById(R.id.oneBtn));
        arrayBtn.add((Button) findViewById(R.id.twoBtn));
        arrayBtn.add((Button) findViewById(R.id.threeBtn));
        arrayBtn.add((Button) findViewById(R.id.fourBtn));
        arrayBtn.add((Button) findViewById(R.id.fiveBtn));
        arrayBtn.add((Button) findViewById(R.id.sixBtn));
        arrayBtn.add((Button) findViewById(R.id.sevBtn));
        arrayBtn.add((Button) findViewById(R.id.eightBtn));
        arrayBtn.add((Button) findViewById(R.id.nineBtn));

        // add buttons to on click listener
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

        // initialize action and decimal buttons
        arrayBtn.add((Button) findViewById(R.id.acBtn));
        arrayBtn.add((Button) findViewById(R.id.cBtn));
        arrayBtn.add((Button) findViewById(R.id.negBtn));
        arrayBtn.add((Button) findViewById(R.id.multBtn));
        arrayBtn.add((Button) findViewById(R.id.divBtn));
        arrayBtn.add((Button) findViewById(R.id.subBtn));
        arrayBtn.add((Button) findViewById(R.id.addBtn));
        arrayBtn.add((Button) findViewById(R.id.deciBtn));
        arrayBtn.add((Button) findViewById(R.id.equalBtn));

        //add buttons to on click listener
        arrayBtn.get(10).setOnClickListener(this); // all clear button
        arrayBtn.get(11).setOnClickListener(this); // clear last number button
        arrayBtn.get(12).setOnClickListener(this); // flip negation button
        arrayBtn.get(13).setOnClickListener(this); // mult button
        arrayBtn.get(14).setOnClickListener(this); // div button
        arrayBtn.get(15).setOnClickListener(this); // sub button
        arrayBtn.get(16).setOnClickListener(this); // add button
        arrayBtn.get(17).setOnClickListener(this); // decimal button
        arrayBtn.get(18).setOnClickListener(this); // equals button

        // initialize textview history arraylist
        viewHistory.add((TextView) findViewById(R.id.histOne));
        viewHistory.add((TextView) findViewById(R.id.histTwo));
        viewHistory.add((TextView) findViewById(R.id.histThree));
        viewHistory.add((TextView) findViewById(R.id.histFour));
        viewHistory.add((TextView) findViewById(R.id.histFive));

    }


    // code based on: https://stackoverflow.com/questions/17746840/button-array-onclicklistener
    @Override
    public void onClick(View v) {

        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        switch (v.getId()) {
            case R.id.zeroBtn:
                CalcScreen.append(getResources().getString(R.string.zeroBtn));
                vibe.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
                break;
            case R.id.oneBtn:
                CalcScreen.append(getResources().getString(R.string.oneBtn));
                vibe.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
                break;
            case R.id.twoBtn:
                CalcScreen.append(getResources().getString(R.string.twoBtn));
                vibe.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
                break;
            case R.id.threeBtn:
                CalcScreen.append(getResources().getString(R.string.threeBtn));
                vibe.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
                break;
            case R.id.fourBtn:
                CalcScreen.append(getResources().getString(R.string.fourBtn));
                vibe.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
                break;
            case R.id.fiveBtn:
                CalcScreen.append(getResources().getString(R.string.fiveBtn));
                vibe.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
                break;
            case R.id.sixBtn:
                CalcScreen.append(getResources().getString(R.string.sixBtn));
                vibe.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
                break;
            case R.id.sevBtn:
                CalcScreen.append(getResources().getString(R.string.sevBtn));
                vibe.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
                break;
            case R.id.eightBtn:
                CalcScreen.append(getResources().getString(R.string.eightBtn));
                vibe.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
                break;
            case R.id.nineBtn:
                CalcScreen.append(getResources().getString(R.string.nineBtn));
                vibe.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
                break;
            case R.id.acBtn:
                // TODO: on long press, clear history
                CalcScreen.setText("");
                backend.num1 = 0;
                backend.num2 = 0;
                vibe.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
                break;
            case R.id.cBtn:
                // TODO: on back press with no char on screen string, display last number in history
                /// if calcScreen is not empty, then either delete last char or clear screen
                if (!CalcScreen.getText().toString().isEmpty()) {
                    String beforeClear = CalcScreen.getText().toString();
                    if (CalcScreen.getText().length() == 1) {
                        CalcScreen.setText("");
                        backend.backspace("0");
                    } else {
                        CalcScreen.setText(beforeClear.substring(0, (beforeClear.length() - 1)));
                        backend.backspace(beforeClear.substring(0, (beforeClear.length() - 1)));
                    }
                    vibe.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
                }
                break;
            case R.id.negBtn:
                /// determine which number is being shown (num1 or num2), then call
                /// backend negate function
                if(!CalcScreen.getText().toString().isEmpty()) {
                    if (!backend.numflag) {
                        backend.num1 = Double.parseDouble(CalcScreen.getText().toString());
                        backend.negate();
                        CalcScreen.setText(Double.toString(backend.num1));
                    } else {
                        backend.num2 = Double.parseDouble(CalcScreen.getText().toString());
                        backend.negate();
                        CalcScreen.setText(Double.toString(backend.num2));
                    }
                    vibe.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
                }
                break;
            case R.id.multBtn:
                backend.multflag = true;
                updateHist(getResources().getString(R.string.multBtn));
                vibe.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
                break;
            case R.id.divBtn:
                backend.divflag = true;
                updateHist(getResources().getString(R.string.divBtn));
                vibe.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
                break;
            case R.id.subBtn:
                backend.subflag = true;
                updateHist(getResources().getString(R.string.subBtn));
                vibe.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
                break;
            case R.id.addBtn:
                backend.addflag = true;
                updateHist(getResources().getString(R.string.addBtn));
                vibe.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
                break;
            case R.id.deciBtn: /// if screen does not already contain decimal, append one
                if(!CalcScreen.getText().toString().contains(".")){
                    CalcScreen.append(getResources().getString(R.string.deciBtn));
                    vibe.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
                }
                break;
            case R.id.equalBtn:
                backend.numflag = true;
                updateHist(getResources().getString(R.string.equalBtn));
                backend.answer();
                CalcScreen.setText(backend.num1 + "");
                vibe.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
                break;
        }
    }

    /// this method is to be able to update the
    /// history of calculator. the operator symbol is passed as a string,
    /// appended to the string being displayed on screen, clears the screen,
    /// and posts latest string with operator to the history text views
    public void updateHist(String smbl) {
        // TODO: make it so that each equation is on one line.
        //cannot be empty
        if (!CalcScreen.getText().toString().isEmpty()) {

            String addToHistory;

            if (!backend.numflag) {
                backend.num1 = Double.parseDouble(CalcScreen.getText().toString());
                backend.numflag = true;
                addToHistory = Double.toString(backend.num1) + " " + smbl;
            } else {
                backend.num2 = Double.parseDouble(CalcScreen.getText().toString());
                addToHistory = Double.toString(backend.num2) + " " + smbl;
            }

            CalcScreen.setText("");
            history.add(addToHistory);

            int j = history.size() - 1;

            if (history.size() > 5) {
                for (int i = 4; i > -1; i--) {
                    viewHistory.get(i).setText(history.get(j));
                    j--;
                }
            } else {
                int i = 4;
                do {
                    viewHistory.get(i).setText(history.get(j));
                    i--;
                    j--;
                } while (j > -1);
            }
        }
    }
}