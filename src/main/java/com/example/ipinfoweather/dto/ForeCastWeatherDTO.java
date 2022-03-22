package com.example.ipinfoweather.dto;

import com.example.ipinfoweather.type.RecommendCity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class ForeCastWeatherDTO {

    @JsonProperty("city")
    private CityDTO cityDTO;

    private String country;
    private int cnt;

    @JsonProperty("list")
    private List<WeatherDTO> foreCastList;

    @JsonProperty("weatherDTO")
    private WeatherDTO weatherDTO;

    @JsonProperty("RecommendCity")
    private RecommendCity[] recommendCities;
}
