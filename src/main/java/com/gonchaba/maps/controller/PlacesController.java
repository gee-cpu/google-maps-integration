package com.gonchaba.maps.controller;


import com.gonchaba.maps.service.PlacesService;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.PlacesSearchResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlacesController {
    private final PlacesService placesService;

    public PlacesController(PlacesService placesService) {
        this.placesService = placesService;
    }

    @GetMapping("/places/search")
    public ResponseEntity<PlacesSearchResponse> searchPlaces(@RequestParam String query) {
        PlacesSearchResponse response = placesService.searchPlaces(query);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/places/{placeId}")
    public ResponseEntity<PlaceDetails> getPlaceDetails(@PathVariable String placeId) {
        PlaceDetails placeDetails = placesService.getPlaceDetails(placeId);
        return ResponseEntity.ok(placeDetails);
    }

    @GetMapping("/places/police-stations")
    public ResponseEntity<PlacesSearchResponse> findPoliceStations(
            @RequestParam double latitude,
            @RequestParam double longitude
    ) {

        PlacesSearchResponse response = placesService.findPoliceStations(latitude, longitude);
        return ResponseEntity.ok(response);
    }


}

