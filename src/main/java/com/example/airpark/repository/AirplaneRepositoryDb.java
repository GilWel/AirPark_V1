package com.example.airpark.repository;

import com.example.airpark.entity.Airplane;
import com.example.airpark.entity.Hangar;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface AirplaneRepositoryDb extends JpaRepository<Airplane, Integer> {

    List<Airplane> findByHangar_HangarLocation(String location);

    List<Airplane> findByHangar(Hangar hangar);
}
