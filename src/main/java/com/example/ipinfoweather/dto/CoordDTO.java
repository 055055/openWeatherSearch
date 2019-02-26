package com.example.ipinfoweather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
public class CoordDTO {
    @JsonProperty("lon")
    private String lon;
    @JsonProperty("lat")
    private String lat;

    @Override
    public String toString() {
        return "CoordDTO{" +
                "lon='" + lon + '\'' +
                ", lat='" + lat + '\'' +
                '}';
    }
}


