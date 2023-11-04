package com.gonchaba.maps.client;

import com.gonchaba.maps.dto.responsedto.GeocodingResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "geocoding", url = "https://maps.googleapis.com/maps/api/geocode")
public interface GeocodingClient {

    @GetMapping("/json")
    GeocodingResponseDTO geocodeAddress(@RequestParam("address") String address, @RequestParam("key") String apiKey);
}
