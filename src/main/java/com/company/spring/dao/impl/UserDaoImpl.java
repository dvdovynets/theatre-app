package com.company.spring.dao.impl;

import com.company.spring.dao.AbstractDao;
import com.company.spring.dao.UserDao;
import com.company.spring.model.User;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("FROM User u "
                    + "WHERE u.email = :email", User.class);
            query.setParameter("email", email);
            return query.uniqueResultOptional();
        }
    }
}
