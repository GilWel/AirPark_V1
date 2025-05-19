package com.example.airpark.controller;


import com.example.airpark.entity.Airplane;
import com.example.airpark.service.AirplaneServiceDb;
import com.example.airpark.service.util.Converter;
import com.example.airpark.dto.airplaneDto.AirplaneResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AirplaneControllerDb.class)
class AirplaneControllerDbTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AirplaneServiceDb airplaneServiceDb;

    @MockBean
    private Converter converter;

    @Test
    void testGetAllAirplanesReturnsOk() throws Exception {
        Airplane airplane = new Airplane();
        AirplaneResponseDto dto = new AirplaneResponseDto();

        when(airplaneServiceDb.findAll()).thenReturn(List.of(airplane));
        when(converter.toDto(airplane)).thenReturn(dto);

        mockMvc.perform(get("/api/airplanes"))
                .andExpect(status().isOk());
    }
}
