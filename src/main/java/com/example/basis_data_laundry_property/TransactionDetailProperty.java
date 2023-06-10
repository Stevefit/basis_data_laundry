package com.example.basis_data_laundry_property;

import com.example.basis_data_laundry.TransactionDetail;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TransactionDetailProperty {
    private final StringProperty transaction_detail_id, laundry_type, description, pick_up_date, items_sub_amount;

    public TransactionDetailProperty(){
        transaction_detail_id = new SimpleStringProperty(this, "transaction detail id");
        laundry_type = new SimpleStringProperty(this, "laundry type");
        description = new SimpleStringProperty(this,"description");
        pick_up_date = new SimpleStringProperty(this, "pick up date");
        items_sub_amount = new SimpleStringProperty(this, "items sub amount");
    }

    public String getTransaction_detail_id() {
        return transaction_detail_id.get();
    }

    public StringProperty transaction_detail_idProperty() {
        return transaction_detail_id;
    }

    public void setTransaction_detail_id(String transaction_detail_id) {
        this.transaction_detail_id.set(transaction_detail_id);
    }

    public String getLaundry_type() {
        return laundry_type.get();
    }

    public StringProperty laundry_typeProperty() {
        return laundry_type;
    }

    public void setLaundry_type(String laundry_type) {
        this.laundry_type.set(laundry_type);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getPick_up_date() {
        return pick_up_date.get();
    }

    public StringProperty pick_up_dateProperty() {
        return pick_up_date;
    }

    public void setPick_up_date(String pick_up_date) {
        this.pick_up_date.set(pick_up_date);
    }

    public String getItems_sub_amount() {
        return items_sub_amount.get();
    }

    public StringProperty items_sub_amountProperty() {
        return items_sub_amount;
    }

    public void setItems_sub_amount(String items_sub_amount) {
        this.items_sub_amount.set(items_sub_amount);
    }
}
