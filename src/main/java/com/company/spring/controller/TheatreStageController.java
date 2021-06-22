package com.company.spring.controller;

import com.company.spring.model.TheatreStage;
import com.company.spring.model.dto.TheatreStageRequestDto;
import com.company.spring.model.dto.TheatreStageResponseDto;
import com.company.spring.service.TheatreStageService;
import com.company.spring.service.mapper.TheatreStageDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatre-stages")
public class TheatreStageController {
    private final TheatreStageService theatreStageService;
    private final TheatreStageDtoMapper theatreStageDtoMapper;

    public TheatreStageController(TheatreStageService theatreStageService,
                                  TheatreStageDtoMapper theatreStageDtoMapper) {
        this.theatreStageService = theatreStageService;
        this.theatreStageDtoMapper = theatreStageDtoMapper;
    }

    @GetMapping
    public List<TheatreStageResponseDto> getAll() {
        return theatreStageService.getAll()
                .stream()
                .map(theatreStageDtoMapper::parseToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public TheatreStageResponseDto add(@RequestBody TheatreStageRequestDto requestDto) {
        TheatreStage theatreStageFromDb = theatreStageService
                .add(theatreStageDtoMapper.parseToModel(requestDto));
        return theatreStageDtoMapper.parseToDto(theatreStageFromDb);
    }
}
