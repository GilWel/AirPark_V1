package com.example.airpark.dto.airplaneDto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirplaneRequestDto {

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
    @NotNull(message = "Hangar ID is required")
    private Integer hangarId;
}
