module com.example.basis_data_laundry {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.basis_data_laundry to javafx.fxml;
    exports com.example.basis_data_laundry;
}