module com.serenity.hospital.ormcoursework {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;

    opens com.serenity.hospital.ormcoursework.controller to javafx.fxml;
    exports com.serenity.hospital.ormcoursework;
}