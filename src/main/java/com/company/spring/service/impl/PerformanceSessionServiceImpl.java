package com.company.spring.service.impl;

import com.company.spring.dao.PerformanceSessionDao;
import com.company.spring.model.PerformanceSession;
import com.company.spring.service.PerformanceSessionService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PerformanceSessionServiceImpl implements PerformanceSessionService {
    private final PerformanceSessionDao sessionDao;

    public PerformanceSessionServiceImpl(PerformanceSessionDao sessionDao) {
        this.sessionDao = sessionDao;
    }

    @Override
    public List<PerformanceSession> findAvailableSessions(Long performanceId, LocalDate date) {
        return sessionDao.findAvailableSessions(performanceId, date);
    }

    @Override
    public PerformanceSession get(Long id) {
        return sessionDao.get(id).get();
    }

    @Override
    public PerformanceSession add(PerformanceSession session) {
        return sessionDao.add(session);
    }

    @Override
    public PerformanceSession update(PerformanceSession performanceSession) {
        return sessionDao.update(performanceSession);
    }

    @Override
    public void delete(Long id) {
        sessionDao.delete(id);
    }
}
