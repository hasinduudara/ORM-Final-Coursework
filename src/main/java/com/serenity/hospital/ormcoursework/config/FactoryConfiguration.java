package com.serenity.hospital.ormcoursework.config;

import com.serenity.hospital.ormcoursework.entity.Admin;
import com.serenity.hospital.ormcoursework.entity.Receptionist;
import com.serenity.hospital.ormcoursework.entity.Therapist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.IOException;
import java.util.Properties;

public class FactoryConfiguration {
    public static FactoryConfiguration factoryConfiguration;
    private static SessionFactory sessionFactory;
    public FactoryConfiguration(){
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        configuration.setProperties(properties);

        configuration.addAnnotatedClass(Admin.class);
        configuration.addAnnotatedClass(Receptionist.class);
        configuration.addAnnotatedClass(Therapist.class);

        sessionFactory = configuration.buildSessionFactory();
    }
    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null) ? new FactoryConfiguration() : factoryConfiguration;
    }
    public Session getSession() {
        return sessionFactory.openSession();
    }
}
