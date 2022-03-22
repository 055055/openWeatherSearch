package com.example.ipinfoweather.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class SysDTO {
    private String type;
    private String id;
    private String message;
    private String country;
    private Long sunrise;
    private Long sunset;
    private String sunriseConverting;
    private String sunsetConverting;
}
