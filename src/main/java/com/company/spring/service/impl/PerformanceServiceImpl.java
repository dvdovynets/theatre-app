package com.company.spring.service.impl;

import com.company.spring.dao.PerformanceDao;
import com.company.spring.model.Performance;
import com.company.spring.service.PerformanceService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PerformanceServiceImpl implements PerformanceService {
    private final PerformanceDao performanceDao;

    public PerformanceServiceImpl(PerformanceDao performanceDao) {
        this.performanceDao = performanceDao;
    }

    @Override
    public Performance add(Performance performance) {
        return performanceDao.add(performance);
    }

    @Override
    public Performance get(Long id) {
        return performanceDao.get(id).get();
    }

    @Override
    public List<Performance> getAll() {
        return performanceDao.getAll();
    }
}
