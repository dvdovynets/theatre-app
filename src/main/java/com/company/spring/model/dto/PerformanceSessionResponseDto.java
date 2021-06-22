package com.company.spring.model.dto;

import java.time.LocalDateTime;

public class PerformanceSessionResponseDto {
    private Long id;
    private Long performanceId;
    private Long theatreStageId;
    private LocalDateTime showTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(Long performanceId) {
        this.performanceId = performanceId;
    }

    public Long getTheatreStageId() {
        return theatreStageId;
    }

    public void setTheatreStageId(Long theatreStageId) {
        this.theatreStageId = theatreStageId;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }
}
