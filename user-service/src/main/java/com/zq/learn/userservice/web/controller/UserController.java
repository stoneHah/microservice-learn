package com.zq.learn.userservice.web.controller;

import com.zq.learn.energyservice.api.dto.TimeRegion;
import com.zq.learn.userservice.entity.User;
import com.zq.learn.userservice.service.IEnergyService;
import com.zq.learn.userservice.service.IFeignEnergyService;
import com.zq.learn.userservice.web.feign.EnergyFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
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

    @Autowired
    private IEnergyService energyService;

    @Autowired
    private IFeignEnergyService feignEnergyService;

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

    @GetMapping("/electricInfo")
    public String electricInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("dayElectric:" + energyService.getDayElectric()).append("\n")
                .append("monthElectric:" + energyService.getMonthElectric(new Date())).append("\n")
                .append("pointValues:" + energyService.getPointValues(new Date())).append("\n")
                .append("regionPointValues:" + energyService.getPointValues(new TimeRegion(new Date(),new Date())));
        return sb.toString();
    }

    @GetMapping("/electricInfo1")
    public String electricInfo1(){
        StringBuilder sb = new StringBuilder();
        sb.append("dayElectric:" + feignEnergyService.getDayElectric()).append("\n")
                .append("monthElectric:" + feignEnergyService.getMonthElectric(new Date())).append("\n")
                .append("pointValues:" + feignEnergyService.getPointValues(new Date())).append("\n")
                .append("regionPointValues:" + feignEnergyService.getPointValues(new TimeRegion(new Date(),new Date())));
        return sb.toString();
    }

    @GetMapping("/usedMonthElectric/{userId}")
    public Double getUsedElectricByMonth(@PathVariable("userId") long userId) {
        return feignEnergyService.getMonthElectric(new Date());
    }
}
