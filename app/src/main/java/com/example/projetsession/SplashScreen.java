package com.example.projetsession;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetsession.Accueil.Accueil;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3250;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent i = new Intent(SplashScreen.this, MapsActivity.class);
                Intent i = new Intent(SplashScreen.this, Accueil.class); //Accueil
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
