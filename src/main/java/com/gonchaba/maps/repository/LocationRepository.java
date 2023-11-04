package com.gonchaba.maps.repository;

import com.gonchaba.maps.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
