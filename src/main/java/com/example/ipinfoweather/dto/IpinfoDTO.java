package com.example.ipinfoweather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
public class IpinfoDTO {
    @JsonProperty("ip")
    private String ip;
    @JsonProperty("city")
    private String city;
    @JsonProperty("region")
    private String region;
    @JsonProperty("country")
    private String country;
    @JsonProperty("loc")
    private String loc;
    @JsonProperty("org")
    private String org;

    @Override
    public String toString() {
        return "IpinfoDTO{" +
                "ip='" + ip + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", Ioc='" + loc + '\'' +
                ", org='" + org + '\'' +
                '}';
    }
}
