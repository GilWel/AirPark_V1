package com.example.airpark.dto.airplaneDto;

import com.example.airpark.dto.hangarDto.HangarResponseDto;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirplaneResponseDto {
    private Integer airplaneId;
    private String airplaneModel;
    private String airplaneManufacturer;
    private Integer airplaneYear;
    private Integer airplaneCapacity;
    @Setter
    private boolean isAvailable;

    private HangarResponseDto hangarResponseDto;

    public AirplaneResponseDto(Integer airplaneId, String airplaneModel, String airplaneManufacturer, Integer airplaneYear, Integer airplaneCapacity) {
        this.airplaneId = airplaneId;
        this.airplaneModel = airplaneModel;
        this.airplaneManufacturer = airplaneManufacturer;
        this.airplaneYear = airplaneYear;
        this.airplaneCapacity = airplaneCapacity;

    }

    public void setIsAvailable(boolean available) {

    }
}
