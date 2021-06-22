package com.company.spring.dao.impl;

import com.company.spring.dao.AbstractDao;
import com.company.spring.dao.PerformanceSessionDao;
import com.company.spring.exception.DataProcessingException;
import com.company.spring.model.PerformanceSession;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class PerformanceSessionDaoImpl extends AbstractDao<PerformanceSession>
        implements PerformanceSessionDao {
    private static final LocalTime END_OF_DAY = LocalTime.of(23, 59, 59);

    public PerformanceSessionDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<PerformanceSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<PerformanceSession> criteriaQuery =
                    criteriaBuilder.createQuery(PerformanceSession.class);
            Root<PerformanceSession> root = criteriaQuery.from(PerformanceSession.class);
            Predicate moviePredicate = criteriaBuilder.equal(root.get("performance"), movieId);
            Predicate datePredicate = criteriaBuilder.between(root.get("showTime"),
                    date.atStartOfDay(), date.atTime(END_OF_DAY));
            Predicate allConditions = criteriaBuilder.and(moviePredicate, datePredicate);
            criteriaQuery.select(root).where(allConditions);
            root.fetch("performance");
            root.fetch("theatreStage");
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get available sessions for "
                    + "performance with id: " + movieId + " for date: " + date, e);
        }
    }

    @Override
    public Optional<PerformanceSession> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(PerformanceSession.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get a performance session by id: " + id, e);
        }
    }

    @Override
    public PerformanceSession update(PerformanceSession performanceSession) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(performanceSession);
            transaction.commit();
            return performanceSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't update performanceSession="
                    + performanceSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(get(id).get());
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't delete movieSession by id=" + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
