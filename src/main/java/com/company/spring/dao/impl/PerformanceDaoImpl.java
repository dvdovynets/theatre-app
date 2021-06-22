package com.company.spring.dao.impl;

import com.company.spring.dao.AbstractDao;
import com.company.spring.dao.PerformanceDao;
import com.company.spring.exception.DataProcessingException;
import com.company.spring.model.Performance;
import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PerformanceDaoImpl extends AbstractDao<Performance> implements PerformanceDao {
    public PerformanceDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Optional<Performance> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Performance.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get a performance by id: " + id, e);
        }
    }

    @Override
    public List<Performance> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaQuery<Performance> criteriaQuery = session.getCriteriaBuilder()
                    .createQuery(Performance.class);
            criteriaQuery.from(Performance.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all performances", e);
        }
    }
}
