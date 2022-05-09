package com.rijal.shop;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item implements Parcelable {
    private int image;
    private String nama_item;
    private int harga;

    public static List<Item> dictItemComputer = Arrays.asList(
            new Item(R.drawable.acer_laptop, "Acer Heilos 300", 20000000),
            new Item(R.drawable.asus_rog, "Asus ROG Strix G15", 13500000),
            new Item(R.drawable.hp_pavillion, "HP Pavillion", 13000000),
            new Item(R.drawable.thinkpad_x240, "Lenovo Thinkpad X240", 3000000)
    );
    public static List<Item> dictItemPhone = Arrays.asList(
            new Item(R.drawable.iphone_11, "IPhone 11", 11000000),
            new Item(R.drawable.poco_x3, "Poco X3", 4000000),
            new Item(R.drawable.galaxy_note_10, "Samsung Galaxy Note 10", 10000000)
    );
    public static List<Item> dictItemHomeServices = Arrays.asList(
            new Item(R.drawable.samsung_canister, "Samsung Canister", 3500000),
            new Item(R.drawable.xiamoi_mijia, "Xiaomi Mijia", 3500000),
            new Item(R.drawable.irobot_roomba, "IRobot Roomba", 4000000)
    );

    public Item(int image, String nama_item, int harga) {
        this.image = image;
        this.nama_item = nama_item;
        this.harga = harga;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNama_item() {
        return nama_item;
    }

    public void setNama_item(String nama_item) {
        this.nama_item = nama_item;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.image);
        dest.writeString(this.nama_item);
        dest.writeInt(this.harga);
    }

    public void readFromParcel(Parcel source) {
        this.image = source.readInt();
        this.nama_item = source.readString();
        this.harga = source.readInt();
    }

    protected Item(Parcel in) {
        this.image = in.readInt();
        this.nama_item = in.readString();
        this.harga = in.readInt();
    }

    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
