package com.serenity.hospital.ormcoursework.dao.impl;

import com.serenity.hospital.ormcoursework.config.FactoryConfiguration;
import com.serenity.hospital.ormcoursework.dao.ReceptionistDAO;
import com.serenity.hospital.ormcoursework.entity.Receptionist;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;

import static com.serenity.hospital.ormcoursework.config.FactoryConfiguration.factoryConfiguration;

public class ReceptionistDAOImpl implements ReceptionistDAO {
    FactoryConfiguration factoryConfiguration = FactoryConfiguration.getInstance();

    @Override
    public boolean delete(Receptionist receptionist) {
        return false;
    }


    @Override
    public boolean save(Receptionist receptionist) {
        Transaction transaction = null;
        try (Session session = factoryConfiguration.getSession()) {
            transaction = session.beginTransaction();
            session.save(receptionist);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Receptionist receptionist) {
        Transaction transaction = null;
        try (Session session = factoryConfiguration.getSession()) {
            transaction = session.beginTransaction();
            session.update(receptionist);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

//    @Override
//    public boolean delete(Receptionist receptionist) {
//        Transaction transaction = null;
//        try (Session session = factoryConfiguration.getSession()) {
//            transaction = session.beginTransaction();
//            session.delete(receptionist);
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//            return false;
//        }
//    }

    @Override
    public String getNextId() {
        try (Session session = factoryConfiguration.getSession()) {
            String lastId = session.createQuery("SELECT r.id FROM Receptionist r ORDER BY r.id DESC", String.class)
                    .setMaxResults(1)
                    .uniqueResult();
            if (lastId != null) {
                int id = Integer.parseInt(lastId.split("-")[1]) + 1;
                return String.format("R00-%03d", id);
            } else {
                return "R00-001";
            }
        }
    }

    @Override
    public boolean registerReceptionist(String name, String email, String userName, String password) {
        if (getReceptionistByUsername(userName) != null) {
            return false;
        }

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        String newReceptionistId = getNextId();
        Receptionist newReceptionist = new Receptionist(newReceptionistId, name, email, userName, hashedPassword);
        save(newReceptionist);
        return true;
    }

    @Override
    public Receptionist getReceptionistByUsername(String username) {
        try (Session session = factoryConfiguration.getSession()) {
            return session.createQuery("FROM Receptionist WHERE userName = :username", Receptionist.class)
                    .setParameter("username", username)
                    .uniqueResult();
        }
    }
}
