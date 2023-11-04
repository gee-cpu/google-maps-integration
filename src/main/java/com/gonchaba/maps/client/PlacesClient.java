package com.gonchaba.maps.client;

import com.gonchaba.maps.dto.responsedto.PlacesResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "places", url = "https://maps.googleapis.com/maps/api/place")
public interface PlacesClient {

    @GetMapping("/nearbysearch/json")
    PlacesResponseDTO findNearbyPoliceStations(
            @RequestParam("location") String location,
            @RequestParam("radius") int radius,
            @RequestParam("keyword") String keyword,
            @RequestParam("key") String apiKey
    );
}
