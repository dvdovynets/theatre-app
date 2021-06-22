package com.company.spring.dao;

import com.company.spring.model.TheatreStage;
import java.util.List;
import java.util.Optional;

public interface TheatreStageDao extends GenericDao<TheatreStage> {
    Optional<TheatreStage> get(Long id);

    List<TheatreStage> getAll();
}
