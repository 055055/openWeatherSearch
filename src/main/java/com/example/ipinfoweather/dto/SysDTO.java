package com.example.ipinfoweather.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SysDTO {
    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private String id;

    @JsonProperty("message")
    private String message;

    @JsonProperty("country")
    private String country;

    @JsonProperty("sunrise")
    private Long sunrise;

    @JsonProperty("sunset")
    private Long sunset;

    private String sunriseConverting;

    private String sunsetConverting;

    @Override
    public String toString() {
        return "SysDTO{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", message='" + message + '\'' +
                ", country='" + country + '\'' +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                ", sunriseConverting='" + sunriseConverting + '\'' +
                ", sunsetConverting='" + sunsetConverting + '\'' +
                '}';
    }

}
