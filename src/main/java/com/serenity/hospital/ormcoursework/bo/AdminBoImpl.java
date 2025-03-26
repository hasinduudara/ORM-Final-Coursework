package com.serenity.hospital.ormcoursework.bo;

import com.serenity.hospital.ormcoursework.dao.AdminDAO;
import com.serenity.hospital.ormcoursework.dao.impl.AdminDAOImpl;
import com.serenity.hospital.ormcoursework.entity.Admin;
import com.serenity.hospital.ormcoursework.util.PasswordEncryptionUtil;

public class AdminBoImpl implements AdminBo {
    private final AdminDAO adminDAO = new AdminDAOImpl();

    @Override
    public boolean registerAdmin(String name, String email, String userName, String password) {
        if (adminDAO.getAdminByUsername(userName) != null) {
            return false;
        }

        String hashedPassword = PasswordEncryptionUtil.hashPassword(password);
        String newAdminId = adminDAO.getNextId();
        Admin admin = new Admin(newAdminId, name, email, userName, hashedPassword);
        adminDAO.save(admin);
        return true;
    }

    @Override
    public Admin getAdminByUsername(String userName) {
        return null;
    }
}
