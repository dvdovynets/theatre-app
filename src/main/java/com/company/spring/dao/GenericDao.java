package com.company.spring.dao;

public interface GenericDao<T> {
    T add(T entity);
}
