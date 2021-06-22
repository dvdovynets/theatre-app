package com.company.spring.service;

import com.company.spring.model.Order;
import com.company.spring.model.ShoppingCart;
import com.company.spring.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
