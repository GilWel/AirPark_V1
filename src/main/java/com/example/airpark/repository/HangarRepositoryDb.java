package com.example.airpark.repository;

import com.example.airpark.entity.Hangar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HangarRepositoryDb extends JpaRepository<Hangar, Integer> {

    List<Hangar> findByHangarLocation(String hangarLocation);

    List<Hangar> findByHangarName(String name);


}
