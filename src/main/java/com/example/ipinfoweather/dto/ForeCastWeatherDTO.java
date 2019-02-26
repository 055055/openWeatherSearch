package com.example.ipinfoweather.dto;

import com.example.ipinfoweather.type.RecommendCity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class ForeCastWeatherDTO {

    @JsonProperty("city")
    private CityDTO cityDTO;

    @JsonProperty("country")
    private String country;

    @JsonProperty("cnt")
    private int cnt;

    @JsonProperty("list")
    private List<WeatherDTO> foreCastList;

    @JsonProperty("weatherDTO")
    private WeatherDTO weatherDTO;

    @JsonProperty("RecommendCity")
    private RecommendCity[] recommendCities;

    @Override
    public String toString() {
        return "ForeCastWeatherDTO{" +
                "cityDTO=" + cityDTO +
                ", country='" + country + '\'' +
                ", cnt=" + cnt +
                ", foreCastList=" + foreCastList +
                ", weatherDTO=" + weatherDTO +
                ", recommendCities=" + Arrays.toString(recommendCities) +
                '}';
    }
}
