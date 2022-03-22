package com.example.ipinfoweather.dto;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class OpenWeatherMapDTO {
    private String id;
    private String main;
    private String description;
    private String icon;
}
