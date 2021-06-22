package com.company.spring.service;

import com.company.spring.model.Performance;
import java.util.List;

public interface PerformanceService {
    Performance add(Performance performance);

    Performance get(Long id);

    List<Performance> getAll();
}
