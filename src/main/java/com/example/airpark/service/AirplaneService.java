package com.example.airpark.service;

import com.example.airpark.dto.airplaneDto.AirplaneRequestDto;
import com.example.airpark.dto.airplaneDto.AirplaneResponseDto;
import com.example.airpark.entity.Airplane;
import com.example.airpark.entity.Hangar;


import com.example.airpark.repository.AirplaneRepository;
import com.example.airpark.repository.HangarRepository;
import com.example.airpark.service.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirplaneService {
    private AirplaneRepository airplaneRepository;
    private HangarService hangarService;
    private Converter converter;
    @Autowired
    public AirplaneService(AirplaneRepository airplaneRepository, HangarService hangarService, Converter converter) {

        this.hangarService = hangarService;
        this.converter = converter;
        this.airplaneRepository = airplaneRepository;
    }

    public AirplaneResponseDto creatAirplane(AirplaneRequestDto request) {
    Hangar hangar = hangarService.findById(request.getHangarId());

        Airplane airplane = converter.fromDto(request);
        airplane.setAirplaneCapacity(request.getAirplaneCapacity());
        airplane.setAvailable(true);
        airplane.setHangar(hangar);
        Airplane savedAirplane = airplaneRepository.save(airplane);
        return converter.toDto(savedAirplane);
    }
    public List <AirplaneResponseDto> getAllAirplanes () {
        return airplaneRepository.findAll()
                .stream()
                .map(converter::toDto)
                .toList();
    }
    public AirplaneResponseDto findById(Integer airplaneId) {
        Airplane airplane = airplaneRepository
                .findById(airplaneId)
                .orElseThrow(()-> new RuntimeException("Airplane not found with id:" + airplaneId));
        return converter.toDto(airplane);
    }
    public void deleteAirplane(Integer airplaneId) {
        airplaneRepository.deleteById(airplaneId);
    }
}
