package com.example.ipinfoweather.type;

public enum RecommendCity {
    Seoul("seoul", "KR"),
    Kwangju("kwangju", "KR"),
    Jeonju("jeonju","KR"),
    Seongnam("seongnam","KR"),
    Incheon("incheon","KR"),
    Daegu("daegu","KR"),
    Daejeon("daejeon","KR"),
    Busan("busan","KR"),
    Ulsan("ulsan","KR"),
    Yeosu("yeosu", "KR"),
    Hwacheon("hwacheon","KR"),
    Tokyo("tokyo","JP"),
    Kyoto("kyoto","JP"),
    Osaka("osaka","JP"),
    Beijing("beijing","CN"),
    Shanghai("shanghai","CN"),
    London("london","GB");

    final String city;
    final String country;

    private RecommendCity(String city, String country){
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getCountry(){
        return country;
    }
}
