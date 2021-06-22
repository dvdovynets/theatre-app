package com.company.spring.model.dto;

import java.time.LocalDateTime;

public class PerformanceSessionRequestDto {
    private Long performanceId;
    private Long theatreStageId;
    private LocalDateTime showTime;

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
