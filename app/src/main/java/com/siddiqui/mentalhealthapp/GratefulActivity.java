package com.siddiqui.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class GratefulActivity extends AppCompatActivity {

    private TextView textView;
    private ProgressBar progressBar;
    private SeekBar seekBarl;
    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grateful);

        textView = findViewById(R.id.numberPercent);
        progressBar = findViewById(R.id.progressBar);
        seekBarl = findViewById(R.id.seekBar);

        seekBarl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress>=0&&progress<20){
                    seekBar.setBackgroundColor(Color.parseColor("#B22222"));
                    progressBar.setBackgroundColor(Color.parseColor("#B22222"));
                } else if(progress>=20&&progress<40){
                    seekBar.setBackgroundColor(Color.parseColor("#CD5C5C"));
                    progressBar.setBackgroundColor(Color.parseColor("#CD5C5C"));
                } else if(progress>=40&&progress<60){
                    seekBar.setBackgroundColor(Color.parseColor("#B19CD9"));
                    progressBar.setBackgroundColor(Color.parseColor("#B19CD9"));
                } else {
                    seekBar.setBackgroundColor(Color.parseColor("#C3CdE6"));
                    progressBar.setBackgroundColor(Color.parseColor("#C3CdE6"));
                }
                progressBar.setProgress(progress);
                if (progress==100){
                    progress=99;
                }
                textView.setText(progress/20+1 +"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
