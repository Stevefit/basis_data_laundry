package com.example.basis_data_laundry_property;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CategoryProperty {
    private final StringProperty category_id, category_name;
    public CategoryProperty(){
        category_id = new SimpleStringProperty(this, "category id");
        category_name = new SimpleStringProperty(this, "category name");
    }

    public String getCategory_id() {
        return category_id.get();
    }

    public StringProperty category_idProperty() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id.set(category_id);
    }

    public String getCategory_name() {
        return category_name.get();
    }

    public StringProperty category_nameProperty() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name.set(category_name);
    }
}
