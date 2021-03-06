package com.example.ipinfoweather.service;

import com.example.ipinfoweather.client.IpinfoClient;
import com.example.ipinfoweather.client.OpenWeatherClient;
import com.example.ipinfoweather.dto.ForeCastWeatherDTO;
import com.example.ipinfoweather.dto.IpinfoDTO;
import com.example.ipinfoweather.dto.WeatherDTO;
import com.example.ipinfoweather.error.ServiceError;
import com.example.ipinfoweather.error.ServiceException;
import com.example.ipinfoweather.type.RecommendCity;
import feign.Feign;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.commons.httpclient.OkHttpClientFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

@Slf4j
@Service
@RequiredArgsConstructor
public class MainService {

    private final IpinfoClient ipinfoClient;
    private final OpenWeatherClient openWeatherClient;



    @Value("${openWeather.api.uri}")
    private String openWeatherApi;

    @Value("${openWeather.api.key}")
    private String openWeatherApiKey;


    public ForeCastWeatherDTO getIplocationWeather() throws Exception{
        log.debug("getIplocationWeather");
        ForeCastWeatherDTO result;
        try {
            IpinfoDTO ipinfoDTO = ipinfoClient.getIpinfo();
            log.info(ipinfoDTO.toString());
            String [] splitLoc = ipinfoDTO.getLoc().split(",");
            log.debug("loc  :  "+splitLoc[0]+","+splitLoc[1]);
            result = getLocationWeather(splitLoc[0], splitLoc[1], null);
        }catch (RestClientException ex){
            log.error("{getIplocationWeather ex}",ex);
            throw new ServiceException(ServiceError.INTERNAL_SERVCER_ERROR);
        }catch (Exception e){
            log.error("{getIplocationWeather e}",e);
            throw new ServiceException(ServiceError.INTERNAL_SERVCER_ERROR);
        }
        return result;
    }

    @Cacheable(value = "055055", key="#cityName")

    public ForeCastWeatherDTO getLocationWeather(String lat, String loc, String cityName) throws ServiceException {
        log.debug("getLocationWeather");
        ForeCastWeatherDTO foreCastWeatherDTO;
        WeatherDTO weatherDTO;
        UriComponents uri;


        if(cityName!=null){
            weatherDTO = openWeatherClient.getCityWeather(cityName,"metric",openWeatherApiKey);
        }else{
            weatherDTO = openWeatherClient.getLocationWeather(lat,loc,"metric",openWeatherApiKey);
        }

        try{
            //i want currentWaether and correct cityName on opweathermapAPI
            //converting linux time to date
            weatherDTO.getSysDTO().setSunriseConverting(timeConvert(weatherDTO.getSysDTO().getSunrise()));
            weatherDTO.getSysDTO().setSunsetConverting(timeConvert(weatherDTO.getSysDTO().getSunset()));
            weatherDTO.setConvertDt(timeConvert(weatherDTO.getDt()));
            log.debug(weatherDTO.toString());

            foreCastWeatherDTO = foreCast(weatherDTO.getCityName());
            foreCastWeatherDTO.setWeatherDTO(weatherDTO);
            foreCastWeatherDTO.setRecommendCities(RecommendCity.values());
            log.info("Xxxx : "+ Arrays.toString(RecommendCity.values())+" : xxxx");

        }catch (RestClientException ex){
            log.error("{getLocationWeather ex}",ex);
            throw new ServiceException(ServiceError.CITY_NOT_FOUND);
        }catch (Exception e){
            log.error("{getLocationWeather e}",e);
            throw new ServiceException(ServiceError.CITY_NOT_FOUND);
        }
        return foreCastWeatherDTO;
    }

    public String timeConvert(Long sunTime){
        //unix time to date type
        Date date = Date.from(Instant.ofEpochSecond(sunTime));
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm", Locale.KOREA);
        String formattedDate = sdf.format(date);
        return formattedDate;
    }

    public ForeCastWeatherDTO foreCast(String cityName){
        log.debug("foreCast");

            try{
                ForeCastWeatherDTO foreCastWeatherDTO = openWeatherClient.getCityForecast(cityName,"metric",openWeatherApiKey);
                foreCastWeatherDTO.getForeCastList().stream().forEach(x->x.setConvertDt(timeConvert(x.getDt())));
                System.out.println(foreCastWeatherDTO);
                return foreCastWeatherDTO ;
            }catch (RestClientException ex){
                log.error("{foreCast ex}",ex);
                throw new ServiceException(ServiceError.CITY_NOT_FOUND);
            }catch (Exception e){
                log.error("{foreCast e}",e);
                throw new ServiceException(ServiceError.CITY_NOT_FOUND);
            }

    }

}
