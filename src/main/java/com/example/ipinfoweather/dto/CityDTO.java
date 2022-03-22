package com.example.ipinfoweather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CityDTO {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String city;

    @JsonProperty("coord")
    private CoordDTO coordDTO;
}
