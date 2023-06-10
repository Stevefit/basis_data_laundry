package com.example.basis_data_laundry_property;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ItemProperty {
    private final StringProperty item_id, item_name, duration, price;

    public ItemProperty(){
        item_id = new SimpleStringProperty(this, "item id");
        item_name = new SimpleStringProperty(this, "item name");
        duration = new SimpleStringProperty(this, "duration");
        price= new SimpleStringProperty(this, "price");
    }
    public String getItem_id() {
        return item_id.get();
    }

    public StringProperty item_idProperty() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id.set(item_id);
    }

    public String getItem_name() {
        return item_name.get();
    }

    public StringProperty item_nameProperty() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name.set(item_name);
    }

    public String getDuration() {
        return duration.get();
    }

    public StringProperty durationProperty() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration.set(duration);
    }

    public String getPrice() {
        return price.get();
    }

    public StringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }
}
