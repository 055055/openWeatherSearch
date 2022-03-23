package com.example.ipinfoweather.service;

import com.example.ipinfoweather.client.IpInfoClient;
import com.example.ipinfoweather.client.OpenWeatherClient;
import com.example.ipinfoweather.dto.ForeCastWeatherDTO;
import com.example.ipinfoweather.dto.IpInfoDto;
import com.example.ipinfoweather.dto.WeatherDTO;
import com.example.ipinfoweather.type.RecommendCity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

@Slf4j
@Service
@RequiredArgsConstructor
public class MainService {
    private final IpInfoClient ipinfoClient;
    private final OpenWeatherClient openWeatherClient;

    @Value("${router.open-weather.url}")
    private String openWeatherApi;

    @Value("${router.open-weather.key}")
    private String openWeatherApiKey;

    public ForeCastWeatherDTO getWeatherByIpAddress() {
        return getWeatherByLocation(ipinfoClient.getIpInfo());
    }

    public ForeCastWeatherDTO getWeatherByCityName(String cityName) {
        WeatherDTO weatherDTO = openWeatherClient.getCityWeather(cityName, "metric", openWeatherApiKey);

        weatherDTO.getSysDTO().setSunriseConverting(timeConvert(weatherDTO.getSysDTO().getSunrise()));
        weatherDTO.getSysDTO().setSunsetConverting(timeConvert(weatherDTO.getSysDTO().getSunset()));
        weatherDTO.setConvertDt(timeConvert(weatherDTO.getDt()));
        log.debug(weatherDTO.toString());

        ForeCastWeatherDTO foreCastWeatherDTO = openWeatherClient.getCityForecast(
                cityName,
                "metric", openWeatherApiKey
        );

        foreCastWeatherDTO.setWeatherDTO(weatherDTO);
        foreCastWeatherDTO.setRecommendCities(RecommendCity.values());

        return foreCastWeatherDTO;
    }

    public ForeCastWeatherDTO getWeatherByLocation(IpInfoDto ipInfoDto) {

        WeatherDTO weatherDTO = openWeatherClient.getLocationWeather(
                ipInfoDto.getLatitude(),
                ipInfoDto.getLongitude(),
                "metric", openWeatherApiKey
        );

        weatherDTO.getSysDTO().setSunriseConverting(timeConvert(weatherDTO.getSysDTO().getSunrise()));
        weatherDTO.getSysDTO().setSunsetConverting(timeConvert(weatherDTO.getSysDTO().getSunset()));
        weatherDTO.setConvertDt(timeConvert(weatherDTO.getDt()));
        log.debug(weatherDTO.toString());

        ForeCastWeatherDTO foreCastWeatherDTO = openWeatherClient.getLocationForecast(
                ipInfoDto.getLatitude(),
                ipInfoDto.getLongitude(),
                "metric", openWeatherApiKey
        );


        foreCastWeatherDTO.setWeatherDTO(weatherDTO);
        foreCastWeatherDTO.setRecommendCities(RecommendCity.values());

        return foreCastWeatherDTO;
    }

    public String timeConvert(Long sunTime) {
        //unix time to date type
        Date date = Date.from(Instant.ofEpochSecond(sunTime));
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm", Locale.KOREA);
        String formattedDate = sdf.format(date);
        return formattedDate;
    }
}
