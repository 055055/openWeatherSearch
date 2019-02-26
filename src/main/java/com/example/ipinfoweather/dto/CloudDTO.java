package com.example.ipinfoweather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
public class CloudDTO {

    @JsonProperty("all")
    private String clouds;

    @Override
    public String toString() {
        return "CloudDTO{" +
                "clouds='" + clouds + '\'' +
                '}';
    }
}
