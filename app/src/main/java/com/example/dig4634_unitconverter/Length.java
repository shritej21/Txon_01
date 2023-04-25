package com.example.dig4634_unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Length extends AppCompatActivity {

    TextView outputText;
    TextInputEditText inputText;
    RadioButton inMeter, inFoot, inMile;
    RadioButton outMeter, outFoot, outMile;
    MaterialButton cv_convert;

    String fromUnit = "Meter";
    String toUnit = "Foot";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        inMeter = findViewById(R.id.meter);
        inFoot = findViewById(R.id.foot);
        inMile = findViewById(R.id.mile);
        cv_convert = findViewById(R.id.convert);
        outMeter = findViewById(R.id.meter2);
        outFoot = findViewById(R.id.foot2);
        outMile = findViewById(R.id.mile2);
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
                    if (fromUnit.equals("Meter")) {
                        if (toUnit.equals("Meter")) {
                            outputText.setText(tempInput);
                            return;
                        } else if (toUnit.equals("Foot")) {
                            outputText.setText(meterToFoot(Double.parseDouble(tempInput)));
                            return;
                        } else if (toUnit.equals("Mile")) {
                            outputText.setText(meterToMile(Double.parseDouble(tempInput)));
                            return;
                        }
                    } else if (fromUnit.equals("Foot")) {
                        if (toUnit.equals("Meter")) {
                            outputText.setText(footToMeter(Double.parseDouble(tempInput)));
                            return;
                        } else if (toUnit.equals("Foot")) {
                            outputText.setText(tempInput);
                            return;
                        } else if (toUnit.equals("Mile")) {
                            outputText.setText(footToMile(Double.parseDouble(tempInput)));
                            return;
                        }
                    } else if (fromUnit.equals("Mile")) {
                        if (toUnit.equals("Meter")) {
                            outputText.setText(mileToMeter(Double.parseDouble(tempInput)));
                            return;
                        } else if (toUnit.equals("Foot")) {
                            outputText.setText(mileToFoot(Double.parseDouble(tempInput)));
                            return;
                        } else if (toUnit.equals("Mile")) {
                            outputText.setText(tempInput);
                            return;
                        }
                    }
                }
            }
        });

        inMeter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fromUnit = "Meter";
                return;
            }
        });

        inFoot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fromUnit = "Foot";
                return;
            }
        });

        inMile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fromUnit = "Mile";
                return;
            }
        });

        outMeter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                toUnit = "Meter";
                return;
            }
        });

        outFoot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                toUnit = "Foot";
                return;
            }
        });

        outMile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                toUnit = "Mile";
                return;
            }
        });
    }


    //Meter
    private String meterToFoot ( double meter){
        double foot = meter * 3.28084;
        return String.valueOf(foot);
    }

    private String meterToMile ( double meter){
        double mile = meter / 1609.344;
        return String.valueOf(mile);
    }

    //Foot
    private String footToMeter ( double foot){
        double meter = foot * 0.3048;
        return String.valueOf(meter);
    }

    private String footToMile ( double foot){
        double mile = foot / 5280;
        return String.valueOf(mile);
    }

    //Mile
    private String mileToMeter ( double mile){
        double meter = mile * 1609.344;
        return String.valueOf(meter);
    }

    private String mileToFoot ( double mile){
        double foot = mile * 5280;
        return String.valueOf(foot);
    }

}
