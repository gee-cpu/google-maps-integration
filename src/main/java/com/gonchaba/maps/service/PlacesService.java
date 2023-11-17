package com.gonchaba.maps.service;


import com.google.maps.model.PlaceDetails;
import com.google.maps.model.PlacesSearchResponse;

public interface PlacesService {
    PlacesSearchResponse searchPlaces(String query);

    PlaceDetails getPlaceDetails(String placeId);

    PlacesSearchResponse findPoliceStations(double latitude, double longitude) throws Exception;
}


