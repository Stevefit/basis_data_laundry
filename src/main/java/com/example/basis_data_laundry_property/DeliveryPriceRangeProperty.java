package com.example.basis_data_laundry_property;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DeliveryPriceRangeProperty {
    private final StringProperty ddl_id, start_date, end_date, radius, minimum_amount;
    public DeliveryPriceRangeProperty(){
        ddl_id = new SimpleStringProperty(this, "delivery price range id");
        start_date = new SimpleStringProperty(this, "start date");
        end_date= new SimpleStringProperty(this, "end date");
        radius = new SimpleStringProperty(this, "radius");
        minimum_amount = new SimpleStringProperty(this, "minimum amount");
    }

    public String getDdl_id() {
        return ddl_id.get();
    }

    public StringProperty ddl_idProperty() {
        return ddl_id;
    }

    public void setDdl_id(String ddl_id) {
        this.ddl_id.set(ddl_id);
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

    public String getEnd_date() {
        return end_date.get();
    }

    public StringProperty end_dateProperty() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date.set(end_date);
    }

    public String getRadius() {
        return radius.get();
    }

    public StringProperty radiusProperty() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius.set(radius);
    }

    public String getMinimum_amount() {
        return minimum_amount.get();
    }

    public StringProperty minimum_amountProperty() {
        return minimum_amount;
    }

    public void setMinimum_amount(String minimum_amount) {
        this.minimum_amount.set(minimum_amount);
    }
}
