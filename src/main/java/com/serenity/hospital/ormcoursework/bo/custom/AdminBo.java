package com.serenity.hospital.ormcoursework.bo.custom;

import com.serenity.hospital.ormcoursework.entity.Admin;

public interface AdminBo {
    boolean registerAdmin(String name, String email, String userName, String password);

}
