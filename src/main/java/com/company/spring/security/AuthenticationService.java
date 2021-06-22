package com.company.spring.security;

import com.company.spring.exception.AuthenticationException;
import com.company.spring.model.User;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;

    User register(String email, String password);
}
