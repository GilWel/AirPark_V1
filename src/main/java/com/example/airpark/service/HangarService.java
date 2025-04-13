package com.example.airpark.service;

import com.example.airpark.dto.hangarDto.HangarRequestDto;
import com.example.airpark.dto.hangarDto.HangarResponseDto;
import com.example.airpark.entity.Hangar;
import com.example.airpark.repository.HangarRepository;
import com.example.airpark.service.util.Converter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HangarService {
    private HangarRepository hangarRepository;
    private Converter converter;

    public HangarService(HangarRepository hangarRepository, Converter converter) {
        this.hangarRepository = hangarRepository;
        this.converter = converter;
    }

    public HangarResponseDto createHangar(HangarRequestDto request) {
       Hangar hangar = converter.hangarFromDto(request);
       hangar.setHangarName(request.getHangarName());
       Hangar saved = hangarRepository.save(hangar);
       return converter.dtoFromHangar(saved);
    }
    public List<HangarResponseDto> getAllHangars() {
        return hangarRepository.findAll()
                .stream()
                .map(converter::dtoFromHangar)
                .toList();
    }
    public HangarResponseDto findHangarById(int id) {
        Hangar hangar = hangarRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Hangar not found with id: " + id));
        return converter.dtoFromHangar(hangar);
    }

    public Hangar findById(Integer id) {
        return hangarRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Hangar not found with id: " + id));
    }
    public void deleteHangarById(int id) {
    hangarRepository.deleteById(id);
    }

}
