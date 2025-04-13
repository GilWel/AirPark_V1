package com.example.airpark.dto.airplaneDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirplaneRequestDto {

    private String airplaneModel;
    private String airplaneManufacturer;
    private Integer airplaneYear;
    private Integer airplaneCapacity;
    private Integer hangarId;
}
