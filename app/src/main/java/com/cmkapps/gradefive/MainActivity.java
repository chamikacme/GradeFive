package com.cmkapps.gradefive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    //Initialize variable
    TextView txtTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Assign Variable
        txtTimer = findViewById(R.id.txtRemainingTime);

        //Initialize timer duration
        final long duration = TimeUnit.MINUTES.toMillis(2);

        //Initialize Countdown timer
        new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long l) {
                //on tick
                String sDuaration = String.format(Locale.ENGLISH,"%02d : %02d",TimeUnit.MILLISECONDS.toMinutes(l),
                        TimeUnit.MILLISECONDS.toSeconds(l)- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));

                //set conveted time on textview
                txtTimer.setText(sDuaration);

            }

            @Override
            public void onFinish() {
                //on finished
                Toast.makeText(getApplicationContext(),"Time Up",Toast.LENGTH_SHORT).show();

            }
        }.start();




    }
}
