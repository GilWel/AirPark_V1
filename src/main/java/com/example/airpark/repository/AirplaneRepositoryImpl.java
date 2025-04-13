package com.example.airpark.repository;

import com.example.airpark.entity.Airplane;
import com.example.airpark.entity.Hangar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository

public class AirplaneRepositoryImpl implements AirplaneRepository {
    private List<Airplane> airplanes;
    private Integer idAirplaneCounter;

    public AirplaneRepositoryImpl() {
        this.airplanes = new ArrayList<>();
        this.idAirplaneCounter = 0;
    }

    @Override
    public List<Airplane> findAll() {
        return new ArrayList<>(airplanes);
    }

    @Override
    public Optional<Airplane> findById(Integer id) {
        return Optional.ofNullable(airplanes.get(id));
    }

    @Override
    public Airplane save(Airplane airplane){
        airplane.setAirplaneId(++idAirplaneCounter);
        airplanes.add(airplane);
        return airplane;
    }

    @Override
    public void deleteById(Integer id) {
        airplanes.removeIf(airplane -> airplane.getAirplaneId().equals(id));

    }

    @Override
    public List<Airplane> findByModel(String model) {
        return airplanes.stream()
                .filter(a -> a.getAirplaneModel().equals(model))
                .toList();
    }

    @Override
    public List<Airplane> findByHangar(Hangar hangar) {
        return airplanes.stream()
                .filter(airplane -> airplane.getHangar().equals(hangar))
                .toList();
    }
}
