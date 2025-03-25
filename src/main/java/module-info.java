module com.serenity.hospital.ormcoursework {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires lombok;
//    requires com.jfoenix;
    requires net.sf.jasperreports.core;

    requires org.hibernate.orm.core;
    requires java.naming;
    requires jakarta.persistence;

    opens com.serenity.hospital.ormcoursework.config to jakarta.persistence;
    opens com.serenity.hospital.ormcoursework.entity to org.hibernate.orm.core;
    opens com.serenity.hospital.ormcoursework.controller to javafx.fxml;
    opens com.serenity.hospital.ormcoursework.dto to javafx.base;

    exports com.serenity.hospital.ormcoursework;
}