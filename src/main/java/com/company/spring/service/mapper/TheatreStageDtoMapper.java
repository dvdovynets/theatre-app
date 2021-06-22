package com.company.spring.service.mapper;

import com.company.spring.model.TheatreStage;
import com.company.spring.model.dto.TheatreStageRequestDto;
import com.company.spring.model.dto.TheatreStageResponseDto;
import org.springframework.stereotype.Component;

@Component
public class TheatreStageDtoMapper {

    public TheatreStageResponseDto parseToDto(TheatreStage theatreStage) {
        TheatreStageResponseDto responseDto = new TheatreStageResponseDto();
        responseDto.setId(theatreStage.getId());
        responseDto.setCapacity(theatreStage.getCapacity());
        responseDto.setDescription(theatreStage.getDescription());
        return responseDto;
    }

    public TheatreStage parseToModel(TheatreStageRequestDto requestDto) {
        TheatreStage theatreStage = new TheatreStage();
        theatreStage.setCapacity(requestDto.getCapacity());
        theatreStage.setDescription(requestDto.getDescription());
        return theatreStage;
    }
}
