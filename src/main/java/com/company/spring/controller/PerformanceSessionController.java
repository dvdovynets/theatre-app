package com.company.spring.controller;

import com.company.spring.model.PerformanceSession;
import com.company.spring.model.dto.PerformanceSessionRequestDto;
import com.company.spring.model.dto.PerformanceSessionResponseDto;
import com.company.spring.service.PerformanceSessionService;
import com.company.spring.service.mapper.PerformanceSessionMapper;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/performance-sessions")
public class PerformanceSessionController {
    private PerformanceSessionService performanceSessionService;
    private PerformanceSessionMapper performanceSessionMapper;

    public PerformanceSessionController(PerformanceSessionService performanceSessionService,
                                        PerformanceSessionMapper performanceSessionMapper) {
        this.performanceSessionService = performanceSessionService;
        this.performanceSessionMapper = performanceSessionMapper;
    }

    @GetMapping("/available")
    public List<PerformanceSessionResponseDto> getAvailablePerformanceSessions(
            @RequestParam Long performanceId,
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return performanceSessionService.findAvailableSessions(performanceId, date)
                .stream()
                .map(performanceSessionMapper::parseToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public PerformanceSessionResponseDto add(
            @RequestBody PerformanceSessionRequestDto requestDto) {
        PerformanceSession performanceSessionFromDb = performanceSessionService
                .add(performanceSessionMapper.parseToModel(requestDto));
        return performanceSessionMapper.parseToDto(performanceSessionFromDb);
    }

    @PutMapping("/{id}")
    public PerformanceSessionResponseDto update(@PathVariable Long id,
                                                PerformanceSessionRequestDto requestDto) {
        PerformanceSession performanceSession = performanceSessionMapper.parseToModel(requestDto);
        performanceSession.setId(id);
        return performanceSessionMapper
                .parseToDto(performanceSessionService.update(performanceSession));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        performanceSessionService.delete(id);
    }
}
