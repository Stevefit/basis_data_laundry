package com.example.basis_data_laundry_property;

import com.example.basis_data_laundry.Transaction;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TransactionProperty {
    private final StringProperty transaction_id, entry_date, finished_date, down_payment, total_amount;
    public TransactionProperty(){
        transaction_id = new SimpleStringProperty(this, "transaction id");
        entry_date = new SimpleStringProperty(this, "entry date");
        finished_date = new SimpleStringProperty(this, "finished date");
        down_payment = new SimpleStringProperty(this, "down payment");
        total_amount = new SimpleStringProperty(this, "total amount");
    }

    public String getTransaction_id() {
        return transaction_id.get();
    }

    public StringProperty transaction_idProperty() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id.set(transaction_id);
    }

    public String getEntry_date() {
        return entry_date.get();
    }

    public StringProperty entry_dateProperty() {
        return entry_date;
    }

    public void setEntry_date(String entry_date) {
        this.entry_date.set(entry_date);
    }

    public String getFinished_date() {
        return finished_date.get();
    }

    public StringProperty finished_dateProperty() {
        return finished_date;
    }

    public void setFinished_date(String finished_date) {
        this.finished_date.set(finished_date);
    }

    public String getDown_payment() {
        return down_payment.get();
    }

    public StringProperty down_paymentProperty() {
        return down_payment;
    }

    public void setDown_payment(String down_payment) {
        this.down_payment.set(down_payment);
    }

    public String getTotal_amount() {
        return total_amount.get();
    }

    public StringProperty total_amountProperty() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount.set(total_amount);
    }
}
