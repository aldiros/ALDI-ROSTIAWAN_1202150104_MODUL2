package com.example.aldiros.modul2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=2000;    //waktu untuk menampilkan Splash

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
         @Override
            public void run(){
            Intent homeIntent = new Intent(MainActivity.this, homeActivity.class);  //intent untuk pindah screen
             startActivity(homeIntent);
         }
        },SPLASH_TIME_OUT);
    }
}

