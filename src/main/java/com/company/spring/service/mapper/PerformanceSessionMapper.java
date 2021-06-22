package com.company.spring.service.mapper;

import com.company.spring.model.PerformanceSession;
import com.company.spring.model.dto.PerformanceSessionRequestDto;
import com.company.spring.model.dto.PerformanceSessionResponseDto;
import com.company.spring.service.PerformanceService;
import com.company.spring.service.TheatreStageService;
import org.springframework.stereotype.Component;

@Component
public class PerformanceSessionMapper {
    private TheatreStageService theatreStageService;
    private PerformanceService performanceService;

    public PerformanceSessionMapper(TheatreStageService theatreStageService,
                                    PerformanceService performanceService) {
        this.theatreStageService = theatreStageService;
        this.performanceService = performanceService;
    }

    public PerformanceSessionResponseDto parseToDto(PerformanceSession performanceSession) {
        PerformanceSessionResponseDto responseDto = new PerformanceSessionResponseDto();
        responseDto.setId(performanceSession.getId());
        responseDto.setPerformanceId(performanceSession.getPerformance().getId());
        responseDto.setTheatreStageId(performanceSession.getTheatreStage().getId());
        responseDto.setShowTime(performanceSession.getShowTime());
        return responseDto;
    }

    public PerformanceSession parseToModel(PerformanceSessionRequestDto requestDto) {
        PerformanceSession performanceSession = new PerformanceSession();
        performanceSession.setPerformance(performanceService.get(requestDto.getPerformanceId()));
        performanceSession
                .setTheatreStage(theatreStageService.get(requestDto.getTheatreStageId()));
        performanceSession.setShowTime(requestDto.getShowTime());
        return performanceSession;
    }
}
