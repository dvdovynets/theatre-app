package com.company.spring.service.impl;

import com.company.spring.dao.TheatreStageDao;
import com.company.spring.model.TheatreStage;
import com.company.spring.service.TheatreStageService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TheatreStageServiceImpl implements TheatreStageService {
    private final TheatreStageDao theatreStageDao;

    public TheatreStageServiceImpl(TheatreStageDao theatreStageDao) {
        this.theatreStageDao = theatreStageDao;
    }

    @Override
    public TheatreStage add(TheatreStage theatreStage) {
        return theatreStageDao.add(theatreStage);
    }

    @Override
    public TheatreStage get(Long id) {
        return theatreStageDao.get(id).get();
    }

    @Override
    public List<TheatreStage> getAll() {
        return theatreStageDao.getAll();
    }
}
