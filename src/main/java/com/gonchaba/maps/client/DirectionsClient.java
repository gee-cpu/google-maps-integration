package com.gonchaba.maps.client;

import com.gonchaba.maps.dto.responsedto.DirectionsResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "directions", url = "https://maps.googleapis.com/maps/api/directions")
public interface DirectionsClient {

    @GetMapping("/json")
    DirectionsResponseDTO getDirections(
            @RequestParam("origin") String origin,
            @RequestParam("destination") String destination,
            @RequestParam("key") String apiKey
    );
}
