package com.example.ipinfoweather.service;

import com.example.ipinfoweather.dto.IpinfoDTO;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class MainServiceTest {
    @Value("${Ipinfo.address}")
    private String IpinfoAddress;

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void getIplocationWeatherTest(){
       IpinfoDTO ipinfoDTO = restTemplate.getForObject(IpinfoAddress,IpinfoDTO.class);
        System.out.println(ipinfoDTO.toString());
        assertThat(ipinfoDTO.getCountry()).isEqualTo("KR");
    }
}
