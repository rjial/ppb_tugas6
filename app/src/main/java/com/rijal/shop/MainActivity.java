package com.rijal.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnComputer, btnPhone, btnHomeServices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnComputer = (Button) findViewById(R.id.btnComputer);
        btnPhone = (Button) findViewById(R.id.btnPhone);
        btnHomeServices = (Button) findViewById(R.id.btnHomeServices);
        btnComputer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Computer", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ItemActivity.class);
                intent.putExtra("MENUITEM" , "COMPUTER");
                startActivity(intent);
            }
        });
        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ItemActivity.class);
                intent.putExtra("MENUITEM" , "PHONE");
                startActivity(intent);
            }
        });
        btnHomeServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ItemActivity.class);
                intent.putExtra("MENUITEM" , "HOME_SERVICES");
                startActivity(intent);
            }
        });
    }
}