package com.malingi.orbicoin.authentication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;


import com.example.orbicoin.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle s) {
        super.onCreate(s);

        setContentView(R.layout.activity_splash);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), AddUserActivity.class));
            }
        }, 5000);
    }
}
