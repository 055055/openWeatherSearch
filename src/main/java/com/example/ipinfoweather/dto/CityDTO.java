package com.example.ipinfoweather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
public class CityDTO {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String city;

    @JsonProperty("coord")
    private CoordDTO coordDTO;

    @Override
    public String toString() {
        return "CityDTO{" +
                "id='" + id + '\'' +
                ", city='" + city + '\'' +
                ", coordDTO=" + coordDTO +
                '}';
    }
}
