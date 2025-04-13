package com.example.airpark.repository;

import com.example.airpark.entity.Hangar;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class HangarRepositoryImpl implements HangarRepository {
    private List<Hangar> hangars;
    private Integer idHangarCounter;

    public HangarRepositoryImpl() {
        this.hangars = new ArrayList<>();
        this.idHangarCounter = 0;
    }

    @Override
    public List<Hangar> findByName(String name) {
        return hangars.stream()
                .filter(hangar -> hangar.getHangarName().equals(name))
                .toList();
    }

    @Override
    public Optional<Hangar>  findById(Integer idHangar) {
        return hangars.stream()
                .filter(hangar -> hangar.getHangarId().equals(idHangar))
                .findFirst();
    }

    @Override
    public Hangar save(Hangar hangar) {
        hangar.setHangarId(++idHangarCounter);
        hangars.add(hangar);
        return hangar;
    }

    @Override
    public void deleteById(Integer idHangar) {
        hangars.removeIf(hangar -> hangar.getHangarId().equals(idHangar));

    }

    @Override
    public List<Hangar> findByLocation(String location) {
        return hangars.stream()
                .filter(hangar -> hangar.getHangarLocation().equals(location))
                .toList();
    }
    @Override
    public List<Hangar> findAll() {
        return new ArrayList<>(hangars);
    }
}
