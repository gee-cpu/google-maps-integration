package com.gonchaba.maps.controller;

import com.gonchaba.maps.exception.CustomMapsException;
import com.gonchaba.maps.service.GeocodingService;
import com.google.maps.model.GeocodingResult;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@RestController
public class GeocodingController {
    private final GeocodingService geocodingService;

    public GeocodingController(GeocodingService geocodingService) {
        this.geocodingService = geocodingService;
    }

    @GetMapping("/geocode")
    public ResponseEntity<GeocodingResult> geocodeAddress(@RequestParam String address) {
        GeocodingResult geocodingResult = geocodingService.geocodeAddress(address);
        return ResponseEntity.ok(geocodingResult);
    }
    void fallBack(Exception e){
        throw new CustomMapsException("Geocoding api service not available,","UNAVAILABLE", 500);
    }
}
