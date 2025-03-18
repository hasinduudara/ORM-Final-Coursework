module com.serenity.hospital.ormcoursework {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.serenity.hospital.ormcoursework to javafx.fxml;
    exports com.serenity.hospital.ormcoursework;
}