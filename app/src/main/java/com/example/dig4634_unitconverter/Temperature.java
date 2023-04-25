package com.example.dig4634_unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Temperature extends AppCompatActivity {

    TextView outputText;
    TextInputEditText inputText;
    RadioButton inCelsius, inFahrenheit, inKelvin;
    RadioButton outCelsius, outFahrenheit, outKelvin;
    MaterialButton cv_convert;

    String fromUnit = "Celsius";
    String toUnit = "Fahrenheit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        inCelsius = findViewById(R.id.celsius);
        inFahrenheit = findViewById(R.id.fahrenheit);
        inKelvin = findViewById(R.id.kelvin);
        cv_convert = findViewById(R.id.convert);
        outCelsius = findViewById(R.id.celsius2);
        outFahrenheit = findViewById(R.id.fahrenheit2);
        outKelvin = findViewById(R.id.kelvin2);
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
                    if (fromUnit.equals("Celsius")) {
                        if (toUnit.equals("Celsius")) {
                            outputText.setText(tempInput);
                            return;
                        } else if (toUnit.equals("Fahrenheit")) {
                            outputText.setText(celsiusToFahrenheit(Double.parseDouble(tempInput)));
                            return;
                        } else if (toUnit.equals("Kelvin")) {
                            outputText.setText(celsiusToKelvin(Double.parseDouble(tempInput)));
                            return;
                        }
                    } else if (fromUnit.equals("Fahrenheit")) {
                        if (toUnit.equals("Celsius")) {
                            outputText.setText(fahrenheitToCelsius(Double.parseDouble(tempInput)));
                            return;
                        } else if (toUnit.equals("Fahrenheit")) {
                            outputText.setText(tempInput);
                            return;
                        } else if (toUnit.equals("Kelvin")) {
                            outputText.setText(fahrenheitToKelvin(Double.parseDouble(tempInput)));
                            return;
                        }
                    } else if (fromUnit.equals("Kelvin")) {
                        if (toUnit.equals("Celsius")) {
                            outputText.setText(kelvinToCelsius(Double.parseDouble(tempInput)));
                            return;
                        } else if (toUnit.equals("Fahrenheit")) {
                            outputText.setText(kelvinToFahrenheit(Double.parseDouble(tempInput)));
                            return;
                        } else if (toUnit.equals("Kelvin")) {
                            outputText.setText(tempInput);
                            return;
                        }
                    }
                }
            }
        });

        inCelsius.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fromUnit = "Celsius";
                return;
            }
        });

        inFahrenheit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fromUnit = "Fahrenheit";
                return;
            }
        });

        inKelvin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fromUnit = "Kelvin";
                return;
            }
        });

        outCelsius.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                toUnit = "Celsius";
                return;
            }
        });

        outFahrenheit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                toUnit = "Fahrenheit";
                return;
            }
        });

        outKelvin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                toUnit = "Kelvin";
                return;
            }
        });
    }


        //Celsius
        private String celsiusToKelvin ( double celsius){
            double kelvin = celsius + 273.15;
            return String.valueOf(kelvin);
        }

        private String celsiusToFahrenheit ( double celsius){
            double fahrenheit = (celsius * 9 / 5) + 32;
            return String.valueOf(fahrenheit);
        }

        //fahrenheit
        private String fahrenheitToKelvin ( double fahrenheit){
            double kelvin = 273.5 + ((fahrenheit - 32.0) * (5.0 / 9.0));
            return String.valueOf(kelvin);
        }

        private String fahrenheitToCelsius ( double fahrenheit){
            double celsius = (fahrenheit - 32) * 5 / 9;
            return String.valueOf(celsius);
        }

        //Kelvin
        private String kelvinToCelsius ( double kelvin){
            double celsius = kelvin - 273.15;
            return String.valueOf(celsius);
        }

        private String kelvinToFahrenheit ( double kelvin){
            double fahrenheit = (kelvin - 273.15) * 1.8 + 32;
            return String.valueOf(fahrenheit);
        }

    }
