package com.example.airpark.dto.hangarDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HangarResponseDto {
    private Integer hangarId;
    private String hangarName;
    private String hangarLocation;
    private Integer hangarCapacity;
}
