module com.serenity.hospital.ormcoursework {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires com.jfoenix;
    requires net.sf.jasperreports.core;
    requires java.mail;

    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;

    opens com.serenity.hospital.ormcoursework.config to jakarta.persistence;
    opens com.serenity.hospital.ormcoursework.entity to org.hibernate.orm.core;
    opens com.serenity.hospital.ormcoursework.dto.tm to javafx.base;


    opens com.serenity.hospital.ormcoursework to javafx.fxml;
    exports com.serenity.hospital.ormcoursework;
}