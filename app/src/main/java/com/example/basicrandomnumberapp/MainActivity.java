package com.example.basicrandomnumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///Change range in text on change of seekbar
        /// the seekBar
        SeekBar rngSelct = findViewById(R.id.range_selector);
        rngSelct.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                /// the seekBar
                SeekBar rngSelct = findViewById(R.id.range_selector);

                int newTopRng = rngSelct.getProgress() + 1;

                String rng = "1-" + Integer.toString(newTopRng);

                /// the TextView of the range given for seekBar selection: "1 - (selected number here)"
                TextView rngTxt = findViewById(R.id.rngTxt);

                rngTxt.setText(newTopRng+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO: auto-generate method
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO: auto-generate method
            }
        });

        ///Get random number after pressing button
        Button random_butt = findViewById(R.id.randomize_butt);
        random_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                /// random number generator initialize
                Random rand = new Random();
                /// the TextView of the result from random number selection
                TextView result_num = findViewById(R.id.num_select);
                /// the seekBar
                SeekBar rngSelct = findViewById(R.id.range_selector);

                int topNum = rand.nextInt(rngSelct.getProgress() + 1) + 1;

                result_num.setText(topNum+"");
            }
        });


    }
}
