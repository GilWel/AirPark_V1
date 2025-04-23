package com.example.airpark.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="airpark")
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer airplaneId;
    @Column(name="airplane_model_name")
    private String airplaneModel;
    private String airplaneManufacturer;
    private Integer airplaneYear;
    private Integer airplaneCapacity;
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "hangar_hangar_id")
    private Hangar hangar; //ангар, где стоит этот самолет

//    public Airplane(String airplaneModel, String airplaneManufacturer, Integer airplaneYear, Integer airplaneCapacity) {
//        this.airplaneModel = airplaneModel;
//        this.airplaneManufacturer = airplaneManufacturer;
//        this.airplaneYear = airplaneYear;
//        this.airplaneCapacity = airplaneCapacity;
//    }

    public Airplane(Integer airplaneId, String airplaneModel, String airplaneManufacturer, Integer airplaneYear, Integer airplaneCapacity, boolean isAvailable) {
        this.airplaneId = airplaneId;
        this.airplaneModel = airplaneModel;
        this.airplaneManufacturer = airplaneManufacturer;
        this.airplaneYear = airplaneYear;
        this.airplaneCapacity = airplaneCapacity;
        this.isAvailable = true;

    }
}
