package com.example.ipinfoweather.dto;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class MainWeatherDTO {
    private int temp;
    private String pressure;
    private String humidity;
    private String temp_min;
    private String temp_max;
}
