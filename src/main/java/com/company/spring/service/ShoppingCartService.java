package com.company.spring.service;

import com.company.spring.model.PerformanceSession;
import com.company.spring.model.ShoppingCart;
import com.company.spring.model.User;

public interface ShoppingCartService {
    void addSession(PerformanceSession performanceSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clearShoppingCart(ShoppingCart cart);
}
