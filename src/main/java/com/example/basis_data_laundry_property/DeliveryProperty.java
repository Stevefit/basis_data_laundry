package com.example.basis_data_laundry_property;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DeliveryProperty {
    private final StringProperty delivery_id, address, delivery_type, delivery_sub_amount;
    public DeliveryProperty(){
        delivery_id = new SimpleStringProperty(this, "delivery id");
        address = new SimpleStringProperty(this, "address");
        delivery_type = new SimpleStringProperty(this, "delivery type");
        delivery_sub_amount= new SimpleStringProperty(this, "delivery amount");
    }

    public String getDelivery_id() {
        return delivery_id.get();
    }

    public StringProperty delivery_idProperty() {
        return delivery_id;
    }

    public void setDelivery_id(String delivery_id) {
        this.delivery_id.set(delivery_id);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getDelivery_type() {
        return delivery_type.get();
    }

    public StringProperty delivery_typeProperty() {
        return delivery_type;
    }

    public void setDelivery_type(String delivery_type) {
        this.delivery_type.set(delivery_type);
    }

    public String getDelivery_sub_amount() {
        return delivery_sub_amount.get();
    }

    public StringProperty delivery_sub_amountProperty() {
        return delivery_sub_amount;
    }

    public void setDelivery_sub_amount(String delivery_sub_amount) {
        this.delivery_sub_amount.set(delivery_sub_amount);
    }
}
