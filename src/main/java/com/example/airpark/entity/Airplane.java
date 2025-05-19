package com.example.airpark.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
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
    @NotBlank(message = "Model is required")
    private String airplaneModel;

    @NotBlank(message = "Manufacturer is required")
    private String airplaneManufacturer;

    @NotNull(message = "Year is required")
    @Min(value = 1900, message = "Year must be no earlier than 1900")
    private Integer airplaneYear;

    @NotNull(message = "Capacity is required")
    @Min(value = 1, message = "Capacity must be positive")
    private Integer airplaneCapacity;
    
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "hangar_hangar_id")
    @NotNull(message = "Hangar ID is required")
    private Hangar hangar; //ангар, где стоит этот самолет

    public Airplane(Integer airplaneId, String airplaneModel, String airplaneManufacturer, Integer airplaneYear, Integer airplaneCapacity, boolean isAvailable) {
        this.airplaneId = airplaneId;
        this.airplaneModel = airplaneModel;
        this.airplaneManufacturer = airplaneManufacturer;
        this.airplaneYear = airplaneYear;
        this.airplaneCapacity = airplaneCapacity;
        this.isAvailable = true;

    }
}
