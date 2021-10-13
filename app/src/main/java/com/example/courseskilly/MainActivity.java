package com.example.courseskilly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView register = findViewById(R.id.tvRegister);
        TextInputEditText username = findViewById(R.id.tieUser);
        TextInputEditText password = findViewById(R.id.tiePass);
        Editable getUserName = username.getText();
        Editable getPassword = password.getText();
        String admin ="admin";
        String number = "12345";
        Button button = findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "isian username : "+getUserName, Toast.LENGTH_SHORT).show();
                if (getUserName != null && getPassword != null) {
                    if(admin.contentEquals(getUserName)&&number.contentEquals(getPassword)){
                        Toast.makeText(MainActivity.this, "LOGIN SUCCESS", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),MenuMainActivity.class));
                    }else{
                        Toast.makeText(MainActivity.this, "FAILED LOGIN!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
            }
        });
    }
}