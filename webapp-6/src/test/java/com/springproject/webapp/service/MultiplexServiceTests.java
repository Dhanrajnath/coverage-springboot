package com.springproject.webapp.service;

import com.springproject.webapp.dao.MultiplexJpaRepository;
import com.springproject.webapp.entity.Multiplex;
import com.springproject.webapp.exception.multiplex.MultiplexNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {com.springproject.webapp.WebappApplication.class})
class MultiplexServiceTests {

    private MultiplexService multiplexService;

    @Mock
    private MultiplexJpaRepository mockRepository;

    @BeforeEach
    void initUseCase() {
        multiplexService = new MultiplexServiceImpl(mockRepository);
    }

    @Test
    void findAllMultiplexTest() {
        when(mockRepository.findAll()).thenReturn(Stream.of(new Multiplex("PVR", 4, "Warangal"), new Multiplex("PVR2", 4, "Warangal")).collect(Collectors.toList()));
        assertEquals(2, multiplexService.findAllMultiplex().size());
    }

    @Test
    void findMultiplexByIdTest() {
        Multiplex multiplex = new Multiplex("PVR", 4, "Warangal");
        when(mockRepository.findById(1)).thenReturn(java.util.Optional.of(multiplex));

        assertEquals(multiplex, multiplexService.findMultiplexById(1));
        verify(mockRepository).findById(1);
    }

    @Test
    void findMultiplexByIdTest_ThrowsMultiplexNotFoundException() {
        when(mockRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(MultiplexNotFoundException.class, () -> multiplexService.findMultiplexById(1));
        verify(mockRepository).findById(1);
    }

    @Test
    void deleteMultiplexByIdTest() {
        multiplexService.deleteMultiplexById(1);
        verify(mockRepository).deleteById(1);
    }

    @Test
    void saveMultiplexTest() {
        Multiplex multiplex = new Multiplex("PVR", 5, "Warangal");
        when(mockRepository.findByMultiplexName(multiplex.getMultiplexName())).thenReturn(null);
        multiplexService.saveMultiplex(multiplex);
        verify(mockRepository).save(multiplex);
    }

    @Test
    void saveSameMultiplexTest() {
        Multiplex multiplex = new Multiplex("PVR", 5, "Warangal");
        when(mockRepository.findByMultiplexName(multiplex.getMultiplexName())).thenReturn(multiplex);
        multiplexService.saveMultiplex(multiplex);
        verify(mockRepository, never()).save(any(Multiplex.class));
    }
}
