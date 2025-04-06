package com.serenity.hospital.ormcoursework.dao.impl;

import com.serenity.hospital.ormcoursework.config.FactoryConfiguration;
import com.serenity.hospital.ormcoursework.dao.TherapistDAO;
import com.serenity.hospital.ormcoursework.entity.Therapist;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TherapistDAOImpl implements TherapistDAO {
    private final FactoryConfiguration factoryConfiguration = new FactoryConfiguration();

    @Override
    public Therapist getById(String therapistId) {
        try {
            Session session = factoryConfiguration.getSession();
            Therapist therapist = session.get(Therapist.class, therapistId);
            return therapist;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean save(Therapist entity) {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Therapist existing = session.get(Therapist.class, entity.getTherapistID());
            if (existing != null) {
                throw new Exception("Therapist ID already exists");
            }
            session.persist(therapist);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean update(Therapist entity) {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.merge(therapist);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
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
            Therapist therapist = session.get(Therapist.class, id);
            if (therapist != null) {
                session.remove(therapist);
                transaction.commit();
                return true;
            } else {
                throw new Exception("Therapist not found");
            }
        } catch (Exception e) {
            transaction.rollback();
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
        // Get the last therapist ID from the database
        String lastId = (String) session.createQuery("SELECT t.id FROM Therapist t ORDER BY t.id DESC", String.class)
                .setMaxResults(1)
                .uniqueResult();;

        if (lastId != null) {
            int newId = Integer.parseInt(lastId.split("-")[1]) + 1;
            return String.format("T00-%03d", newId);
        } else {
            return "T00-001"; // Default ID if no records exist
        }
    }

    @Override
    public List<Therapist> getAll() {
        Session session = factoryConfiguration.getSession();
        List<Therapist> therapists = session.createQuery("FROM Therapist", Therapist.class).list();
        return therapists;
    }
}
