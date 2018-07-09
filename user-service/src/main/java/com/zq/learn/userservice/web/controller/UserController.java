package com.zq.learn.userservice.web.controller;

import com.zq.learn.userservice.entity.User;
import com.zq.learn.userservice.web.feign.EnergyFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author qun.zheng
 * @create 2018/7/6
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String ENERGY_SERVICE = "ENERGY-SERVICE";

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private EnergyFeignClient energyFeignClient;

    @GetMapping("/usedElectric/{userId}")
    public Double getUsedElectricByDay(@PathVariable("userId") long userId) {
        return energyFeignClient.getUsedElectricByDay();
    }

    @GetMapping("/energy-instance")
    public List<ServiceInstance> getEnergyInstances(){
        return discoveryClient.getInstances(ENERGY_SERVICE);
    }


    @GetMapping("/userInfo")
    public User getUser(){
        return new User(1, "qun.zheng");
    }
}
