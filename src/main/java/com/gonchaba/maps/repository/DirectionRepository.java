package com.gonchaba.maps.repository;

import com.gonchaba.maps.model.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectionRepository extends JpaRepository<Direction, Long> {
    Direction findByOriginLatAndOriginLngAndDestinationLatAndDestinationLng(double originLat, double originLng, double destinationLat, double destinationLng);
}
