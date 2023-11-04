package com.gonchaba.maps.controller;

import com.gonchaba.maps.dto.requestdto.DirectionsRequestDTO;
import com.gonchaba.maps.model.Direction;
import com.gonchaba.maps.service.DirectionsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/directions")

public class DirectionController {
    private DirectionsService directionsService;


    public DirectionController(DirectionsService directionsService) {
        this.directionsService = directionsService;
    }

    @GetMapping("/direction")
    public Direction getDirections(DirectionsRequestDTO requestDTO) {
        return directionsService.getDirections(requestDTO);
    }
}
