package com.gonchaba.maps.service;

import com.gonchaba.maps.exception.DirectionsException;
import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.TravelMode;
import org.springframework.stereotype.Service;

@Service
public class DirectionsServiceImpl implements DirectionsService {

    private final GeoApiContext geoApiContext;


    public DirectionsServiceImpl(GeoApiContext geoApiContext) {
        this.geoApiContext = geoApiContext;
    }

    @Override
    public DirectionsRoute getDirections(String origin, String destination) {
        try {
            DirectionsApiRequest request = DirectionsApi.newRequest(geoApiContext)
                    .origin(origin)
                    .destination(destination)
                    .mode(TravelMode.DRIVING);

            DirectionsResult result = request.await();
            if (result.routes.length > 0) {
                return result.routes[0];
            } else {
                throw new DirectionsException("No routes found.");
            }
        } catch (Exception e) {
            throw new DirectionsException("Error occurred while getting directions.", e);
        }
    }
}
