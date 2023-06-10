package com.example.basis_data_laundry;

public class Customer {
    public String customer_id, customer_name, address;
    public String phone_number;

    public Customer(String customer_id, String customer_name, String address, String phone_number) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.address = address;
        this.phone_number = phone_number;
    }
}
