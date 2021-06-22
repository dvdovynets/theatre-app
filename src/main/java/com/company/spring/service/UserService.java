package com.company.spring.service;

import com.company.spring.model.User;
import java.util.Optional;

public interface UserService {
    User add(User user);

    Optional<User> findByEmail(String email);
}
