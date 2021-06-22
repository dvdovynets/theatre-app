package com.company.spring.dao;

import com.company.spring.model.ShoppingCart;
import com.company.spring.model.User;

public interface ShoppingCartDao extends GenericDao<ShoppingCart> {
    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
