package com.example.dig4634_unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    MaterialButton length, temperature, weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignId(length,R.id.length);
        assignId(temperature,R.id.temperature);
        assignId(weight,R.id.weight);
    }

    void assignId(MaterialButton btn,int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();

        if (buttonText.equals("Length")) {
            Intent myIntent=new Intent(getBaseContext(), Length.class);
            startActivity(myIntent);
            return;
        }
        if (buttonText.equals("Temperature")) {
            Intent myIntent=new Intent(getBaseContext(), Temperature.class);
            startActivity(myIntent);
            return;
        }
        if (buttonText.equals("Weight")) {
            Intent myIntent=new Intent(getBaseContext(), Weight.class);
            startActivity(myIntent);
            return;
        }
    }
}