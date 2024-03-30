package com.gonchaba.maps.controller;

import com.gonchaba.maps.exception.CustomMapsException;
import com.gonchaba.maps.service.DirectionsService;
import com.google.maps.model.DirectionsRoute;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@RestController
@RequestMapping("/directions")
public class DirectionsController {

    private final DirectionsService directionsService;


    public DirectionsController(DirectionsService directionsService) {
        this.directionsService = directionsService;
    }

    @GetMapping
    public ResponseEntity<DirectionsRoute> getDirections(
            @RequestParam String origin,
            @RequestParam String destination
    ) {

        DirectionsRoute route = directionsService.getDirections(origin, destination);
        return ResponseEntity.ok(route);

    }

    void fallBack(Exception e){
        throw new CustomMapsException("Directions api service not available,","UNAVAILABLE", 500);
    }
}

