package com.popit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toolbar;

import com.popit.R;

public class CreaditsActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creadits);
        androidx.appcompat.widget.Toolbar toolbar=findViewById(R.id.credits_toolbar);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }


    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        this.finish();
    }
}