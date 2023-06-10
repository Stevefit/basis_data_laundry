package com.example.basis_data_laundry_property;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.SimpleTimeZone;

public class PaymentMethodProperty {
    private final StringProperty payment_method_id, payment_method_name;

    public PaymentMethodProperty(){
        payment_method_id = new SimpleStringProperty(this, "payment method id");
        payment_method_name = new SimpleStringProperty(this, "payment method name");
    }
}
