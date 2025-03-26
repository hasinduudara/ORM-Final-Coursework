package com.serenity.hospital.ormcoursework.bo;

import com.serenity.hospital.ormcoursework.bo.custom.AdminBo;
import com.serenity.hospital.ormcoursework.bo.custom.impl.AdminBoImpl;
import com.serenity.hospital.ormcoursework.dao.AdminDAO;
import com.serenity.hospital.ormcoursework.dao.impl.AdminDAOImpl;
import com.serenity.hospital.ormcoursework.entity.Admin;
import com.serenity.hospital.ormcoursework.util.PasswordEncryptionUtil;

public class AuthService {
    private final AdminDAO adminDAO = new AdminDAOImpl();

    public boolean registerAdmin(String name, String email, String userName, String password) {
        Admin admin = adminDAO.getAdminByUsername(userName);
        if (admin != null && PasswordEncryptionUtil.checkPassword(password, admin.getPassword())) {
            return false;
        }
        return true;
    }

    public boolean authenticateAdmin(String username, String password) {
        Admin admin = adminDAO.getAdminByUsername(username);
        System.out.println(password);
        System.out.println(admin.getPassword());
        if (admin.getUserName().equals(username) && PasswordEncryptionUtil.checkPassword(password, admin.getPassword())) {
            return true;
        }
        return false;
    }
}
