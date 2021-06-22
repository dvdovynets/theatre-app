package com.company.spring.service.mapper;

import com.company.spring.model.Performance;
import com.company.spring.model.dto.PerformanceRequestDto;
import com.company.spring.model.dto.PerformanceResponseDto;
import org.springframework.stereotype.Component;

@Component
public class PerformanceDtoMapper {
    public PerformanceResponseDto parseToDto(Performance performance) {
        PerformanceResponseDto responseDto = new PerformanceResponseDto();
        responseDto.setId(performance.getId());
        responseDto.setTitle(performance.getTitle());
        responseDto.setDescription(performance.getDescription());
        return responseDto;
    }

    public Performance parseToModel(PerformanceRequestDto requestDto) {
        Performance performance = new Performance();
        performance.setTitle(requestDto.getTitle());
        performance.setDescription(requestDto.getDescription());
        return performance;
    }
}
