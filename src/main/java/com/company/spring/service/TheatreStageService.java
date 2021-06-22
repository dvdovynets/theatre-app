package com.company.spring.service;

import com.company.spring.model.TheatreStage;
import java.util.List;

public interface TheatreStageService {
    TheatreStage add(TheatreStage theatreStage);

    TheatreStage get(Long id);

    List<TheatreStage> getAll();
}
