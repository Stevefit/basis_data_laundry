package com.example.basis_data_laundry_property;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class NotaProperty {
    private final StringProperty nota_id, status;
    public NotaProperty(){
        nota_id = new SimpleStringProperty(this, "nota id");
        status = new SimpleStringProperty(this, "status");
    }

    public String getNota_id() {
        return nota_id.get();
    }

    public StringProperty nota_idProperty() {
        return nota_id;
    }

    public void setNota_id(String nota_id) {
        this.nota_id.set(nota_id);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
}
