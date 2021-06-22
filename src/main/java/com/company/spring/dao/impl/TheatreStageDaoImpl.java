package com.company.spring.dao.impl;

import com.company.spring.dao.AbstractDao;
import com.company.spring.dao.TheatreStageDao;
import com.company.spring.exception.DataProcessingException;
import com.company.spring.model.TheatreStage;
import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TheatreStageDaoImpl extends AbstractDao<TheatreStage> implements TheatreStageDao {
    public TheatreStageDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Optional<TheatreStage> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(TheatreStage.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get a theatre stage by id: " + id, e);
        }
    }

    @Override
    public List<TheatreStage> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaQuery<TheatreStage> criteriaQuery = session.getCriteriaBuilder()
                    .createQuery(TheatreStage.class);
            criteriaQuery.from(TheatreStage.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all theatre stages", e);
        }
    }
}
