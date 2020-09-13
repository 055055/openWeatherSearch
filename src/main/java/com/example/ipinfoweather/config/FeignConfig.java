package com.example.ipinfoweather.config;

import feign.Contract;
import feign.Logger;
import feign.Retryer;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class FeignConfig {


    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("user","pwd");
   }

    @Bean
    Retryer retryer(){
        return new Retryer.Default(1000,2000,3);
    }



    @Bean
    Logger.Level fegignLoggerLevel(){
        return Logger.Level.FULL;
    }
}



