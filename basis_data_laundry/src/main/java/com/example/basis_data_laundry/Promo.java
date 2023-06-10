package com.example.basis_data_laundry;

public class Promo {
    public String promo_id, start_date, promo_name, end_date;
    public int amount;

    public Promo(String promo_id, String start_date, String promo_name, String end_date, int amount) {
        this.promo_id = promo_id;
        this.start_date = start_date;
        this.promo_name = promo_name;
        this.end_date = end_date;
        this.amount = amount;
    }
}
