package com.iwtechnocrat.walijon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Act_SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splashscreen);

    }

    private void startTimer() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

          Intent intent = new Intent(getApplicationContext(),Act_Login.class);
           startActivity(intent);

            }

        },SPLASH_TIME_OUT);


    }

    @Override
    protected void onStart() {
        super.onStart();
        startTimer();
    }

}