package com.example.airpark.controller;

import com.example.airpark.dto.airplaneDto.AirplaneRequestDto;
import com.example.airpark.dto.airplaneDto.AirplaneResponseDto;
import com.example.airpark.service.AirplaneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airplanes")
public class AirplaneController {
    private AirplaneService airplaneService;

    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }
    @PostMapping
    public ResponseEntity<AirplaneResponseDto> createAirplane(@RequestBody AirplaneRequestDto airplaneRequestDto) {
        AirplaneResponseDto airplaneResponseDto = airplaneService.creatAirplane(airplaneRequestDto);
        return new ResponseEntity<>(airplaneResponseDto, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AirplaneResponseDto> getAirplaneById(@PathVariable("id") Integer airplaneId) {
        AirplaneResponseDto airplaneResponseDto = airplaneService.findById(airplaneId);
        return new ResponseEntity<>(airplaneResponseDto, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<AirplaneResponseDto>> getAllAirplanes() {
        List<AirplaneResponseDto> airplanes = airplaneService.getAllAirplanes();
        return new ResponseEntity<>(airplanes, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirplane (@PathVariable("id") Integer airplaneId) {
        airplaneService.deleteAirplane(airplaneId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
