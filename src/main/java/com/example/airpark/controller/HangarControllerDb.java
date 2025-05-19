package com.example.airpark.controller;

import com.example.airpark.dto.hangarDto.HangarRequestDto;
import com.example.airpark.dto.hangarDto.HangarResponseDto;
import com.example.airpark.entity.Hangar;
import com.example.airpark.service.HangarServiceDb;
import com.example.airpark.service.util.Converter;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hangars")
@AllArgsConstructor
public class HangarControllerDb {

    private final HangarServiceDb hangarServiceDb;
    private final Converter converter;

    // Получить все ангары
    @GetMapping
    public List<HangarResponseDto> getAllHangars() {
        List<Hangar> hangars = hangarServiceDb.findAll();
        return hangars.stream().map(converter::dtoFromHangar).toList();
    }

    // Получить ангар по ID
    @GetMapping("/{id}")
    public ResponseEntity<HangarResponseDto> getHangarById(@PathVariable Integer id) {
        Optional<Hangar> hangarOptional = hangarServiceDb.findById(id);
        return hangarOptional.map(hangar -> ResponseEntity.ok(converter.dtoFromHangar(hangar))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Создать новый ангар
    @PostMapping
    public ResponseEntity<HangarResponseDto> createHangar(@Valid @RequestBody HangarRequestDto hangarRequestDto) {
        Hangar hangar = converter.hangarFromDto(hangarRequestDto);
        hangar.setHangarCapacity(10);
        Hangar savedHangar = hangarServiceDb.save(hangar);
        return ResponseEntity.ok(converter.dtoFromHangar(savedHangar));
    }

    // Обновить информацию об ангаре
    @PutMapping("/{id}")
    public ResponseEntity<HangarResponseDto> updateHangar(@PathVariable Integer id, @RequestBody HangarRequestDto hangarRequestDto) {
        Optional<Hangar> hangarOptional = hangarServiceDb.findById(id);
        if (hangarOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Hangar hangar = hangarOptional.get();
        hangar.setHangarName(hangarRequestDto.getHangarName());
        hangar.setHangarLocation(hangarRequestDto.getHangarLocation());

        Hangar updatedHangar = hangarServiceDb.save(hangar);
        return ResponseEntity.ok(converter.dtoFromHangar(updatedHangar));
    }

    // Удалить ангар
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHangar(@PathVariable Integer id) {
        hangarServiceDb.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}


