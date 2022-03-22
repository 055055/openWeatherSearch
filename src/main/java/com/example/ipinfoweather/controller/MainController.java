package com.example.ipinfoweather.controller;

import com.example.ipinfoweather.dto.ForeCastWeatherDTO;
import com.example.ipinfoweather.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
public class MainController {
    @Value("${googleMap.api.key}")
    private String googleMapApiKey;

    @Value("${openWeather.api.key}")
    private String openWeatherApiKey;

    @Autowired
    MainService mainService;

    @GetMapping("/main")
    public String main(ModelMap model) throws Exception {
        ForeCastWeatherDTO foreCastWeatherDTO = mainService.getIplocationWeather();

        model.addAttribute("foreCastWeatherDTO", foreCastWeatherDTO);
        model.addAttribute("googleMapApiKey", googleMapApiKey);
        model.addAttribute("openWeatherApiKey", openWeatherApiKey);

        return "index.html";
    }

    @GetMapping("/{cityName}")
    public String search(@PathVariable String cityName, ModelMap model) throws Exception {
        try {
            String upperCityName = cityName.toUpperCase();
            ForeCastWeatherDTO foreCastWeatherDTO = mainService.getLocationWeather(null, null, upperCityName);

            model.addAttribute("foreCastWeatherDTO", foreCastWeatherDTO);
            model.addAttribute("googleMapApiKey", googleMapApiKey);
            model.addAttribute("openWeatherApiKey", openWeatherApiKey);

        } catch (Exception e) {
            log.error("Exception : ", e);
            throw new Exception();
        } finally {
            return "index.html";
        }
    }
}
