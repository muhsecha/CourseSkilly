package com.example.courseskilly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MenuMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);

        RelativeLayout rlCalcu = findViewById(R.id.rlcalcu);
        rlCalcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuMainActivity.this, "Calculator BANG!!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),CalcuActivity.class));
            }
        });
    }
}