package com.example.ipinfoweather.client;


import com.example.ipinfoweather.dto.ForeCastWeatherDTO;
import com.example.ipinfoweather.dto.WeatherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "openWeather-client", url = "${openWeather.api.uri}")
public interface OpenWeatherClient {



    @RequestMapping(method = RequestMethod.POST, value = "//weather")
    WeatherDTO getLocationWeather(@RequestParam("lat")String lat, @RequestParam("lon") String lon,
                                  @RequestParam("units") String units, @RequestParam("appid")String appid);



    @RequestMapping(method = RequestMethod.POST, value = "//weather")
    WeatherDTO getCityWeather(@RequestParam("q")String cityName, @RequestParam("units") String units, @RequestParam("appid")String appid);

    @RequestMapping(method = RequestMethod.POST, value = "/forecast")
    ForeCastWeatherDTO getCityForecast(@RequestParam("q")String cityName, @RequestParam("units") String units, @RequestParam("appid")String appid);




}
