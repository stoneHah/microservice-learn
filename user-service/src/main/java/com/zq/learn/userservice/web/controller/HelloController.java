package com.zq.learn.userservice.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author qun.zheng
 * @create 2018/7/6
 **/
@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/hello")
    public String index(){
        ServiceInstance localServiceInstance = discoveryClient.getLocalServiceInstance();
        logger.info("/hello, host:{},serviceId:{}",localServiceInstance.getHost(),localServiceInstance.getServiceId());
        return "Hello World";
    }
}
