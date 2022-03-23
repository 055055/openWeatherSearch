package com.example.ipinfoweather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class WeatherDTO {
    @JsonProperty("main")
    private MainWeatherDTO mainWeatherDTO;

    @JsonProperty("coord")
    private CoordDTO coordDTO;

    private Long dt;
    private String convertDt;

    @JsonProperty("weather")
    private List<OpenWeatherMapDTO> openWeatherMapDTO;

    @JsonProperty("sys")
    private SysDTO sysDTO;

    @JsonProperty("name")
    private String cityName;
}
