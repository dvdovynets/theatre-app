package com.company.spring.dao;

import com.company.spring.model.PerformanceSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PerformanceSessionDao extends GenericDao<PerformanceSession> {
    List<PerformanceSession> findAvailableSessions(Long movieId, LocalDate date);

    Optional<PerformanceSession> get(Long id);

    PerformanceSession update(PerformanceSession performanceSession);

    void delete(Long id);
}
