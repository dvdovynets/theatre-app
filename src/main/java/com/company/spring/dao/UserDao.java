package com.company.spring.dao;

import com.company.spring.model.User;
import java.util.Optional;

public interface UserDao extends GenericDao<User> {
    Optional<User> findByEmail(String email);
}
