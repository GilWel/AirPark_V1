package com.example.airpark.service.util;

import com.example.airpark.dto.airplaneDto.AirplaneRequestDto;
import com.example.airpark.dto.airplaneDto.AirplaneResponseDto;
import com.example.airpark.dto.hangarDto.HangarRequestDto;
import com.example.airpark.dto.hangarDto.HangarResponseDto;
import com.example.airpark.entity.Airplane;
import com.example.airpark.entity.Hangar;
import org.springframework.stereotype.Service;

@Service
public class Converter {

    public Airplane fromDto(AirplaneRequestDto dto) {
        return Airplane.builder()
                .airplaneModel(dto.getAirplaneModel())
                .airplaneManufacturer(dto.getAirplaneManufacturer())
                .airplaneYear(dto.getAirplaneYear())
                .airplaneCapacity(dto.getAirplaneCapacity())
                .isAvailable(false) // логика по умолчанию
                .build();
    }

    public AirplaneResponseDto toDto(Airplane airplane) {
        return AirplaneResponseDto.builder()
                .airplaneId(airplane.getAirplaneId())
                .airplaneModel(airplane.getAirplaneModel())
                .airplaneManufacturer(airplane.getAirplaneManufacturer())
                .airplaneYear(airplane.getAirplaneYear())
                .airplaneCapacity(airplane.getAirplaneCapacity())
                .isAvailable(airplane.isAvailable())
                .hangarResponseDto(dtoFromHangar(airplane.getHangar()))
                .build();
    }

    public HangarResponseDto dtoFromHangar(Hangar hangar) {
        return HangarResponseDto.builder()
                .hangarId(hangar.getHangarId())
                .hangarName(hangar.getHangarName())
                .hangarLocation(hangar.getHangarLocation())
                .hangarCapacity(hangar.getHangarCapacity())
                .build();
    }

    public Hangar hangarFromDto(HangarRequestDto dto) {
        return Hangar.builder()
                .hangarName(dto.getHangarName())
                .hangarLocation(dto.getHangarLocation())
                .build();
    }
}
