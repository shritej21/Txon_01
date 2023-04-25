package com.example.dig4634_unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Weight extends AppCompatActivity {

    TextView outputText;
    TextInputEditText inputText;
    RadioButton inKilogram, inPound, inOunce;
    RadioButton outKilogram, outPound, outOunce;
    MaterialButton cv_convert;

    String fromUnit = "Kilogram";
    String toUnit = "Pound";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        inKilogram = findViewById(R.id.kilogram);
        inPound = findViewById(R.id.pound);
        inOunce = findViewById(R.id.ounce);
        cv_convert = findViewById(R.id.convert);
        outKilogram = findViewById(R.id.kilogram2);
        outPound = findViewById(R.id.pound2);
        outOunce = findViewById(R.id.ounce2);
        inputText = findViewById(R.id.input);
        outputText = findViewById(R.id.output);

        cv_convert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                MaterialButton button = (MaterialButton) view;
                String buttonText = button.getText().toString();

                outputText.setText("");

                String tempInput = inputText.getText().toString();

                if (tempInput.equals("")) {
                    outputText.setError("Please enter some value");
                } else {
                    if (fromUnit.equals("Kilogram")) {
                        if (toUnit.equals("Kilogram")) {
                            outputText.setText(tempInput);
                            return;
                        } else if (toUnit.equals("Pound")) {
                            outputText.setText(kilogramToPound(Double.parseDouble(tempInput)));
                            return;
                        } else if (toUnit.equals("Ounce")) {
                            outputText.setText(kilogramToOunce(Double.parseDouble(tempInput)));
                            return;
                        }
                    } else if (fromUnit.equals("Pound")) {
                        if (toUnit.equals("Kilogram")) {
                            outputText.setText(poundToKilogram(Double.parseDouble(tempInput)));
                            return;
                        } else if (toUnit.equals("Pound")) {
                            outputText.setText(tempInput);
                            return;
                        } else if (toUnit.equals("Ounce")) {
                            outputText.setText(poundToOunce(Double.parseDouble(tempInput)));
                            return;
                        }
                    } else if (fromUnit.equals("Ounce")) {
                        if (toUnit.equals("Kilogram")) {
                            outputText.setText(ounceToKilogram(Double.parseDouble(tempInput)));
                            return;
                        } else if (toUnit.equals("Pound")) {
                            outputText.setText(ounceToPound(Double.parseDouble(tempInput)));
                            return;
                        } else if (toUnit.equals("Ounce")) {
                            outputText.setText(tempInput);
                            return;
                        }
                    }
                }
            }
        });

        inKilogram.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fromUnit = "Kilogram";
                return;
            }
        });

        inPound.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fromUnit = "Pound";
                return;
            }
        });

        inOunce.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fromUnit = "Ounce";
                return;
            }
        });

        outKilogram.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                toUnit = "Kilogram";
                return;
            }
        });

        outPound.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                toUnit = "Pound";
                return;
            }
        });

        outOunce.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                toUnit = "Ounce";
                return;
            }
        });
    }


    //Kilogram
    private String kilogramToPound ( double kilogram){
        double pound = kilogram * 2.2;
        return String.valueOf(pound);
    }

    private String kilogramToOunce ( double kilogram){
        double ounce = kilogram * 35.2739619;
        return String.valueOf(ounce);
    }

    //Pound
    private String poundToKilogram ( double pound){
        double kilogram = pound * 0.45359237;
        return String.valueOf(kilogram);
    }

    private String poundToOunce ( double pound){
        double ounce = pound * 16;
        return String.valueOf(ounce);
    }

    //Ounce
    private String ounceToKilogram ( double ounce){
        double kilogram = ounce * 0.028349523;
        return String.valueOf(kilogram);
    }

    private String ounceToPound ( double ounce){
        double pound = ounce / 16;
        return String.valueOf(pound);
    }

}
