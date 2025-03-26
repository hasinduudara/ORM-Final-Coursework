package com.serenity.hospital.ormcoursework.dao;

import com.serenity.hospital.ormcoursework.entity.Admin;

public interface AdminDAO extends CrudDAO <Admin>{
    // Delete Admin
    boolean delete(Admin admin);

    Admin getAdminByUsername(String username);

    boolean registerAdmin(String name, String email, String userName, String password);
}
