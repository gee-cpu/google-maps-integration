package com.gonchaba.maps.repository;

import com.gonchaba.maps.model.AddressComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressComponentRepository extends JpaRepository<AddressComponent, Long> {
}
