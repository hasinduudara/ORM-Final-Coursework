package com.serenity.hospital.ormcoursework.bo;

import com.serenity.hospital.ormcoursework.entity.Admin;
import com.serenity.hospital.ormcoursework.util.PasswordEncryptionUtil;

public class AuthService {
    private final AdminBo adminBo = new AdminBoImpl();

    public boolean registerAdmin(String name, String email, String userName, String password) {
        Admin admin = adminBo.getAdminByUsername(userName);
        if (admin != null && PasswordEncryptionUtil.checkPassword(password, admin.getPassword())) {
            return false;
        }
        return true;
    }
}
