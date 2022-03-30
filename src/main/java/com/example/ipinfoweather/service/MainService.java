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

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;
import java.util.concurrent.CompletableFuture;

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

    private final static String WEATHER_INFO_UNITS = "metric";


    public ForeCastWeatherDTO getWeatherByIpAddress() {
        return getWeatherByLocation(ipinfoClient.getIpInfo());
    }

    public ForeCastWeatherDTO getWeatherByCityName(String cityName) {
        try {
            return CompletableFuture.supplyAsync(() ->
                            openWeatherClient.getCityWeather(cityName, WEATHER_INFO_UNITS, openWeatherApiKey)
                    ).thenApplyAsync(this::convertWeatherDateTime)
                    .thenCombine(
                            CompletableFuture.supplyAsync(() ->
                                    openWeatherClient.getCityForecast(
                                            cityName,
                                            WEATHER_INFO_UNITS, openWeatherApiKey
                                    )
                            ), (weatherDTO, foreCastWeatherDTO) -> {
                                foreCastWeatherDTO.setWeatherDTO(weatherDTO);
                                foreCastWeatherDTO.setRecommendCities(RecommendCity.values());
                                return foreCastWeatherDTO;
                            }
                    ).get();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public ForeCastWeatherDTO getWeatherByLocation(IpInfoDto ipInfoDto) {

        try {
            return CompletableFuture.supplyAsync(() ->
                            openWeatherClient.getLocationWeather(
                                    ipInfoDto.getLatitude(),
                                    ipInfoDto.getLongitude(),
                                    WEATHER_INFO_UNITS, openWeatherApiKey
                            )

                    ).thenApplyAsync(this::convertWeatherDateTime)
                    .thenCombine(
                            CompletableFuture.supplyAsync(() ->
                                    openWeatherClient.getLocationForecast(
                                            ipInfoDto.getLatitude(),
                                            ipInfoDto.getLongitude(),
                                            WEATHER_INFO_UNITS, openWeatherApiKey
                                    )
                            ), (weatherDto, forecastWeatherDto) -> {
                                forecastWeatherDto.setWeatherDTO(weatherDto);
                                forecastWeatherDto.setRecommendCities(RecommendCity.values());
                                return forecastWeatherDto;
                            }
                    ).get();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private WeatherDTO convertWeatherDateTime(WeatherDTO weatherDTO) {
        weatherDTO.getSysDTO().setSunriseConverting(timeConvert(weatherDTO.getSysDTO().getSunrise()));
        weatherDTO.getSysDTO().setSunsetConverting(timeConvert(weatherDTO.getSysDTO().getSunset()));
        weatherDTO.setConvertDt(timeConvert(weatherDTO.getDt()));
        log.debug(weatherDTO.toString());
        return weatherDTO;
    }

    public String timeConvert(Long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp),
                        TimeZone.getDefault().toZoneId())
                .format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}
