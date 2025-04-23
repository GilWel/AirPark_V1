package com.example.airpark.service.util;

import com.example.airpark.dto.airplaneDto.AirplaneRequestDto;
import com.example.airpark.dto.airplaneDto.AirplaneResponseDto;
import com.example.airpark.dto.hangarDto.HangarRequestDto;
import com.example.airpark.dto.hangarDto.HangarResponseDto;
import com.example.airpark.entity.Airplane;
import com.example.airpark.entity.Hangar;
import org.springframework.stereotype.Component;

@Component
public class Converter {
    public Airplane fromDto(AirplaneRequestDto dto) {
        Airplane airplane = new Airplane();
        airplane.setAirplaneModel(dto.getAirplaneModel());
        airplane.setAirplaneManufacturer(dto.getAirplaneManufacturer());
        airplane.setAirplaneYear(dto.getAirplaneYear());
        airplane.setAirplaneCapacity(dto.getAirplaneCapacity());
        airplane.setAvailable(false); // или false — по логике приложения
        return airplane;
    }

    public AirplaneResponseDto toDto(Airplane airplane) {

        AirplaneResponseDto dto = new AirplaneResponseDto();

        dto.setAirplaneId(airplane.getAirplaneId());
        dto.setAirplaneModel(airplane.getAirplaneModel());
        dto.setAirplaneManufacturer(airplane.getAirplaneManufacturer());
        dto.setAirplaneYear(airplane.getAirplaneYear());
        dto.setAirplaneCapacity(airplane.getAirplaneCapacity());
        dto.setIsAvailable(airplane.isAvailable());


        Hangar hangarFromAirplane = airplane.getHangar();

        HangarResponseDto hangarResponseDto = dtoFromHangar(hangarFromAirplane);

        dto.setHangarResponseDto(hangarResponseDto);


        return dto;
    }


    public HangarResponseDto dtoFromHangar(Hangar hangar) {
        HangarResponseDto hangarResponseDto = new HangarResponseDto(
                hangar.getHangarId(),
                hangar.getHangarName(),
                hangar.getHangarLocation(),
                hangar.getHangarCapacity()
        );

        return hangarResponseDto;
    }


    public Hangar hangarFromDto(HangarRequestDto dto) {
        Hangar hangar = new Hangar();

        hangar.setHangarName(dto.getHangarName());
        hangar.setHangarLocation(dto.getHangarLocation());


        return hangar;
    }
}
