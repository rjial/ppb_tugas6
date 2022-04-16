package com.rijal.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnComputer, btnPhone, btnHomeServices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnComputer = (Button) findViewById(R.id.btnComputer);
        btnPhone = (Button) findViewById(R.id.btnPhone);
        btnHomeServices = (Button) findViewById(R.id.btnHomeServices);
    }
}