package com.serenity.hospital.ormcoursework.dao.impl;

import com.serenity.hospital.ormcoursework.config.FactoryConfiguration;
import com.serenity.hospital.ormcoursework.dao.PatientDAO;
import com.serenity.hospital.ormcoursework.entity.Patient;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PatientDAOImpl implements PatientDAO {
    private final FactoryConfiguration factoryConfiguration = new FactoryConfiguration();

    @Override
    public Patient getById(String patientId) {
        try {
            Session session = factoryConfiguration.getSession();
            Patient patient = session.get(Patient.class, patientId);
            return patient;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Patient> getAll() {
        Session session = factoryConfiguration.getSession();
        List<Patient> patients = session.createQuery("FROM Patient", Patient.class).list();
        return patients;
    }

    @Override
    public boolean save(Patient entity) {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Patient existing = session.get(Patient.class, entity.getPatientID());
            if (existing != null) {
                throw new Exception("Patient ID already exists");
            }
            session.persist(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean update(Patient entity) {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.merge(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Patient patient = session.get(Patient.class, id);
            if (patient != null) {
                session.delete(patient);
                transaction.commit();
                return true;
            } else {
                throw new Exception("Patient not found");
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public String getNextId() {
        Session session = factoryConfiguration.getSession();
        String lastId = session.createQuery("SELECT p.id FROM Patient p order by p.id desc", String.class)
                .setMaxResults(1)
                .uniqueResult();
        if (lastId != null) {
            int newId = Integer.parseInt(lastId.split("-")[1]) + 1;
            return String.format("P00-%03d", newId);
        } else {
            return "P00-001"; // Default ID if no records exist
        }
    }
}
