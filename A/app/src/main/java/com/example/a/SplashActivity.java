package com.example.a;

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
                Thread.sleep(1000l);
                Intent in = new Intent(SplashActivity.this, MainActivity2.class);
                startActivity(in);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
    }
}