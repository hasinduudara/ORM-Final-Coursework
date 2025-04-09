package com.serenity.hospital.ormcoursework.dao.impl;

import com.serenity.hospital.ormcoursework.config.FactoryConfiguration;
import com.serenity.hospital.ormcoursework.dao.TherapyProgramDAO;
import com.serenity.hospital.ormcoursework.entity.TherapyProgram;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TherapyProgramDAOImpl implements TherapyProgramDAO {
    private final FactoryConfiguration factoryConfiguration = new FactoryConfiguration();

    @Override
    public TherapyProgram getById(String therapyProgramId) {
        try {
            Session session = factoryConfiguration.getSession();
            TherapyProgram therapyProgram = session.get(TherapyProgram.class, therapyProgramId);
            return therapyProgram;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public TherapyProgram getByName(String therapyProgramName) {
        return null;
    }

    @Override
    public void updateTherapyProgram(TherapyProgram therapyProgram) {

    }

    @Override
    public void deleteTherapyProgram(String therapyProgramId) {

    }

    @Override
    public boolean save(TherapyProgram entity) {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            TherapyProgram existing = session.get(TherapyProgram.class, entity.getProgramID());
            if (existing != null) {
                throw new Exception("Therapy Program ID already exists");
            }
            session.persist(entity);
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
    public boolean update(TherapyProgram entity) {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.merge(entity);
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
            TherapyProgram therapyProgram = session.get(TherapyProgram.class, id);
            if (therapyProgram != null) {
                session.remove(therapyProgram);
                transaction.commit();
                return true;
            } else {
                throw new Exception("Therapy Program not found");
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
        try {
            // Get the last therapy program ID from the database
            String lastId = session.createQuery("SELECT p.id FROM TherapyProgram p ORDER BY p.id DESC", String.class)
                    .setMaxResults(1)
                    .uniqueResult();

            if (lastId != null) {
                int newId = Integer.parseInt(lastId.split("-")[1]) + 1;
                return String.format("TP00-%03d", newId);
            } else {
                return "TP00-001"; // Default ID if no records exist
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<TherapyProgram> getAll() {
        Session session = factoryConfiguration.getSession();
        try {
            return session.createQuery("FROM TherapyProgram", TherapyProgram.class).list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
