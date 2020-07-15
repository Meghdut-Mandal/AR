package com.example.a;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

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


    }
}