package com.serenity.hospital.ormcoursework.dao;

import com.serenity.hospital.ormcoursework.entity.Receptionist;

public interface ReceptionistDAO extends CrudDAO<Receptionist> {
    // Delete Receptionist
    boolean delete(Receptionist receptionist);

    Receptionist getReceptionistByUsername(String username);

    boolean registerReceptionist(String name, String email, String userName, String password);
}
