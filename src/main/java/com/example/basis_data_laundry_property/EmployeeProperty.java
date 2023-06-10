package com.example.basis_data_laundry_property;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmployeeProperty {
    private final StringProperty  employee_id, employee_name, job_title;

    public EmployeeProperty(){
        employee_id = new SimpleStringProperty(this, "employee id");
        employee_name = new SimpleStringProperty(this, "employee name");
        job_title = new SimpleStringProperty(this, "job title");
    }

    public String getEmployee_id() {
        return employee_id.get();
    }

    public StringProperty employee_idProperty() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id.set(employee_id);
    }

    public String getEmployee_name() {
        return employee_name.get();
    }

    public StringProperty employee_nameProperty() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name.set(employee_name);
    }

    public String getJob_title() {
        return job_title.get();
    }

    public StringProperty job_titleProperty() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title.set(job_title);
    }
}
