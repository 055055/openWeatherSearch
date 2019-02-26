package com.example.ipinfoweather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
public class WindDTO {
    @JsonProperty("speed")
    private String speed;

    @JsonProperty("deg")
    private String deg;

    @Override
    public String toString() {
        return "WindDTO{" +
                "speed='" + speed + '\'' +
                ", deg='" + deg + '\'' +
                '}';
    }
}
