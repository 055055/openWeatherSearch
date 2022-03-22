package com.example.ipinfoweather.client;

import com.example.ipinfoweather.config.FeignConfig;
import com.example.ipinfoweather.dto.IpinfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "ipinfo-client", url = "${router.ip-info.url}", configuration =
        FeignConfig.class)
public interface IpinfoClient {

    @RequestMapping(method = RequestMethod.GET)
    IpinfoDTO getIpinfo();
}
