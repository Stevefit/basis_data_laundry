package com.example.basis_data_laundry;

public class DeliveryPriceRange {
    public String ddl_id, start_date, end_date;
    public int radius;
    public double minimum_amount;

    public DeliveryPriceRange(String ddl_id, String start_date, String end_date, int radius, double minimum_amount) {
        this.ddl_id = ddl_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.radius = radius;
        this.minimum_amount = minimum_amount;
    }
}
