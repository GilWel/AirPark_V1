package com.example.airpark.dto.hangarDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HangarResponseDto {
    private Integer hangarId;
    private String hangarName;
    private String hangarLocation;
    private Integer hangarCapacity;
}
