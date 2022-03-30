package com.example.ipinfoweather.controller;

import com.example.ipinfoweather.dto.ForeCastWeatherDTO;
import com.example.ipinfoweather.service.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.ExecutionException;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MainController {
    private final MainService mainService;

    @Value("${router.google-map.key}")
    private String googleMapApiKey;

    @Value("${router.open-weather.key}")
    private String openWeatherApiKey;


    @GetMapping("/main")
    public String main(ModelMap model) throws ExecutionException, InterruptedException {
        ForeCastWeatherDTO foreCastWeatherDTO = mainService.getWeatherByIpAddress();

        model.addAttribute("foreCastWeatherDTO", foreCastWeatherDTO);
        model.addAttribute("googleMapApiKey", googleMapApiKey);
        model.addAttribute("openWeatherApiKey", openWeatherApiKey);
        return "index.html";
    }

    @GetMapping("/{cityName}")
    public String search(@PathVariable String cityName, ModelMap model) {
        ForeCastWeatherDTO foreCastWeatherDTO = mainService.getWeatherByCityName(cityName.toUpperCase());

        model.addAttribute("foreCastWeatherDTO", foreCastWeatherDTO);
        model.addAttribute("googleMapApiKey", googleMapApiKey);
        model.addAttribute("openWeatherApiKey", openWeatherApiKey);
        return "index.html";
    }
}
