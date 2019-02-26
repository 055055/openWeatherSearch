package com.example.ipinfoweather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
public class RainDTO {
    @JsonProperty("3h")
    private String rain;

    @Override
    public String toString() {
        return "RainDTO{" +
                "rain='" + rain + '\'' +
                '}';
    }
}
