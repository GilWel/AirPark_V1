package com.example.airpark.service;

import com.example.airpark.entity.Hangar;
import com.example.airpark.repository.HangarRepositoryDb;
import com.example.airpark.service.util.Converter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class HangarServiceDb  {
   private HangarRepositoryDb hangarRepositoryDb;
    private Converter converter;
    public List<Hangar> findAll() {
        return hangarRepositoryDb.findAll();
    }

    public List<Hangar> findByLocation(String location) {
        return hangarRepositoryDb.findByHangarLocation(location);
    }

    public List<Hangar> findByName(String name) {
        return hangarRepositoryDb.findByHangarName(name);
    }

    public Optional<Hangar> findById(Integer id) {
        return hangarRepositoryDb.findById(id);
    }

    public Hangar save(Hangar hangar) {
        return hangarRepositoryDb.save(hangar);
    }

    public void deleteById(Integer id) {
        hangarRepositoryDb.deleteById(id);
    }

}
