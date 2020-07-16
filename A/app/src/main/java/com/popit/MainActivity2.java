package com.popit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity2 extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText modelName = findViewById(R.id.model_name);
        Button previewButton = findViewById(R.id.preview_model_button);

        previewButton.setOnClickListener(v -> {
            DataHolder.modelLink=modelName.getText().toString();
            Intent in = new Intent(this, ARActivity.class);
            startActivity(in);
        });

        Toolbar toolbar=findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(v -> {
            Intent in = new Intent(this, CreaditsActivity.class);
            startActivity(in);
        });
    }
}