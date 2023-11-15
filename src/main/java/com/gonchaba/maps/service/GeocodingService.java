
package com.gonchaba.maps.service;


import com.google.maps.model.GeocodingResult;

public interface GeocodingService {
    GeocodingResult geocodeAddress(String address);
}

