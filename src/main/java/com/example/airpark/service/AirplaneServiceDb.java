package com.example.airpark.service;

import com.example.airpark.entity.Airplane;
import com.example.airpark.entity.Hangar;
import com.example.airpark.repository.AirplaneRepositoryDb;
import com.example.airpark.service.serviceLocalWithDatabase.HangarService;
import com.example.airpark.service.util.Converter;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class AirplaneServiceDb  {
    private AirplaneRepositoryDb airplaneRepositoryDb;
    private HangarServiceDb  hangarServiceDb;
    private Converter converter;


    public List<Airplane> findAll() {
        return airplaneRepositoryDb.findAll();
    }

    public List<Airplane> findByHangar(Hangar hangar) {
        return airplaneRepositoryDb.findByHangar(hangar);
    }

    public List<Airplane> findByLocation(String location) {
        return airplaneRepositoryDb.findByHangar_HangarLocation(location);
    }

    public Optional<Airplane> findById(Integer id) {
        return airplaneRepositoryDb.findById(id);
    }

    public Airplane save(Airplane airplane) {
        return airplaneRepositoryDb.save(airplane);
    }

    public void deleteById(Integer id) {
        airplaneRepositoryDb.deleteById(id);
    }
}