package com.serenity.hospital.ormcoursework.dao;

public interface CrudDAO<T> {
    boolean save(T entity);
    boolean update(T entity);
    boolean delete(String id) throws Exception;
    String getNextId();
}
