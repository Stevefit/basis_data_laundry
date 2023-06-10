package com.example.basis_data_laundry;

public class Delivery {
    public String delivery_id, address, delivery_type;
    public double delivery_sub_amount;

    public Delivery(String delivery_id, String address, String delivery_type, double delivery_sub_amount) {
        this.delivery_id = delivery_id;
        this.address = address;
        this.delivery_type = delivery_type;
        this.delivery_sub_amount = delivery_sub_amount;
    }
}
