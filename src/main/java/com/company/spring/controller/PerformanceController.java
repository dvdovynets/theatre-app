package com.company.spring.controller;

import com.company.spring.model.Performance;
import com.company.spring.model.dto.PerformanceRequestDto;
import com.company.spring.model.dto.PerformanceResponseDto;
import com.company.spring.service.PerformanceService;
import com.company.spring.service.mapper.PerformanceDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/performances")
public class PerformanceController {
    private final PerformanceService performanceService;
    private final PerformanceDtoMapper performanceDtoMapper;

    public PerformanceController(PerformanceService performanceService,
                                 PerformanceDtoMapper performanceDtoMapper) {
        this.performanceService = performanceService;
        this.performanceDtoMapper = performanceDtoMapper;
    }

    @GetMapping
    public List<PerformanceResponseDto> getAll() {
        return performanceService.getAll()
                .stream()
                .map(performanceDtoMapper::parseToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public PerformanceResponseDto add(@RequestBody PerformanceRequestDto requestDto) {
        Performance performanceFromDb = performanceService
                .add(performanceDtoMapper.parseToModel(requestDto));
        return performanceDtoMapper.parseToDto(performanceFromDb);
    }
}
