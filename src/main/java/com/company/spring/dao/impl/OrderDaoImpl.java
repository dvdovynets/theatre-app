package com.company.spring.dao.impl;

import com.company.spring.dao.AbstractDao;
import com.company.spring.dao.OrderDao;
import com.company.spring.exception.DataProcessingException;
import com.company.spring.model.Order;
import com.company.spring.model.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {
    public OrderDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        try (Session session = sessionFactory.openSession()) {
            Query<Order> query = session.createQuery("FROM Order o "
                    + "left join fetch o.tickets "
                    + "left join fetch o.user "
                    + "WHERE o.user = :user", Order.class);
            query.setParameter("user", user);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Cannot find orders of user by user: " + "user", e);
        }
    }
}
