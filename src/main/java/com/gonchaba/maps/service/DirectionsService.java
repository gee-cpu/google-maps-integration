package com.gonchaba.maps.service;

import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsRoute;

import java.io.IOException;

public interface DirectionsService {

    DirectionsRoute getDirections(String origin, String destination) throws ApiException, InterruptedException, IOException;
}
