package com.gonchaba.maps.controller;

import com.gonchaba.maps.dto.responsedto.GeocodingResponseDTO;
import com.gonchaba.maps.service.GeocodingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.logging.Logger;

import static org.mockito.Mockito.*;

class GeocodingControllerTest {
    @Mock
    Logger logger;
    @Mock
    GeocodingService geocodingService;
    @InjectMocks
    GeocodingController geocodingController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGeocodeAddress() {
        when(geocodingService.geocode(any())).thenReturn(new GeocodingResponseDTO());

        GeocodingResponseDTO result = geocodingController.geocodeAddress("address", "apiKey");
        Assertions.assertEquals(new GeocodingResponseDTO(), result);
    }
}

