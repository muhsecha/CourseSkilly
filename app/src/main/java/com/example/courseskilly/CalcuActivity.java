package com.example.courseskilly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

public class CalcuActivity extends AppCompatActivity {

    TextView arit,hasil;
    TextInputEditText edbil1,edbil2;
    Button btnplus,btnminus,btnbagi,btnkali,btnhasil,btnc;
    float value1,value2;
    boolean isadd,issub,isdiv,ismul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcu);
        arit = findViewById(R.id.tvbil2);
        btnplus = findViewById(R.id.btnplus);
        btnminus = findViewById(R.id.btnminus);
        btnbagi = findViewById(R.id.btnbagi);
        btnc = findViewById(R.id.btnc);
        btnkali = findViewById(R.id.btnkali);
        btnhasil = findViewById(R.id.btnhasil);
        edbil1 = findViewById(R.id.tieb1);
        edbil2 = findViewById(R.id.tieb2);

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arit.setText("( + )");
                isadd = true;
            }
        });

        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arit.setText("( - )");
                issub = true;
            }
        });

        btnkali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arit.setText("( x )");
                ismul = true;
            }
        });

        btnbagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arit.setText("( / )");
                isdiv = true;
            }
        });

        btnhasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               pilihan();
            }
        });
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edbil1.setText("");
                edbil2.setText("");
                hasil.setText("0");
            }
        });
    }

    // a public method to get the input numbers
    public boolean getNumbers() {

        // defining the edit text 1 to e1
        edbil1 = findViewById(R.id.tieb1);
        edbil2 = findViewById(R.id.tieb2);

        // defining the text view to t1
        hasil = findViewById(R.id.tvbil5);

        // taking input from text box 1
        Editable getbil1 = edbil1.getText();
        Editable getbil2 = edbil2.getText();

        // condition to check if box is not empty

        if (getbil1.equals(null) && getbil2.equals(null)) {

            Toast.makeText(getApplicationContext(), "Please enter a value", Toast.LENGTH_SHORT).show();

            return false;
        } else {
            // converting string to int.
            value1 = Integer.parseInt(Objects.requireNonNull(edbil1.getText()).toString());

            // converting string to int.
            value2 = Integer.parseInt(Objects.requireNonNull(edbil2.getText()).toString());
        }

        return true;
    }
    public void pilihan(){
        int pilihan = 0;

        if (isadd){
            pilihan = 1;
        } else if (issub){
            pilihan = 2;
        } else if (isdiv){
            pilihan = 3;
        } else if (ismul){
            pilihan = 4;
        }
        switch (pilihan){
            case 1:
                if (getNumbers()) {
                    int sum = (int) (value1 + value2);
                    hasil.setText(Integer.toString(sum));
                    isadd = false;
                }
                break;
            case 2:
                if (getNumbers()) {
                    int sum = (int)(value1 - value2);
                    hasil.setText(Integer.toString(sum));
                    issub = false;
                }
                break;
            case 4:
                if (getNumbers()) {
                    int sum = (int) (value1 * value2);
                    hasil.setText(Integer.toString(sum));
                    ismul = false;
                }
                break;
            case 3:
                if (getNumbers()) {
                    double sum = value1 / (value2 * 1.0);
                    hasil.setText(Double.toString(sum));
                    isdiv = false;
                }
                break;
            default:
                System.out.println("I don't know!");
        }
    }


    // a public method to perform power function
    public void doPow(View v) {

        // get the input numbers
        if (getNumbers()) {
            double sum = Math.pow(value1, value2);
            hasil.setText(Double.toString(sum));
        }
    }

    // a public method to perform modulus function
    public void doMod(View v) {

        // get the input numbers
        if (getNumbers()) {
            double sum = value1 % value2;
            hasil.setText(Double.toString(sum));
        }
    }
}