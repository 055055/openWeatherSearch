package com.example.ipinfoweather.dto;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class IpinfoDTO {
    private String ip;
    private String city;
    private String region;
    private String country;
    private String loc;
    private String org;
}
