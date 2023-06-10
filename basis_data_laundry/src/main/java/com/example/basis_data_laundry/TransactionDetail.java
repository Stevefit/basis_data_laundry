package com.example.basis_data_laundry;

public class TransactionDetail {
    public String transaction_detail_id, laundry_type, description, pick_up_date;
    public double items_sub_amount;

    public TransactionDetail(String transaction_detail_id, String laundry_type, String description, String pick_up_date, double items_sub_amount) {
        this.transaction_detail_id = transaction_detail_id;
        this.laundry_type = laundry_type;
        this.description = description;
        this.pick_up_date = pick_up_date;
        this.items_sub_amount = items_sub_amount;
    }
}
