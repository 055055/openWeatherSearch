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

    @JsonProperty("id")
    private String cityId;

    @JsonProperty("name")
    private String cityName;

    @JsonProperty("cod")
    private String httpCode;

    @JsonProperty("rain")
    private RainDTO rainDTO;

    @JsonProperty("clouds")
    private CloudDTO cloudDTO;

    @JsonProperty("wind")
    private WindDTO windDTO;
}
