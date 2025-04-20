package com.example.airpark.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Hangar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer hangarId;
    private String hangarName;
    private String hangarLocation;
    private Integer hangarCapacity;  // вместимость (максимальное количество самолетов)
}
