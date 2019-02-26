package com.example.ipinfoweather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherDTO {
    @JsonProperty("main")
    private MainWeatherDTO mainWeatherDTO;

    @JsonProperty("coord")
    private CoordDTO coordDTO;

    @JsonProperty("dt")
    private Long dt;

    @JsonProperty("convertDt")
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

    @Override
    public String toString() {
        return "WeatherDTO{" +
                "mainWeatherDTO=" + mainWeatherDTO +
                ", coordDTO=" + coordDTO +
                ", dt='" + dt + '\'' +
                ", openWeatherMapDTO=" + openWeatherMapDTO +
                ", sysDTO=" + sysDTO +
                ", cityId='" + cityId + '\'' +
                ", cityName='" + cityName + '\'' +
                ", httpCode='" + httpCode + '\'' +
                ", rainDTO=" + rainDTO +
                ", cloudDTO=" + cloudDTO +
                ", windDTO=" + windDTO +
                '}';
    }

}
