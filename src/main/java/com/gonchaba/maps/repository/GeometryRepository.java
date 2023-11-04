package com.gonchaba.maps.repository;

import com.gonchaba.maps.model.Geometry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeometryRepository extends JpaRepository<Geometry, Long> {
}
