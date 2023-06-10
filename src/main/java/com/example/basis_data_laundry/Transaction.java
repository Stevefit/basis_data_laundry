package com.example.basis_data_laundry;

public class Transaction {
    public String transaction_id, entry_date, finished_date;
    public double down_payment, total_amount;

    public Transaction(String transaction_id, String entry_date, String finished_date, double down_payment, double total_amount) {
        this.transaction_id = transaction_id;
        this.entry_date = entry_date;
        this.finished_date = finished_date;
        this.down_payment = down_payment;
        this.total_amount = total_amount;
    }
}
