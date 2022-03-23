package com.example.ipinfoweather.client;

import com.example.ipinfoweather.config.FeignConfig;
import com.example.ipinfoweather.dto.IpInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "ipinfo-client", url = "${router.ip-info.url}", configuration =
        FeignConfig.class)
public interface IpInfoClient {

    @RequestMapping(method = RequestMethod.GET)
    IpInfoDto getIpInfo();
}
