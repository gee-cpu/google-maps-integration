package com.gonchaba.maps.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "address_components")
@Data
public class AddressComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String longName;
    private String shortName;
    @Transient
    private String[] types;

    public void setGeometry(Geometry geometry) {

    }
}
