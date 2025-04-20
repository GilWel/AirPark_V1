package com.example.airpark.repository.repositoryLocalWithDatabase;

import com.example.airpark.entity.Hangar;

import java.util.List;
import java.util.Optional;

public interface HangarRepository {
    List<Hangar> findByName(String hangarName);
    Optional<Hangar>  findById(Integer hangarId);
    Hangar save(Hangar hangar);
    void deleteById(Integer hangarId);
    List<Hangar> findByLocation(String hangarLocation);
    List<Hangar> findAll();


}
