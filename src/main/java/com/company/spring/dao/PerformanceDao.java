package com.company.spring.dao;

import com.company.spring.model.Performance;
import java.util.List;
import java.util.Optional;

public interface PerformanceDao extends GenericDao<Performance> {
    Optional<Performance> get(Long id);

    List<Performance> getAll();
}
