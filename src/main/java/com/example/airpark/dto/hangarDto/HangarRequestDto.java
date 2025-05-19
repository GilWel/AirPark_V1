package com.example.airpark.dto.hangarDto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HangarRequestDto {
    @NotBlank(message = "Hangar name is required")
    private String hangarName;
    @NotBlank(message = "Hangar location is required")
    private String hangarLocation;
// &&&???
    @NotNull(message = "Hangar capacity is required")
    @Min(value = 1, message = "Hangar capacity must be at least 1")
    private Integer hangarCapacity;



}

