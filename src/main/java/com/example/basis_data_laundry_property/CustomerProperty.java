package com.example.basis_data_laundry_property;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CustomerProperty {
    private final StringProperty customer_id, customer_name, address, phone_number;

    public CustomerProperty(){
        customer_id = new SimpleStringProperty(this, "customer id");
        customer_name = new SimpleStringProperty(this, "customer name");
        address = new SimpleStringProperty(this, "address");
        phone_number = new SimpleStringProperty(this, "phone number");
    }

    public String getCustomer_id() {
        return customer_id.get();
    }

    public StringProperty customer_idProperty() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id.set(customer_id);
    }

    public String getCustomer_name() {
        return customer_name.get();
    }

    public StringProperty customer_nameProperty() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name.set(customer_name);
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

    public String getPhone_number() {
        return phone_number.get();
    }

    public StringProperty phone_numberProperty() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number.set(phone_number);
    }
}
