package com.example.airpark.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hangar {
    private Integer hangarId;
    private String hangarName;
    private String hangarLocation;
    private Integer hangarCapacity;  // вместимость (максимальное количество самолетов)
}
