package com.example.airpark.service;

import com.example.airpark.entity.Hangar;
import com.example.airpark.repository.HangarRepositoryDb;
import com.example.airpark.service.util.Converter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HangarServiceDbTest {
    private HangarRepositoryDb hangarRepositoryDb;
    private Converter converter;
    private HangarServiceDb hangarServiceDb;

    @BeforeEach
    void setUp() {
        hangarRepositoryDb = mock(HangarRepositoryDb.class);
        converter = mock(Converter.class); // Если не используешь в этих методах — можно передать null
        hangarServiceDb = new HangarServiceDb(hangarRepositoryDb, converter);
    }

    @Test
    void testFindAll() {
        List<Hangar> hangars = List.of(new Hangar(), new Hangar());
        when(hangarRepositoryDb.findAll()).thenReturn(hangars);

        List<Hangar> result = hangarServiceDb.findAll();

        assertEquals(2, result.size());
        verify(hangarRepositoryDb).findAll();
    }

    @Test
    void testFindByLocation() {
        String location = "New York";
        List<Hangar> expected = List.of(new Hangar());
        when(hangarRepositoryDb.findByHangarLocation(location)).thenReturn(expected);

        List<Hangar> result = hangarServiceDb.findByLocation(location);

        assertEquals(expected, result);
        verify(hangarRepositoryDb).findByHangarLocation(location);
    }

    @Test
    void testFindByName() {
        String name = "Alpha";
        List<Hangar> expected = List.of(new Hangar());
        when(hangarRepositoryDb.findByHangarName(name)).thenReturn(expected);

        List<Hangar> result = hangarServiceDb.findByName(name);

        assertEquals(expected, result);
        verify(hangarRepositoryDb).findByHangarName(name);
    }

    @Test
    void testFindByIdFound() {
        Hangar hangar = new Hangar();
        when(hangarRepositoryDb.findById(1)).thenReturn(Optional.of(hangar));

        Optional<Hangar> result = hangarServiceDb.findById(1);

        assertTrue(result.isPresent());
        assertEquals(hangar, result.get());
        verify(hangarRepositoryDb).findById(1);
    }

    @Test
    void testFindByIdNotFound() {
        when(hangarRepositoryDb.findById(2)).thenReturn(Optional.empty());

        Optional<Hangar> result = hangarServiceDb.findById(2);

        assertFalse(result.isPresent());
        verify(hangarRepositoryDb).findById(2);
    }

    @Test
    void testSave() {
        Hangar hangar = new Hangar();
        when(hangarRepositoryDb.save(hangar)).thenReturn(hangar);

        Hangar result = hangarServiceDb.save(hangar);

        assertEquals(hangar, result);
        verify(hangarRepositoryDb).save(hangar);
    }

    @Test
    void testDeleteById() {
        Integer id = 10;

        hangarServiceDb.deleteById(id);

        verify(hangarRepositoryDb).deleteById(id);
    }
  
}