package com.company.spring.service;

import com.company.spring.model.PerformanceSession;
import java.time.LocalDate;
import java.util.List;

public interface PerformanceSessionService {
    List<PerformanceSession> findAvailableSessions(Long movieId, LocalDate date);

    PerformanceSession get(Long id);

    PerformanceSession add(PerformanceSession session);

    PerformanceSession update(PerformanceSession performanceSession);

    void delete(Long id);
}
