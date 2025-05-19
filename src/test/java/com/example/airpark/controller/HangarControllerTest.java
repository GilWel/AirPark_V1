package com.example.airpark.controller;

import com.example.airpark.entity.Hangar;
import com.example.airpark.service.HangarServiceDb;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)


class HangarControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private HangarServiceDb hangarServiceDb;

    @Test
    void testGetHangarsByLocation() throws Exception {
        // Мокаем возвращаемое значение
        when(hangarServiceDb.findByLocation("New York")).thenReturn(List.of(new Hangar()));

        // Выполняем GET-запрос по location и проверяем статус
        mockMvc.perform(get("/api/hangars/location/New York"))
                .andExpect(status().isOk());

        // Проверяем, что метод findByLocation был вызван
        verify(hangarServiceDb).findByLocation("New York");
    }
}

