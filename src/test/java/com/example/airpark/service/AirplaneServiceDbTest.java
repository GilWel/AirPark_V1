package com.example.airpark.service;

import com.example.airpark.entity.Airplane;
import com.example.airpark.entity.Hangar;
import com.example.airpark.repository.AirplaneRepositoryDb;
import com.example.airpark.service.util.Converter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AirplaneServiceDbTest {
    @Mock
    private AirplaneRepositoryDb airplaneRepositoryDb;

    @Mock
    private HangarServiceDb hangarServiceDb;

    @Mock
    private Converter converter;

    @InjectMocks
    private AirplaneServiceDb airplaneServiceDb;

    @Test
    void testFindAllReturnsAirplanes() {
        List<Airplane> airplanes = List.of(new Airplane(), new Airplane());
        Mockito.when(airplaneRepositoryDb.findAll()).thenReturn(airplanes);

        List<Airplane> result = airplaneServiceDb.findAll();

        assertEquals(2, result.size());
        Mockito.verify(airplaneRepositoryDb).findAll();
    }

    @Test
    void testFindByHangarReturnsAirplanes() {
        Hangar hangar = new Hangar();
        List<Airplane> airplanes = List.of(new Airplane());
        Mockito.when(airplaneRepositoryDb.findByHangar(hangar)).thenReturn(airplanes);

        List<Airplane> result = airplaneServiceDb.findByHangar(hangar);

        assertEquals(1, result.size());
        Mockito.verify(airplaneRepositoryDb).findByHangar(hangar);
    }

    @Test
    void testFindByLocationReturnsAirplanes() {
        String location = "Moscow";
        List<Airplane> airplanes = List.of(new Airplane());
        Mockito.when(airplaneRepositoryDb.findByHangar_HangarLocation(location)).thenReturn(airplanes);

        List<Airplane> result = airplaneServiceDb.findByLocation(location);

        assertEquals(1, result.size());
        Mockito.verify(airplaneRepositoryDb).findByHangar_HangarLocation(location);
    }

    @Test
    void testFindByIdReturnsAirplane() {
        Integer id = 1;
        Airplane airplane = new Airplane();
        Mockito.when(airplaneRepositoryDb.findById(id)).thenReturn(Optional.of(airplane));

        Optional<Airplane> result = airplaneServiceDb.findById(id);

        assertTrue(result.isPresent());
        assertEquals(airplane, result.get());
        Mockito.verify(airplaneRepositoryDb).findById(id);
    }

    @Test
    void testSaveReturnsSavedAirplane() {
        Airplane airplane = new Airplane();
        Mockito.when(airplaneRepositoryDb.save(airplane)).thenReturn(airplane);

        Airplane result = airplaneServiceDb.save(airplane);

        assertEquals(airplane, result);
        Mockito.verify(airplaneRepositoryDb).save(airplane);
    }

    @Test
    void testDeleteByIdCallsRepositoryDelete() {
        Integer id = 1;

        airplaneServiceDb.deleteById(id);

        Mockito.verify(airplaneRepositoryDb).deleteById(id);
    }

}