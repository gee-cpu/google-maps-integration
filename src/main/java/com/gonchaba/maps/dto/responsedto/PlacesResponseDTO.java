package com.gonchaba.maps.dto.responsedto;

import com.gonchaba.maps.model.Place;
import lombok.Data;

import java.util.List;

@Data
public class PlacesResponseDTO {
    private List<Place> results;
    private List<String> htmlAttributions;
    private String status;

}
