package com.popit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        new Thread(() -> {
            try{
                Thread.sleep(3500l);
                Intent in = new Intent(SplashActivity.this, MainActivity2.class);
                startActivity(in);
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
    }
}