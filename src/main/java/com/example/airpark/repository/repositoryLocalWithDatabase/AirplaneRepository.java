package com.example.airpark.repository.repositoryLocalWithDatabase;

import com.example.airpark.entity.Airplane;
import com.example.airpark.entity.Hangar;

import java.util.List;
import java.util.Optional;

public interface AirplaneRepository {
    List<Airplane> findAll();
    Optional<Airplane> findById(Integer airplaneId);
    Airplane save(Airplane airplane);
    void deleteById(Integer airplaneId);
    List<Airplane> findByModel(String airplaneModel);
    List<Airplane> findByHangar(Hangar hangar);
}
