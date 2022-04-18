package com.rijal.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemActivity extends AppCompatActivity {

    private int indexItem = 0;
    ImageView imgIcon;
    TextView txtJudulBarang, txtHargaBarang;
    Button btnNextItem, btnPrevItem, btnContactUs, btnHome;
    List<Item> listItem = Item.dictItemComputer;
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
        Item item = listItem.get(index);
        imgIcon.setImageResource(item.getImage());
        txtJudulBarang.setText(item.getNama_item());
        txtHargaBarang.setText("Rp. " + String.valueOf(item.getHarga()));
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