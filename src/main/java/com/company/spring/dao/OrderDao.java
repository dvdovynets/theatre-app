package com.company.spring.dao;

import com.company.spring.model.Order;
import com.company.spring.model.User;
import java.util.List;

public interface OrderDao extends GenericDao<Order> {
    List<Order> getOrdersHistory(User user);
}
