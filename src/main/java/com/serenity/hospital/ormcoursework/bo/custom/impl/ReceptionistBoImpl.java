package com.serenity.hospital.ormcoursework.bo.custom.impl;

import com.serenity.hospital.ormcoursework.bo.custom.ReceptionistBo;
import com.serenity.hospital.ormcoursework.dao.AdminDAO;
import com.serenity.hospital.ormcoursework.dao.ReceptionistDAO;
import com.serenity.hospital.ormcoursework.dao.impl.ReceptionistDAOImpl;
import com.serenity.hospital.ormcoursework.entity.Receptionist;
import com.serenity.hospital.ormcoursework.util.PasswordEncryptionUtil;

public class ReceptionistBoImpl implements ReceptionistBo {
    private final ReceptionistDAO receptionistDAO = new ReceptionistDAOImpl();

    @Override
    public boolean registerReceptionist(String name, String email, String userName, String password) {
        if (receptionistDAO.registerReceptionist(name, email, userName, password)) {
            return false;
        }

        String hashedPassword = PasswordEncryptionUtil.hashPassword(password);
        String newReceptionistId = receptionistDAO.getNextId();
        Receptionist receptionist = new Receptionist(newReceptionistId, name, email, userName, hashedPassword);
        receptionistDAO.save(receptionist);
        return true;
    }
}
