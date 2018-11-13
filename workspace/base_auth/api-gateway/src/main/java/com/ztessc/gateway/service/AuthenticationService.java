package com.ztessc.gateway.service;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ztessc.base.entity.Identify;


@FeignClient(value="AUTHENTICATION-SERVICE")
public interface AuthenticationService {


    /**
     * 功能描述：调用生产者端的轨迹处理方法
     * @param identify
     */
    @RequestMapping(value = "/identify" ,method = RequestMethod.POST)
    Map<String,Object> identify(@RequestBody Identify identify);

}
