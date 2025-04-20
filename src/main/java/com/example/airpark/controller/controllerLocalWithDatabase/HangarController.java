package com.example.airpark.controller.controllerLocalWithDatabase;


import com.example.airpark.dto.hangarDto.HangarRequestDto;
import com.example.airpark.dto.hangarDto.HangarResponseDto;
import com.example.airpark.service.serviceLocalWithDatabase.HangarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hangars")
public class HangarController {
    private HangarService hangarService;

    public HangarController(HangarService hangarService) {
        this.hangarService = hangarService;
    }

    @PostMapping
    public ResponseEntity<HangarResponseDto> createHangar(@RequestBody HangarRequestDto hangarRequestDto) {
        HangarResponseDto hangarResponseDto = hangarService.createHangar(hangarRequestDto);
        return new ResponseEntity<>(hangarResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HangarResponseDto> getHangarById(@PathVariable("id") Integer hangarId) {
        HangarResponseDto hangarResponseDto = hangarService.findHangarById(hangarId);
        return new ResponseEntity<>(hangarResponseDto, HttpStatus.OK);
    }
@GetMapping
    public ResponseEntity<List<HangarResponseDto>> getAllHangars() {
        List<HangarResponseDto> hangars = hangarService.getAllHangars();
        return new ResponseEntity<>(hangars, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHangar(@PathVariable("id") Integer hangarId) {
        hangarService.deleteHangarById(hangarId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
