package com.gonchaba.maps.controller;

import com.gonchaba.maps.dto.requestdto.GeocodingRequestDTO;
import com.gonchaba.maps.dto.responsedto.GeocodingResponseDTO;
import com.gonchaba.maps.service.GeocodingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/geocoding")
public class GeocodingController {
    private static final Logger logger = Logger.getLogger(GeocodingController.class.getName());

    private final GeocodingService geocodingService;

    public GeocodingController(GeocodingService geocodingService) {
        this.geocodingService = geocodingService;
    }

    @GetMapping("/geocode")
    public GeocodingResponseDTO geocodeAddress(@RequestParam("address") String address, @RequestParam("key") String apiKey) {
        logger.info("Received a request to geocode address: " + address);

        GeocodingRequestDTO requestDTO = new GeocodingRequestDTO();
        requestDTO.setAddress(address);
        requestDTO.setKey(apiKey);

        return geocodingService.geocode(requestDTO);
    }
}
