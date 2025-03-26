package com.serenity.hospital.ormcoursework.dao.impl;

import com.serenity.hospital.ormcoursework.config.FactoryConfiguration;
import com.serenity.hospital.ormcoursework.dao.AdminDAO;
import com.serenity.hospital.ormcoursework.entity.Admin;
import com.serenity.hospital.ormcoursework.util.PasswordEncryptionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdminDAOImpl implements AdminDAO {
    private final FactoryConfiguration factoryConfiguration = new FactoryConfiguration();

    // Save Admin
    @Override
    public boolean save(Admin admin) {
        Transaction transaction = null;
        try (Session session = factoryConfiguration.getSession()) {
            transaction = session.beginTransaction();
            session.save(admin);
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

    // Update Admin
    @Override
    public boolean update(Admin admin) {
        Transaction transaction = null;
        try (Session session = factoryConfiguration.getSession()) {
            transaction = session.beginTransaction();
            session.update(admin);
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

    // Delete Admin
    @Override
    public boolean delete(Admin admin) {
        Transaction transaction = null;
        try (Session session = factoryConfiguration.getSession()) {
            transaction = session.beginTransaction();
            session.delete(admin);
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

    // Get Next Admin ID
    @Override
    public String getNextId() {
        try (Session session = factoryConfiguration.getSession()) {
            String lastId = session.createQuery("SELECT a.id FROM Admin a ORDER BY a.id DESC", String.class)
                    .setMaxResults(1)
                    .uniqueResult();
            if (lastId != null) {
                int numericPart = Integer.parseInt(lastId.split("-")[1]) + 1;
                return String.format("A00-%03d", numericPart);
            } else {
                return "A00-001";
            }
        }
    }

//    @Override
//    public Admin getAdminByUsername(String username) {
//        try (Session session = factoryConfiguration.getSession()) {
//            return session.createQuery("FROM Admin WHERE userName = :username", Admin.class)
//                    .setParameter("username", username)
//                    .uniqueResult();
//        }
//    }

    @Override
    public boolean registerAdmin(String name, String email, String userName, String password) {
        if (getAdminByUsername(userName) != null) {
            return false;
        }

        String hashedPassword = PasswordEncryptionUtil.hashPassword(password);
        String newAdminId = getNextId();
        Admin admin = new Admin(newAdminId, name, email, userName, hashedPassword);
        save(admin);
        return true;
    }

    @Override
    public Admin getAdminByUsername(String username) {
        try (Session session = factoryConfiguration.getSession()) {
            return session.createQuery("FROM Admin WHERE userName = :username", Admin.class)
                    .setParameter("username", username)
                    .uniqueResult();
        }
    }
}
