package com.example.ipinfoweather.dto;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class IpInfoDto {
    private String loc;

    public String getLatitude(){
        return this.loc.split(",")[0];
    }

    public String getLongitude(){
        return this.loc.split(",")[1];
    }
}
