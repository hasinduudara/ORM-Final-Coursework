package com.serenity.hospital.ormcoursework.bo;

import com.serenity.hospital.ormcoursework.entity.Admin;

public interface AdminBo {
    boolean registerAdmin(String name, String email, String userName, String password);
    Admin getAdminByUsername(String userName); // Added method
}
