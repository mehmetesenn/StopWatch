package com.mehmetesen.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;



public class MainActivity extends AppCompatActivity {
    Button button;
    Button button1;
    Chronometer chronometer;
    private long PauseOffset=0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button1);
        chronometer=findViewById(R.id.chronometer);
        button1=findViewById(R.id.button);


    }


    public void start(View view){
        chronometer.setBase(SystemClock.elapsedRealtime()-PauseOffset);
        chronometer.start();
        button.setEnabled(false);
    }
    public void pause(View view){
            chronometer.stop();
            PauseOffset=SystemClock.elapsedRealtime()-chronometer.getBase();
             button.setEnabled(true);

    }

    public void reset(View view){

        button1.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                PauseOffset=0;

            }
        });

    }




}