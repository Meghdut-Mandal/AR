package com.popit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.popit.R;

public class CreaditsActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creadits);
    }


    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        this.finish();
    }
}