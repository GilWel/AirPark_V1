package com.example.airpark.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Airplane {
    private Integer airplaneId;
    private String airplaneModel;
    private String airplaneManufacturer;
    private Integer airplaneYear;
    private Integer airplaneCapacity;
    private boolean isAvailable;

    private Hangar hangar; //ангар, где стоит этот самолет

    public Airplane(String airplaneModel, String airplaneManufacturer, Integer airplaneYear, Integer airplaneCapacity) {
        this.airplaneModel = airplaneModel;
        this.airplaneManufacturer = airplaneManufacturer;
        this.airplaneYear = airplaneYear;
        this.airplaneCapacity = airplaneCapacity;
    }


}
