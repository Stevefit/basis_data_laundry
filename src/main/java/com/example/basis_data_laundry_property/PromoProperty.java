package com.example.basis_data_laundry_property;

import com.example.basis_data_laundry.Promo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PromoProperty {
    private final StringProperty promo_id, start_date, promo_name, end_date, amount;
    public PromoProperty(){
        promo_id = new SimpleStringProperty(this, "promo id");
        promo_name = new SimpleStringProperty(this, "promo_name");
        start_date = new SimpleStringProperty(this, "start date");
        end_date =  new SimpleStringProperty(this, "end date");
        amount = new SimpleStringProperty(this, "amount");
    }

    public String getPromo_id() {
        return promo_id.get();
    }

    public StringProperty promo_idProperty() {
        return promo_id;
    }

    public void setPromo_id(String promo_id) {
        this.promo_id.set(promo_id);
    }

    public String getStart_date() {
        return start_date.get();
    }

    public StringProperty start_dateProperty() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date.set(start_date);
    }

    public String getPromo_name() {
        return promo_name.get();
    }

    public StringProperty promo_nameProperty() {
        return promo_name;
    }

    public void setPromo_name(String promo_name) {
        this.promo_name.set(promo_name);
    }

    public String getEnd_date() {
        return end_date.get();
    }

    public StringProperty end_dateProperty() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date.set(end_date);
    }

    public String getAmount() {
        return amount.get();
    }

    public StringProperty amountProperty() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount.set(amount);
    }
}
