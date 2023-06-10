package com.example.basis_data_laundry;

public class Item {
    public String item_id, item_name;
    public int duration;
    public double price;

    public Item(String item_id, String item_name, int duration, double price) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.duration = duration;
        this.price = price;
    }
}
