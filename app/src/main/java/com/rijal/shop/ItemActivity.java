package com.rijal.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

public class ItemActivity extends AppCompatActivity {

    private int indexItem = 0;
    ImageView imgIcon;
    TextView txtJudulBarang, txtHargaBarang;
    Button btnNextItem, btnPrevItem, btnContactUs, btnHome;
    List<Item> listItem = Item.dictItemComputer;
    String stringFromParentIntent = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        imgIcon = (ImageView) findViewById(R.id.imgIcon);
        txtJudulBarang = (TextView) findViewById(R.id.txtJudulBarang);
        txtHargaBarang = (TextView) findViewById(R.id.txtHargaBarang);
        btnNextItem = (Button) findViewById(R.id.btnNextItem);
        btnPrevItem = (Button) findViewById(R.id.btnPreviousItem);
        btnContactUs = (Button) findViewById(R.id.btnContactUs);
        btnHome = (Button) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Intent intent = getIntent();
        stringFromParentIntent = intent.getStringExtra("MENUITEM");
        switch (stringFromParentIntent) {
            case "COMPUTER":
                listItem = Item.dictItemComputer;
                break;
            case "PHONE":
                listItem = Item.dictItemPhone;
                break;
            case "HOME_SERVICES":
                listItem = Item.dictItemHomeServices;
                break;
        }
        selectItem(indexItem);
        btnNextItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                indexItem += 1;
                selectItem(indexItem);
            }
        });
        btnPrevItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                indexItem -= 1;
                selectItem(indexItem);
            }
        });
    }
    private void selectItem(int index) {
        Currency currency = Currency.getInstance(new Locale("id", "ID"));
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

        Item item = listItem.get(index);
        imgIcon.setImageResource(item.getImage());
        txtJudulBarang.setText(item.getNama_item());
        txtHargaBarang.setText(numberFormat.format(item.getHarga()));
        if (index == 0) {
            btnNextItem.setVisibility(View.VISIBLE);
            btnPrevItem.setVisibility(View.GONE);
        } else if(index == listItem.size() - 1) {
            btnNextItem.setVisibility(View.GONE);
            btnPrevItem.setVisibility(View.VISIBLE);
        } else {
            btnNextItem.setVisibility(View.VISIBLE);
            btnPrevItem.setVisibility(View.VISIBLE);
        }
    }
}