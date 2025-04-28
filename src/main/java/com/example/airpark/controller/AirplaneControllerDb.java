package com.example.airpark.controller;

import com.example.airpark.dto.airplaneDto.AirplaneRequestDto;
import com.example.airpark.dto.airplaneDto.AirplaneResponseDto;
import com.example.airpark.entity.Airplane;
import com.example.airpark.entity.Hangar;
import com.example.airpark.service.AirplaneServiceDb;
import com.example.airpark.service.HangarServiceDb;
import com.example.airpark.service.util.Converter;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/airplanes")
@AllArgsConstructor
public class AirplaneControllerDb {

    private final AirplaneServiceDb airplaneServiceDb;
    private final HangarServiceDb hangarServiceDb;
    private final Converter converter;

    // Получить все самолеты
    @GetMapping
    public List<AirplaneResponseDto> getAllAirplanes() {
        List<Airplane> airplanes = airplaneServiceDb.findAll();
        return airplanes.stream().map(converter::toDto).toList();
    }

    // Получить самолет по ID
    @GetMapping("/{id}")
    public ResponseEntity<AirplaneResponseDto> getAirplaneById(@PathVariable Integer id) {
        Optional<Airplane> airplaneOptional = airplaneServiceDb.findById(id);
        return airplaneOptional.map(airplane -> ResponseEntity.ok(converter.toDto(airplane))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Создать новый самолет
    @PostMapping
    public ResponseEntity<AirplaneResponseDto> createAirplane(@Valid @RequestBody AirplaneRequestDto airplaneRequestDto) {
        Optional<Hangar> hangar = hangarServiceDb.findById(airplaneRequestDto.getHangarId());
        if (hangar.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        Airplane airplane = converter.fromDto(airplaneRequestDto);
        airplane.setHangar(hangar.get());

        Airplane savedAirplane = airplaneServiceDb.save(airplane);
        return ResponseEntity.ok(converter.toDto(savedAirplane));
    }

    // Обновить информацию о самолете
    @PutMapping("/{id}")
    public ResponseEntity<AirplaneResponseDto> updateAirplane(@PathVariable Integer id, @RequestBody AirplaneRequestDto airplaneRequestDto) {
        Optional<Airplane> airplaneOptional = airplaneServiceDb.findById(id);
        if (airplaneOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Optional<Hangar> hangar = hangarServiceDb.findById(airplaneRequestDto.getHangarId());
        if (hangar.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        Airplane airplane = airplaneOptional.get();
        airplane.setAirplaneModel(airplaneRequestDto.getAirplaneModel());
        airplane.setAirplaneManufacturer(airplaneRequestDto.getAirplaneManufacturer());
        airplane.setAirplaneYear(airplaneRequestDto.getAirplaneYear());
        airplane.setAirplaneCapacity(airplaneRequestDto.getAirplaneCapacity());
        airplane.setHangar(hangar.get());

        Airplane updatedAirplane = airplaneServiceDb.save(airplane);
        return ResponseEntity.ok(converter.toDto(updatedAirplane));
    }

    // Удалить самолет
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirplane(@PathVariable Integer id) {
        airplaneServiceDb.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


